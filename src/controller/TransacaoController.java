package controller;

import View.janelaPrincipal.ConteudoCentral;
import View.janelaPrincipal.LateralTransacao;
import View.janelaPrincipal.TabelaTransacao;
import model.*;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;

public class TransacaoController {
    private final OrigemDao origemDao;
    private final CategoriaDao categoriaDao;
    private final TransacaoDao transacaoDao;
    private final LateralTransacao lateralTransacao;
    private final ConteudoCentral conteudoCentral;


    public TransacaoController(OrigemDao origemDao, CategoriaDao categoriaDao, TransacaoDao transacaoDao, LateralTransacao lateralTransacao, ConteudoCentral conteudoCentral) {
        this.origemDao = origemDao;
        this.categoriaDao = categoriaDao;
        this.transacaoDao = transacaoDao;
        this.lateralTransacao = lateralTransacao;
        this.conteudoCentral = conteudoCentral;

        configurarListeners();
        atualizarComboBoxes();
    }

    public void atualizarComboBoxes() {
        List<Origem> listaOrigens = origemDao.listar();
        List<Categoria> listaCategorias = categoriaDao.listar();
        Tipo[] listaTipos = Tipo.values();

        lateralTransacao.atualizarComboOrigens(listaOrigens);
        lateralTransacao.atualizarComboCategoria(listaCategorias);
        lateralTransacao.atualizarComboTipos(listaTipos);
    }

    private void configurarListeners() {
        lateralTransacao.getBotaoConfirmar().addActionListener(e -> {
            salvarTransacao();
            List<Transacao> listaTransacoes = transacaoDao.listar();
            conteudoCentral.getTabelaTransacoes().atualizarValores(listaTransacoes);
        });
    }

    private void testarCadastroCategoria() {
        Object categoriaInput = lateralTransacao.getCampoCategoria();

        Categoria categoriaProcessada = processarCampoCategoria(categoriaInput);

        if (categoriaProcessada != null) {
            JOptionPane.showMessageDialog(lateralTransacao,
                    "Sucesso na categoria!\n" +
                            "Input: " + categoriaInput.toString() + "\n" +
                            "Resultado no Banco: ID=" + categoriaProcessada.getId() +
                            ", Nome='" + categoriaProcessada.getNome() + "'",
                    "Teste de categoria", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(lateralTransacao,
                    "Falha ao processar a categoria. Verifique se o campo está vazio ou se houve erro no DAO.",
                    "Teste de categoria", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void testarCadastroOrigem() {
        Object origemInput = lateralTransacao.getCampoOrigem();

        Origem origemProcessada = processarCampoOrigem(origemInput);

        if (origemProcessada != null) {
            JOptionPane.showMessageDialog(lateralTransacao,
                    "Sucesso na Origem!\n" +
                            "Input: " + origemInput.toString() + "\n" +
                            "Resultado no Banco: ID=" + origemProcessada.getId() +
                            ", Nome='" + origemProcessada.getNome() + "'",
                    "Teste de Origem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(lateralTransacao,
                    "Falha ao processar a Origem. Verifique se o campo está vazio ou se houve erro no DAO.",
                    "Teste de Origem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Categoria processarCampoCategoria(Object inputCampoCategoria) {
        if (inputCampoCategoria instanceof Categoria) {
            return (Categoria) inputCampoCategoria;
        } else if (inputCampoCategoria instanceof String) {
            String nomeInput = ((String) inputCampoCategoria).trim();
            if (nomeInput.isEmpty()) {
                return null;
            }

            Categoria categoriaExistente = categoriaDao.buscarNome(nomeInput);

            if(categoriaExistente != null) {
                return categoriaExistente;
            } else {
                Categoria novaCategoria = new Categoria(0, nomeInput);
                Categoria categoriaCadastrada = categoriaDao.inserir(novaCategoria);
                lateralTransacao.atualizarComboCategoria(categoriaDao.listar());

                return categoriaCadastrada;
            }
        }
        return null;
    }

    public Origem processarCampoOrigem(Object inputCampoOrigem) {

        if (inputCampoOrigem instanceof Origem) {
            return (Origem) inputCampoOrigem;
        } else if (inputCampoOrigem instanceof String) {
            String nomeInput = ((String) inputCampoOrigem).trim();
            if (nomeInput.isEmpty()) {
                return null;
            }

            Origem origemExistente = origemDao.buscarNome(nomeInput);

            if(origemExistente != null) {
                return origemExistente;
            } else {
                 Origem novaOrigem = new Origem(0, nomeInput);
                 Origem origemCadastrada = origemDao.inserir(novaOrigem);
                 lateralTransacao.atualizarComboOrigens(origemDao.listar());

                 return origemCadastrada;
            }
        }
        return null;
    }

    public void salvarTransacao() {
        try {
            // 1. Processamento e Validação da Categoria e Origem
            // Os métodos processar... devem lidar com a inserção no banco se forem novas
            Categoria categoriaFinal = processarCampoCategoria(lateralTransacao.getCampoCategoria());
            Origem origemFinal = processarCampoOrigem(lateralTransacao.getCampoOrigem());

            // 2. Validação básica (ajuste conforme suas regras)
            if (categoriaFinal == null || origemFinal == null || lateralTransacao.getCampoValor() <= 0) {
                JOptionPane.showMessageDialog(lateralTransacao, "Preencha todos os campos obrigatórios (Categoria, Origem e Valor).");
                return;
            }

            // 3. Montar o Objeto Transacao
            Transacao novaTransacao = new Transacao();
            novaTransacao.setTipo(lateralTransacao.getComboTipos());
            novaTransacao.setData(lateralTransacao.getCampoData());
            novaTransacao.setCategoria(categoriaFinal);
            novaTransacao.setOrigem(origemFinal);
            novaTransacao.setValor(lateralTransacao.getCampoValor());
            novaTransacao.setObservacoes(lateralTransacao.getCampoObservacoes());

            // 4. Inserir no Banco de Dados
            Transacao transacaoCadastrada = transacaoDao.inserir(novaTransacao);

            if (transacaoCadastrada != null) {
                JOptionPane.showMessageDialog(lateralTransacao, "Transação (ID: " + transacaoCadastrada.getId() + ") cadastrada com sucesso!");
                // Lógica para limpar o formulário ou atualizar a tabela de listagem
            } else {
                JOptionPane.showMessageDialog(lateralTransacao, "Erro ao inserir a transação no banco de dados.", "Erro de Persistência", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(lateralTransacao, "Erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        lateralTransacao.limparCampos();
    }

    public void selecionarTransacao(int viewRowIndex) {
        TabelaTransacao tabelaTransacao = conteudoCentral.getTabelaTransacoes();
        int modelRowIndex = tabelaTransacao.convertRowIndexToModel(tabelaTransacao.getSelectedRow());

        if (modelRowIndex != -1) {
            Transacao transacaoSelecionada = tabelaTransacao.getRowA;

            lateralTransacao.exibirTransacao(transacaoSelecionada);
        }
    }

}

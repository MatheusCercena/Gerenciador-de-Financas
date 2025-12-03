package controller;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static model.ConexaoDB.getConexao;


public class TransacaoDao {
    public Transacao buscarID(int id) {
        Transacao transacao = null;
        String consulta = """
                SELECT
                    transacao.id, transacao.tipo, transacao.valor, transacao.data_transacao, transacao.observacoes
                    categoria.id, categoria.nome,
                    origem.id, origem_nome
                FROM transacao
                INNER JOIN categoria ON transacao.id_categoria = categoria.id
                INNER JOIN origem ON transacao.id_origem = origem.id
                WHERE t.id = ?""";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id_categoria = rs.getInt("categoria.id");
                String nome_categoria = rs.getString("categoria.nome");

                int id_origem = rs.getInt("origem.id");
                String nome_origem = rs.getString("origem_nome");

                int identificador = rs.getInt("transacao.id");
                Tipo tipo = Tipo.valueOf(rs.getString("transacao.tipo"));
                Categoria categoria = new Categoria(id_categoria, nome_categoria);
                Origem origem = new Origem(id_origem, nome_origem);
                double valor = rs.getDouble("transacao.valor");
                Date data = rs.getDate("transacao.data_transacao");
                String observacoes = rs.getString("transacao.observacoes");

                transacao = new Transacao(identificador, tipo, categoria, origem, valor, data, observacoes);
            }
            rs.close();
        } catch (Exception e) {e.printStackTrace();}
        return transacao;
    }

    public List<Transacao> listar() {
        List<Transacao> transacoes = new ArrayList<>();
        String consulta = """
                SELECT
                    t.id, t.tipo, t.valor, t.data_transacao, t.observacoes,
                    c.id, c.nome,
                    o.id, o.nome
                FROM transacao t
                INNER JOIN categoria c ON t.id_categoria = c.id
                INNER JOIN origem o ON t.id_origem = o.id""";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);
             ResultSet rs = pst.executeQuery();) {
            while (rs.next()) {
                int id_categoria = rs.getInt("c.id");
                String nome_categoria = rs.getString("c.nome");

                int id_origem = rs.getInt("o.id");
                String nome_origem = rs.getString("o.nome");

                int identificador = rs.getInt("t.id");
                Tipo tipo = Tipo.valueOf(rs.getString("t.tipo"));
                Categoria categoria = new Categoria(id_categoria, nome_categoria);
                Origem origem = new Origem(id_origem, nome_origem);
                double valor = rs.getDouble("t.valor");
                Date data = rs.getDate("t.data_transacao");
                String observacoes = rs.getString("t.observacoes");

                Transacao transacao = new Transacao(identificador, tipo, categoria, origem, valor, data, observacoes);
                transacoes.add(transacao);
            }
        } catch (Exception e) {e.printStackTrace();}
        return transacoes;
    }

    public Transacao inserir(Transacao transacao){
        String consulta = "insert into transacao(tipo, id_categoria, id_origem, valor, data_transacao, observacoes) values (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConexao();
            PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);) {

            pst.setString(1, transacao.getTipo().name());
            pst.setInt(2, transacao.getCategoria().getId());
            pst.setInt(3, transacao.getOrigem().getId());
            pst.setDouble(4, transacao.getValor());
            pst.setDate(5, transacao.getData());
            pst.setString(6, transacao.getObservacoes());

            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();

            if (rs.next()) {
              int id = rs.getInt(1);
              transacao.setId(id);
            }
            rs.close();
            return transacao;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean excluir(Transacao transacao){
        String consulta = "Delete from transacao where id = ?";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);
        ) {
            pst.setInt(1, transacao.getId());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {e.printStackTrace();}
        return false;
    }

    public void alterar(Transacao transacao) {
        String consulta = "update jogo set tipo = ?, id_categoria = ?, id_origem = ?, valor = ?, data_transacao = ?, observacoes = ? where id = ?";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);) {

            pst.setString(1, transacao.getTipo().name());
            pst.setInt(2, transacao.getCategoria().getId());
            pst.setInt(3, transacao.getOrigem().getId());
            pst.setDouble(4, transacao.getValor());
            pst.setDate(5, transacao.getData());
            pst.setString(6, transacao.getObservacoes());
            pst.setInt(7, transacao.getId());


            pst.executeUpdate();

        } catch (Exception e) {e.printStackTrace();}
    }
}
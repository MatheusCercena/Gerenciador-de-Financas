package Controller;

import Model.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {

    public Connection getConexao() {
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/";
        String senha = "1234";
        String user = "root";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public Transacao buscarID(int id) {
        Transacao transacao = null;
        String consulta = """
                SELECT
                    transacao.id, transacao.tipo, transacao.valor, transacao.data, transacao.parcelamento, transacao.forma_pagamento
                    categoria.id, categoria.nome,
                    origem.id, origem_nome
                FROM transacao
                INNER JOIN categoria ON t.id_categoria = c.id
                INNER JOIN origem o ON t.id_origem = o.id
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
                Date data = rs.getDate("transacao.date");
                int parcelamento = rs.getInt("transacao.parcelamento");
                FormaPagamento formaPagamento = FormaPagamento.valueOf("forma_pagamento");

                transacao = new Transacao(identificador, tipo, categoria, origem, valor, data, parcelamento, formaPagamento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transacao;
    }

    public Transacao inserir(Transacao transacao){

        return transacao;
    }

    public Transacao alterar(Transacao transacao) {
        return new Transacao();
    }

    public boolean excluir(Transacao transacao){
        return true;
    }

    public List<Transacao> listar() {
        List<Transacao> transacoes = new ArrayList<>();
        String consulta = "SELECT * from jogo";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);
             ResultSet rs = pst.executeQuery();) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return transacoes;
    }
}

//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String nome = rs.getString(2);
//                String genero = rs.getString(3);
//                Date dataLancamento = rs.getDate(4);
//                double nota = rs.getDouble(5);
//
//                Jogo jogo = new Jogo(id, nome, genero, dataLancamento, nota);
//                jogos.add(jogo);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return jogos;
//    }
//
//    public Jogo inserirJogo(Jogo jogoNovo) {
//        String consulta = "INSERT into " +
//                "jogo(nome, genero, data_lancamento, nota) " +
//                "values(?, ?, ?, ?)";
//
//        try (Connection conn = getConexao();
//             PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);){
//
//            pst.setString(1, jogoNovo.getNome());
//            pst.setString(2, jogoNovo.getGenero());
//            pst.setDate(3, jogoNovo.getDataLancamento());
//            pst.setDouble(4, jogoNovo.getNota());
//            pst.executeUpdate();
//
//            ResultSet rs = pst.getGeneratedKeys();
//            if (rs.next()) {
//                int id = rs.getInt(1);
//                jogoNovo.setId(id);
//            }
//            rs.close();
//            return jogoNovo;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public boolean excluirJogo(Jogo jogoParaExcluir) {
//        String consulta = "Delete from jogo where id = ?";
//
//        try (Connection conn = getConexao();
//             PreparedStatement pst = conn.prepareStatement(consulta); ) {
//
//            pst.setInt(1, jogoParaExcluir.getId());
//            pst.executeUpdate();
//
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Não foi possível excluir o jogo.");
//        }
//
//        return false;
//    }
//
//    public void alterarJogo(Jogo jogoParaAlterar) {
//        String consulta = "UPDATE jogo set nome = ?, genero = ?, data_lancamento = ?, nota = ? where id = ?";
//
//        try (Connection conn = getConexao();
//             PreparedStatement pst = conn.prepareStatement(consulta);) {
//
//            pst.setString(1, jogoParaAlterar.getNome());
//            pst.setString(2, jogoParaAlterar.getGenero());
//            pst.setDate(3, jogoParaAlterar.getDataLancamento());
//            pst.setDouble(4, jogoParaAlterar.getNota());
//
//            pst.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
//
//
//
//

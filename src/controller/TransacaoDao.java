package controller;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static model.ConexaoDB.getConexao;


public class TransacaoDao {
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
                int usuario = rs.getInt("transacao.id_usuario");
                Tipo tipo = Tipo.valueOf(rs.getString("transacao.tipo"));
                Categoria categoria = new Categoria(id_categoria, nome_categoria);
                Origem origem = new Origem(id_origem, nome_origem);
                double valor = rs.getDouble("transacao.valor");
                Date data = rs.getDate("transacao.date");
                int parcelamento = rs.getInt("transacao.parcelamento");

                transacao = new Transacao(identificador, usuario, tipo, categoria, origem, valor, data);
            }
            rs.close();
        } catch (Exception e) {e.printStackTrace();}
        return transacao;
    }

    public List<Transacao> listar() {
        List<Transacao> transacoes = new ArrayList<>();
        String consulta = """
                SELECT
                    transacao.id, transacao.tipo, transacao.valor, transacao.data, transacao.parcelamento, transacao.forma_pagamento
                    categoria.id, categoria.nome,
                    origem.id, origem_nome
                FROM transacao
                INNER JOIN categoria ON t.id_categoria = c.id
                INNER JOIN origem o ON t.id_origem = o.id""";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);
             ResultSet rs = pst.executeQuery();) {
            while (rs.next()) {
                int id_categoria = rs.getInt("categoria.id");
                String nome_categoria = rs.getString("categoria.nome");

                int id_origem = rs.getInt("origem.id");
                String nome_origem = rs.getString("origem_nome");

                int identificador = rs.getInt("transacao.id");
                int usuario = rs.getInt("transacao.id_usuario");
                Tipo tipo = Tipo.valueOf(rs.getString("transacao.tipo"));
                Categoria categoria = new Categoria(id_categoria, nome_categoria);
                Origem origem = new Origem(id_origem, nome_origem);
                double valor = rs.getDouble("transacao.valor");
                Date data = rs.getDate("transacao.date");
                int parcelamento = rs.getInt("transacao.parcelamento");

                Transacao transacao = new Transacao(identificador, usuario, tipo, categoria, origem, valor, data);
                transacoes.add(transacao);
            }
        } catch (Exception e) {e.printStackTrace();}
        return transacoes;
    }

    public Transacao inserir(Transacao transacao){
        String consulta = "insert into transacao(id_usuario, tipo, categoria, origem, valor, data, parcelamento, forma_pagamento) values (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConexao();
            PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);) {

            pst.setInt(1, transacao.getIdUsuario());
            pst.setString(2, transacao.getTipo().name());
            pst.setString(3, transacao.getCategoria().getNome());
            pst.setString(4, transacao.getOrigem().getNome());
            pst.setDouble(5, transacao.getValor());
            pst.setDate(6, transacao.getData());

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
        String consulta = "update jogo set tipo = ?, categoria = ?, origem = ?, valor = ?, data = ? where id = ?";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);) {

            pst.setString(1, transacao.getTipo().name());
            pst.setString(2, transacao.getCategoria().getNome());
            pst.setString(3, transacao.getOrigem().getNome());
            pst.setDouble(4, transacao.getValor());
            pst.setDate(5, transacao.getData());
            pst.setInt(6, transacao.getId());

            pst.executeUpdate();

        } catch (Exception e) {e.printStackTrace();}
    }
}
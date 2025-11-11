package controller;

import model.Origem;
import static model.ConexaoDB.getConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrigemDao {
    public Origem buscarId(int id) {
        Origem origem = null;
        String consulta = "SELECT nome from categoria where id = ?";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String nome = rs.getString(2);
                origem = new Origem(id, nome);
            }
            rs.close();
        } catch (Exception e) {e.printStackTrace();}

        return origem;
    }

    public Origem inserir (Origem origem){
        String consulta = "insert into categoria (nome) values (?)";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);) {

            pst.setString(1, origem.getNome());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                origem.setId(id);
            }
            rs.close();
        } catch (Exception e) {e.printStackTrace();}

        return origem;
    }

    public List<Origem> listar() {
        List<Origem> origens = new ArrayList<>();
        String consulta =  "SELECT id, nome FROM categoria";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);
             ResultSet rs = pst.executeQuery();) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                Origem origem = new Origem(id, nome);

                origens.add(origem);
            }
        } catch (Exception e) {e.printStackTrace();}

        return origens;
    }

    public void alterar(Origem origem) {
        String consulta = "update origem set nome = ? where id = ?";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);) {

            pst.setInt(1, origem.getId());
            pst.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }

    public boolean excluir(Origem origem) {
        String consulta = "DELETE from origem WHERE id = ?";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta)) {

            pst.setInt(1, origem.getId());
            pst.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}

        return false;
    }
}
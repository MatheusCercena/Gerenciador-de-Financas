package Controller;

import Model.Categoria;
import static Model.ConexaoDB.getConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    public Categoria buscarId(int id) {
        Categoria categoria = null;
        String consulta = "SELECT nome from categoria where id = ?";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String nome = rs.getString(2);
                categoria = new Categoria(id, nome);
            }
        } catch (Exception e) {e.printStackTrace();}

        return categoria;
    }

    public Categoria inserir (Categoria categoria){

        String consulta = "insert into categoria (nome) values (?)";

        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);) {

            pst.setString(1, categoria.getNome());
            pst.executeUpdate();




        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoria;
    }

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();

        return categorias;
    }

    public Categoria alterar(Categoria categoria) {

        return categoria;
    }

    public boolean excluir(Categoria categoria) {

        return false;
    }



}

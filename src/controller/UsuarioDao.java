package controller;

import model.Usuario;
import static model.ConexaoDB.getConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    public Usuario buscarId(int id) {
        String consulta = "Select nome, email, senha from usuario where id = ?";
        Usuario usuario = null;
        try (Connection conn = getConexao();
            PreparedStatement pst = conn.prepareStatement(consulta)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String senha = rs.getString(4);
                usuario = new Usuario(id, nome, email, senha);
            }
            rs.close();
        } catch (Exception e) {e.printStackTrace();}
        return usuario;
    }
    public Usuario inserir(Usuario usuario) {
        String consulta = "insert into usuarios nome, email, senha values (?, ?)";

        try (Connection conn = getConexao();
            PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);) {

            String nome = usuario.getNome();
            String email = usuario.getEmail();

            pst.setString(1, nome);
            pst.setString(2, email);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int id = rs.getInt(1);
            usuario.setId(id);

        } catch(Exception e) {e.printStackTrace();}
        return usuario;
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        String consulta = "SELECT id, nome, email, senha from usuario where ID = ?";
        try (Connection conn = getConexao();
             PreparedStatement pst = conn.prepareStatement(consulta);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String senha = rs.getString(4);
                Usuario usuario = new Usuario(id, nome, email, senha);

                usuarios.add(usuario);
            }
        } catch (Exception e) {e.printStackTrace();}
        return usuarios;
    }

    public void alterar(Usuario usuario) {
        String consulta = "update usuario id, nome, email, senha where id = ?";

        try (Connection conn = getConexao();
            PreparedStatement pst = conn.prepareStatement(consulta);) {
            pst.setInt(1, usuario.getId());

            pst.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }

    public boolean excluir(Usuario usuario) {
        String consulta = "delete from usuario where id = ?";

        try (Connection conn = getConexao();
            PreparedStatement pst = conn.prepareStatement(consulta)) {

            pst.setInt(1, usuario.getId());
            pst.executeUpdate();

            return true;
        } catch (Exception e) {e.printStackTrace();}

        return false;
    }




}

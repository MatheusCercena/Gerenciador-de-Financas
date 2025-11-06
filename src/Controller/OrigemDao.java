package Controller;

import Model.Categoria;
import Model.Origem;

import static Model.ConexaoDB.getConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrigemDao {

    public Origem buscarId(int id) {
        Origem origem = new Origem();

        return origem;
    }

    public Origem inserir (Origem origem){

        return origem;
    }

    public List<Origem> listar() {
        List<Origem> origens = new ArrayList<>();

        return origens;
    }

    public Origem alterar(Origem origem) {

        return origem;
    }

    public boolean excluir(Origem origem) {

        return false;
    }



}

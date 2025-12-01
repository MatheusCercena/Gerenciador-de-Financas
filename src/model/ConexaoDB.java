package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public static Connection getConexao() {
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/ies";
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

}

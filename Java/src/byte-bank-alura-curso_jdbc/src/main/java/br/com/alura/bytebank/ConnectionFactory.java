package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() {
        try {
            String SenhaDB = System.getenv("SENHA_DB");
            // System.out.println("SenhaDB: " + SenhaDB);
            String url = "jdbc:mysql://localhost:3306/byte_bank?user=root&password=" + SenhaDB;
            System.out.println("Conectando ao banco de dados...");
            return DriverManager.getConnection(url);

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}

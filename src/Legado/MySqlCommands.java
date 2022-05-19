package Legado;

import DBConnection.DatabaseConnection;
import bridge.modelo.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlCommands {
    Connection conn = null;

    public MySqlCommands() {
        this.conn = DatabaseConnection.getConnection();
    }

    public void mySqlInsert(String nome, double preco){
        try{
            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery(
                    String.format("insert into produtos (nome, descri, preco," +
                            " status) values (%s, '', %f, false);",nome,preco)
            );

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mySqlUpdate(int id, String nome, double preco){

    }

    public void mySqlDelete(int id){

    }
}

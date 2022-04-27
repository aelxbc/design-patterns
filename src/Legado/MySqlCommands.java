package Legado;

import bridge.modelo.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlCommands {
    Connection conn = null;

    public MySqlCommands(Connection conn) {
        this.conn = conn;
    }

    public void mySqlInsert(String nome, double preco){

    }

    public void mySqlUpdate(int id, String nome, double preco){

    }

    public void mySqlDelete(int id){

    }
}

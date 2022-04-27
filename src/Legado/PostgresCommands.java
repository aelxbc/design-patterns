package Legado;

import java.sql.Connection;

public class PostgresCommands{
    Connection conn = null;

    public PostgresCommands(Connection conn) {
        this.conn = conn;
    }

    public void postgresInsert(String nome, double preco){

    }

    public void postgresUpdate(int id, String nome, double preco){

    }

    public void postgresDelete(int id){

    }
}

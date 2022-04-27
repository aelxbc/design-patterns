package Adapter;

import DBConnection.ObjectAdapter;
import DBConnection.ClassAdapter;
import DBConnection.DBCommands;
import DBConnection.DatabaseConnection;
import Legado.MySqlCommands;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();

        DBCommands db = new ObjectAdapter(new MySqlCommands(connection));

        db.insert("Impressora 3d", 8000);

        ClassAdapter cm = new ClassAdapter(connection);
        cm.insert("Teclado Encanador",90);
    }
}
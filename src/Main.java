import DBConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        Connection connection2 = DatabaseConnection.getConnection();
        Connection connection3 = DatabaseConnection.getConnection();

        System.out.println(connection);
        System.out.println(connection2);
        System.out.println(connection3);

    }
}
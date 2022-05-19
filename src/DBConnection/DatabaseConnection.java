package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static Connection connection = null;

    private DatabaseConnection() {
    }

    public static Connection getConnection() {

        if (connection == null) {

            String url = "jdbc:postgresql://localhost:5432/movies";
//            String urlSqlite = "jdbc:sqlite:E:\\Aulas\\Java\\designpatterns" +
//                    "/produtos.db";
            String user = "dio";
            String password = "dio";

            try {
                Class.forName("org.postgresql.Driver");
//                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(url, user, password);
//                connection = DriverManager.getConnection(urlSqlite);

                System.out.println("Conexão estabelecida");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static Connection connection = null;

    private DatabaseConnection() {
    }

    public static Connection getConnection() {

        if (connection == null) {

            String url = "jdbc:postgresql://localhost:5432/produtos";
            String user = "dio";
            String password = "dio";

            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);

                System.out.println("Conexão estabelecida");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

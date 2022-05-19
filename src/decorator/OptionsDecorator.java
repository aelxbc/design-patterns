package decorator;

import DBConnection.DBCommands;
import DBConnection.DatabaseConnection;
import bridge.modelo.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OptionsDecorator extends ObjectAdapterDecorator {
    private Connection connection;

    public OptionsDecorator(DBCommands dbCommands) {
        super(dbCommands);
        connection = DatabaseConnection.getConnection();
    }

    public List<Produto> getAll() {


        List<Produto> produtos = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from produtos");

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");

                produtos.add(new Produto(nome, preco));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public Produto getByName(String name) {

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(
                    String.format("select * from produtos " +
                            "where nome like '%s'", name)
            );

            String nome = resultSet.getString("nome");
            double preco = resultSet.getDouble("preco");

            return new Produto(nome, preco);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

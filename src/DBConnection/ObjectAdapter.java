package DBConnection;

import Legado.MySqlCommands;
import bridge.modelo.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ObjectAdapter implements DBCommands{

    private MySqlCommands msql;
    private Connection connection;

    public ObjectAdapter(MySqlCommands msql) {
        this.msql = msql;
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void insert(String nome, double preco) {
        msql.mySqlInsert(nome, preco);
    }

    @Override
    public Produto getById(int id) {

        try{
            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery(
                    String.format("select * from produtos where produtos.id =" +
                            " %d;", id)
            );
            String nome = resultSet.getString("nome");
            double preco = resultSet.getDouble("preco");

            return new Produto(nome, preco);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        msql.mySqlDelete(id);
    }

    @Override
    public void update(int id, String nome, double preco) {
        msql.mySqlUpdate(id, nome, preco);
    }
}
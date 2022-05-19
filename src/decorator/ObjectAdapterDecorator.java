package decorator;

import DBConnection.DatabaseConnection;
import DBConnection.ObjectAdapter;
import Legado.MySqlCommands;
import bridge.modelo.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ObjectAdapterDecorator extends ObjectAdapter {

    public ObjectAdapterDecorator(MySqlCommands msql) {
        super(msql);
    }

    public List<Produto> getAll(int id){

        Connection connection = DatabaseConnection.getConnection();
        List<Produto> produtos = new ArrayList<>();

        try{
            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from produtos");

            while(resultSet.next()){
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");

                produtos.add(new Produto(nome, preco));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return produtos;
    }
}

package decorator;

import DBConnection.DBCommands;
import DBConnection.DatabaseConnection;
import Legado.MySqlCommands;
import bridge.modelo.Produto;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class ProductCache implements DBCommands {

    private DBCommands dbCommands;
    private Map<Integer, Produto> cache;

    public ProductCache(DBCommands dbCommands) {
        Connection connection = DatabaseConnection.getConnection();
        this.dbCommands = dbCommands;
        cache = new HashMap<>();
    }

    @Override
    public void insert(String nome, double preco) {
        dbCommands.insert(nome, preco);
    }

    @Override
    public Produto getById(int id) {
        if(cache.containsKey(id)){
            return cache.get(id);
        }

        Produto produto = dbCommands.getById(id);
        cache.put(id, produto);

        return produto;
    }

    @Override
    public void delete(int id) {
        dbCommands.delete(id);
    }

    @Override
    public void update(int id, String nome, double preco) {
        dbCommands.update(id, nome, preco);
    }

    public Produto select(){
        return null;
    }
}

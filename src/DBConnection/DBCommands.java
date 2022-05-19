package DBConnection;

import bridge.modelo.Produto;

import java.util.List;

public interface DBCommands {

    public void insert(String nome, double preco);
    public Produto getById(int id);
    public void delete(int id);
    public void update(int id, String nome, double preco);
}

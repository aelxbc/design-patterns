package DBConnection;

public interface DBCommands {

    public void insert(String nome, double preco);
    public void delete(int id);
    public void update(int id, String nome, double preco);
}

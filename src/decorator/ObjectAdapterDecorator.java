package decorator;

import DBConnection.DBCommands;
import bridge.modelo.Produto;

public abstract class ObjectAdapterDecorator implements DBCommands {

    private DBCommands dbCommands;

    public ObjectAdapterDecorator(DBCommands dbCommands) {
        this.dbCommands = dbCommands;
    }

    @Override
    public void insert(String nome, double preco) {
        dbCommands.insert(nome, preco);
    }

    @Override
    public Produto getById(int id) {
        return dbCommands.getById(id);
    }

    @Override
    public void delete(int id) {
        dbCommands.delete(id);
    }

    @Override
    public void update(int id, String nome, double preco) {
        dbCommands.update(id, nome, preco);
    }
}

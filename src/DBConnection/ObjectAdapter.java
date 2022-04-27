package DBConnection;

import Legado.MySqlCommands;
import bridge.modelo.Produto;

public class ObjectAdapter implements DBCommands{

    private MySqlCommands msql;

    public ObjectAdapter(MySqlCommands msql) {
        this.msql = msql;
    }

    @Override
    public void insert(String nome, double preco) {
        msql.mySqlInsert(nome, preco);
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
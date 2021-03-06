package DBConnection;

import Legado.PostgresCommands;
import bridge.modelo.Produto;

import java.sql.Connection;

public class ClassAdapter extends PostgresCommands implements DBCommands{


    public ClassAdapter(Connection conn) {
        super(conn);
    }

    @Override
    public void insert(String nome, double preco) {
        super.postgresInsert(nome, preco);
    }

    @Override
    public Produto getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        super.postgresDelete(id);
    }

    @Override
    public void update(int id, String nome, double preco) {
        super.postgresUpdate(id, nome, preco);
    }
}

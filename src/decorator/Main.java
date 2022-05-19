package decorator;

import DBConnection.DBCommands;
import Legado.MySqlCommands;
import bridge.modelo.Produto;

public class Main {
    public static void main(String[] args) {

        DBCommands oa =
                new ObjectAdapterDecorator(new MySqlCommands());

        Produto p = oa.getById(1001);

    }
}

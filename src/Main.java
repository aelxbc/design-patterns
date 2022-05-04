import DBConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bridge.exibicao.ExibeRelatorioNoConsole;
import bridge.modelo.Produto;
import bridge.relatorios.GeradorDeRelatorio;
import bridge.relatorios.RelatorioSimples;
import composite.TrechoAereoSimples;

public class Main {

    public static void main(String[] args) {
//        Connection connection = DatabaseConnection.getConnection();
//        Connection connection2 = DatabaseConnection.getConnection();
//        Connection connection3 = DatabaseConnection.getConnection();
//
//        System.out.println(connection);
//        System.out.println(connection2);
//        System.out.println(connection3);
//
//        List<Produto> produtos = new ArrayList<>();
//
//        produtos.add(new Produto("Notebook", 2999.99));
//        produtos.add(new Produto("Smartphone", 1999.99));
//        produtos.add(new Produto("Airpods", 699.99));
//        produtos.add(new Produto("Caneta inteligente", 99.99));
//
//        System.out.println(produtos);
//
//        ExibeRelatorioNoConsole erc = new ExibeRelatorioNoConsole();
//        GeradorDeRelatorio rs = new RelatorioSimples(erc);
//        rs.geraRelatorios(produtos);

        TrechoAereoSimples tas1 = new TrechoAereoSimples("Macapá", "Belém", 250);
        TrechoAereoSimples tas2 = new TrechoAereoSimples("Belém", "Brasília", 200);
        System.out.println(tas1.getOrigem() + " -> " + tas1.getDestino() + ". Valor: " + tas1.getPreco());
        System.out.println(tas2.getOrigem() + " -> " + tas2.getDestino() + ". Valor: " + tas2.getPreco());
    }
}
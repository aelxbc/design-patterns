import DBConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bridge.exibicao.ExibeRelatorioNoConsole;
import bridge.modelo.Produto;
import bridge.relatorios.GeradorDeRelatorio;
import bridge.relatorios.RelatorioDetalhado;
import bridge.relatorios.RelatorioSimples;

public class Main {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

//        List<Produto> produtos = new ArrayList<>();
//
//        produtos.add(new Produto("Notebook", 2999.99));
//        produtos.add(new Produto("Smartphone", 1999.99));
//        produtos.add(new Produto("Airpods", 699.99));
//        produtos.add(new Produto("Caneta inteligente", 99.99));

        List<Produto> produtos = getProdutos(connection);

        ExibeRelatorioNoConsole erc = new ExibeRelatorioNoConsole();
        GeradorDeRelatorio rs = new RelatorioSimples(erc);
        GeradorDeRelatorio rd = new RelatorioDetalhado(erc);
//        rs.geraRelatorios(produtos);
        rd.geraRelatorios(produtos);
    }

    public static List<Produto> getProdutos(Connection connection){
        List<Produto> produtos = new ArrayList<>();

        try{
            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from produtos " +
                    "where status = true;");

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
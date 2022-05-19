package decorator;

import DBConnection.ObjectAdapter;
import Legado.MySqlCommands;
import bridge.exibicao.ExibeRelatorioNoConsole;
import bridge.modelo.Produto;
import bridge.relatorios.GeradorDeRelatorio;
import bridge.relatorios.RelatorioDetalhado;
import bridge.relatorios.RelatorioSimples;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductCache objectAdapter =
                new ProductCache(new ObjectAdapter(new MySqlCommands()));
        OptionsDecorator mOptions = new OptionsDecorator(objectAdapter);

        Produto p1 = mOptions.getByName("Bread - Raisin");
        Produto p2 = mOptions.getById(100);
        List<Produto> produtos = mOptions.getAll();
        List<Produto> produtos2 = new ArrayList<>();
        produtos2.add(p1);
        produtos2.add(p2);

        ExibeRelatorioNoConsole erc = new ExibeRelatorioNoConsole();
        GeradorDeRelatorio rs = new RelatorioSimples(erc);
        GeradorDeRelatorio rd = new RelatorioDetalhado(erc);
        rs.geraRelatorios(produtos);
        rd.geraRelatorios(produtos2);

        Produto c1 = mOptions.getById(20);
        Produto c2 = mOptions.getById(10);
        Produto c3 = mOptions.getById(20);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}

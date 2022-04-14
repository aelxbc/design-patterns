package bridge.relatorios;

import bridge.exibicao.ExibeRelatorio;
import bridge.modelo.Produto;
import bridge.relatorios.GeradorDeRelatorio;

import java.util.List;

public class RelatorioSimples extends GeradorDeRelatorio {

    public RelatorioSimples(ExibeRelatorio exibidor) {
        super(exibidor);
    }

    @Override
    protected String geraCorpo(List<Produto> produtos) {
        double totalDeProdutosVendidos = 0;
        StringBuilder corpo = new StringBuilder();

        for (Produto p : produtos) {
            totalDeProdutosVendidos += p.getPrecoDoProduto();
        }

        corpo.append(String.format("Quantidade vendida: %d\n",produtos.size()));
        corpo.append(String.format("Total vendido: $%.2f\n",totalDeProdutosVendidos));

        return corpo.toString();
    }

    @Override
    protected void geraExibicao(String cabecalho, String corpo) {
        this.exibeRelatorio.geraExibicaoDoRelatorio(cabecalho, corpo);

    }

}

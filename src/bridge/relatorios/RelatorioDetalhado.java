package bridge.relatorios;

import bridge.exibicao.ExibeRelatorio;
import bridge.modelo.Produto;

import java.util.List;

public class RelatorioDetalhado extends GeradorDeRelatorio{

    public RelatorioDetalhado(ExibeRelatorio exibeRelatorio){super(exibeRelatorio);}

    @Override
    protected String geraCorpo(List<Produto> produtos) {
        double totalDeProdutosVendidos = 0;
        StringBuilder corpo = new StringBuilder();

        for (Produto p : produtos) {
            corpo.append(String.format("Nome: %s\n",p.getNomeDoProduto()));
            corpo.append(String.format("Preço: $%.2f\n",p.getPrecoDoProduto()));
            corpo.append("\n");
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

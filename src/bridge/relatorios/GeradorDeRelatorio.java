package bridge.relatorios;

import bridge.exibicao.ExibeRelatorio;
import bridge.modelo.Produto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class GeradorDeRelatorio {

   protected ExibeRelatorio exibeRelatorio;

   public GeradorDeRelatorio(ExibeRelatorio exibeRelatorio) {
      this.exibeRelatorio = exibeRelatorio;
   }

   protected String geraCabecalho() {
      SimpleDateFormat data = new SimpleDateFormat("d/M/y");

      return new String("Relatório de vendas\n" + data.format(new Date()) + "\nNemo Informática.\n");
   }

   protected abstract String geraCorpo(List<Produto> produtos);

   protected abstract void geraExibicao(String cabecalho, String corpo);

   public final void geraRelatorios(List<Produto> produtos) {
      String cabecalho = this.geraCabecalho();
      String corpo = this.geraCorpo(produtos);
      this.geraExibicao(cabecalho, corpo);
   }


}

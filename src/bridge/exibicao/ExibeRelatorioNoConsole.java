package bridge.exibicao;

public class ExibeRelatorioNoConsole implements ExibeRelatorio {

    @Override
    public void geraExibicaoDoRelatorio(String cabecalho, String corpo) {
        System.out.println(cabecalho);
        System.out.println(corpo);
    }


}

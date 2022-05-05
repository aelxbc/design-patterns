package Legado.composite;

public class TrechoSimples implements TrechoAereo {
    private String origem;
    private String destino;
    private double preco;

    public TrechoSimples(String origem, String destino, double preco) {
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
    }

    @Override
    public String getOrigem() {
        return this.origem;
    }

    @Override
    public String getDestino() {
        return this.destino;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return
                String.format("Origem: %s\n" +
                        "Destino: %s\n" +
                        "Preço: R$ %.2f\n", origem, destino, preco);
    }
}

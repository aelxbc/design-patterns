package composite;

public class TrechoAereoSimples implements TrechoAereo {

    private String origem;
    private String destino;
    private double preco;

    public TrechoAereoSimples(String origem, String destino, double preco) {
        this.origem = origem;
        this.destino = destino;
        this.preco = preco;
    }

    @Override
    public String getOrigem() {
        return origem;
    }

    @Override
    public String getDestino() {
        return destino;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return
                String.format("Origem: %s\n" +
                        "Destino: %s\n" +
                        "Preço: R$ %.2f\n", origem, destino, preco);
    }
}

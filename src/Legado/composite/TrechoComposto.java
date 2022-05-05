package Legado.composite;

public class TrechoComposto implements TrechoAereo{
    private TrechoAereo primeiro;
    private TrechoAereo segundo;
    private double taxaconexao;

    public TrechoComposto(TrechoAereo primeiro, TrechoAereo segundo, double taxaconexao) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.taxaconexao = taxaconexao;

        if(primeiro.getDestino() != segundo.getOrigem())
            throw new RuntimeException("O destino do primeiro" +
                    "não é igual a origem do segundo");
    }


    @Override
    public String getOrigem() {
        return primeiro.getOrigem();
    }

    @Override
    public String getDestino() {
        return segundo.getDestino();
    }

    @Override
    public double getPreco() {
        return primeiro.getPreco()+ segundo.getPreco()+ taxaconexao;
    }

    @Override
    public String toString() {
        String to = String.format("%s\nConexão:\n", primeiro.toString());
        String td = String.format("%s\n", segundo.toString());
        return to + td;
    }
}

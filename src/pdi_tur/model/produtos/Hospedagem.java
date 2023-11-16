package pdi_tur.model.produtos;

public class Hospedagem{
    private String hotel;
    private Destino destino;
    private boolean cafeIncluso;
    private int classificacao;

    public Hospedagem (String hotel, Destino destino, boolean cafeIncluso, int classificacao){
        super(destino);
        this.hotel = hotel;
        this.cafeIncluso = cafeIncluso;
        this.classificacao = classificacao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public String getHotel() {
        return hotel;
    }

    public boolean getCafeincluso(){
        return cafeIncluso;
    }

    public Destino getDestino(){
        return destino;
    }
}

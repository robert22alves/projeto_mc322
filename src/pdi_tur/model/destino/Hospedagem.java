package pdi_tur.model.destino;

public class Hospedagem{
   private String nameHotel;
   private int classificacao;
   private boolean cafeManha; //se tem cafe da manha

    public Hospedagem(String nameHotel, int classificacao, boolean cafeManha){
        this.nameHotel = nameHotel;
        this.classificacao = classificacao; 
        this.cafeManha = cafeManha;
    }

    public String getNameHotel(){
        return nameHotel;
    }

    public int Classificacao(){
        return classificacao;
    }

    public boolean getCafeManha(){
        return cafeManha;
    }

}

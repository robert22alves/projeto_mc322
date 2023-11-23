package pdi_tur.model.pacotes;

import pdi_tur.model.destino.Destino;
import pdi_tur.model.destino.Hospedagem;
import pdi_tur.model.singleton.CSingleton;

public class PacoteViagem extends Destino, Hospedagem, CSingleton {
    private int valor;
    private Destino destino;
    private Hospedagem hospedagem;
    private boolean primeiraClasse;
    private String companhiaAerea;
    private boolean guiaTuristico;
    private String atracoes;

    public PacoteViagem(int valor, Destino destino, Hospedagem hospedagem, boolean primeiraClasse, String companhiaAerea, boolean guiaTuristico, String atracoes){
        super();
        this.valor = valor;
        this.primeiraClasse = primeiraClasse;
        this.companhiaAerea = companhiaAerea;
        this.guiaTuristico = guiaTuristico;
        this.atracoes = atracoes;
    }
    
    public int getValor(){
        return valor;
    }

    public Destino getDestino(){
        return destino;
    }

    public Hospedagem getHospedagem(){
        return hospedagem;
    }

    public boolean getPrimeiraClasse(){
        return primeiraClasse;
    }

    public String getCompanhiaAerea(){
        return companhiaAerea;
    }

    public boolean getGuiaTuristico(){
        return guiaTuristico;
    }

    public String getAtracoes(){
        return atracoes;
    }


}
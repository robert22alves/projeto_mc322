package pdi_tur.model.pacotes;

import pdi_tur.model.destino.Destino;
import pdi_tur.model.destino.Hospedagem;
import pdi_tur.model.singleton.CSingleton;

public abstract class PacoteViagem extends Destino, Hospedagem, CSingleton implements Pacote, Reservaveis{
    private String nomePacote;
    private int valor;
    private Destino destino;
    private Hospedagem hospedagem;
    private boolean primeiraClasse;
    private String companhiaAerea;
    private boolean guiaTuristico;
    private String atracoes;

    public PacoteViagem(String nomePacote, int valor, Destino destino, Hospedagem hospedagem, boolean primeiraClasse, String companhiaAerea, boolean guiaTuristico, String atracoes){
        super();
        this.nomePacote = nomePacote;
        this.valor = valor;
        this.primeiraClasse = primeiraClasse;
        this.companhiaAerea = companhiaAerea;
        this.guiaTuristico = guiaTuristico;
        this.atracoes = atracoes;
    }

    @Override
    public String getNomePacote(){
        return nomePacote;
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

    @Override
    public String getCompanhiaAerea(){
        return companhiaAerea;
    }

    public boolean getGuiaTuristico(){
        return guiaTuristico;
    }

    @Override
    public String getAtracoes(){
        return atracoes;
    }


}
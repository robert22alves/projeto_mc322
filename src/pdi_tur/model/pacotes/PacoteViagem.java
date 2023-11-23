package pdi_tur.model.pacotes;

import pdi_tur.model.destino.Destino;
import pdi_tur.model.hospedagem.Hospedagem;
import pdi_tur.model.hospedagem.Quarto;
import pdi_tur.model.passagemAerea.PassagemAerea;

public class PacoteViagem implements Reservaveis{
    private PassagemAerea passagemAerea;
    private Hospedagem hospedagem;
    private Quarto quarto;
    private Destino destino;
    private double precopp; //Preço por pessoa
    
    public PacoteViagem(PassagemAerea passagemAerea, Hospedagem hospedagem, Quarto quarto, Destino destino,
            double precopp) {
        this.passagemAerea = passagemAerea;
        this.hospedagem = hospedagem;
        this.quarto = quarto;
        this.destino = destino;
        this.precopp = precopp;
    }

    public PassagemAerea getPassagemAerea() {
        return passagemAerea;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Destino getDestino() {
        return destino;
    }

    public double getPrecopp() {
        return precopp;
    }

}
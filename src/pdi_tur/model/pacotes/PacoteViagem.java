package pdi_tur.model.pacotes;

import pdi_tur.model.destino.Destino;
import pdi_tur.model.hospedagem.Hospedagem;
import pdi_tur.model.hospedagem.Quarto;
import pdi_tur.model.passagemAerea.PassagemAerea;

public abstract class PacoteViagem implements Reservaveis{
    protected PassagemAerea passagemAerea;
    protected Hospedagem hospedagem;
    protected Quarto quarto;
    protected Destino destino;
    protected double precopp; //Preço por pessoa
    protected CategoriasViagem categoria;
    
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

    public CategoriasViagem getCategoria() {
        return categoria;
    }
}
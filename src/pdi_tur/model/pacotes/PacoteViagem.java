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
    protected boolean isReservado;
    
    public PacoteViagem(PassagemAerea passagemAerea, Hospedagem hospedagem, Quarto quarto, Destino destino,
            double precopp) {
        this.passagemAerea = passagemAerea;
        this.hospedagem = hospedagem;
        this.quarto = quarto;
        this.destino = destino;
        this.precopp = precopp;
        this.isReservado = false;
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

    public void setPassagemAerea(PassagemAerea passagemAerea) {
        this.passagemAerea = passagemAerea;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public double getPrecopp() {
        return precopp;
    }

    public CategoriasViagem getCategoria() {
        return categoria;
    }

    @Override
    public boolean isReservado() {
        return isReservado;
    }

    @Override
    public void setReservado(boolean isReservado) {
        this.isReservado = isReservado;
    }

}
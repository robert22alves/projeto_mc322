package pdi_tur.model.pacotes;

import java.util.ArrayList;

import pdi_tur.model.destino.Destino;
import pdi_tur.model.hospedagem.Hospedagem;
import pdi_tur.model.hospedagem.Quarto;
import pdi_tur.model.passagemAerea.PassagemAerea;

public class Relaxamento extends PacoteViagem{
    private int qtdAdultos;
    private int qtdCriancas;
	private ArrayList<Integer> idadeCriancas;
    private double precoFinal;

    public Relaxamento(PassagemAerea passagemAerea, Hospedagem hospedagem, Quarto quarto, Destino destino,
            double precopp, int qtdAdultos, int qtdCriancas, ArrayList<Integer> idadeCriancas) {
        super(passagemAerea, hospedagem, quarto, destino, precopp);
        this.qtdAdultos = qtdAdultos;
        this.qtdCriancas = qtdCriancas;
        this.idadeCriancas = idadeCriancas;
        this.precoFinal = calcularPreco();
    }

    private double calcularPreco() {
        return 0;
    }

    public int getQtdAdultos() {
        return qtdAdultos;
    }

    public int getQtdCriancas() {
        return qtdCriancas;
    }

    public ArrayList<Integer> getIdadeCriancas() {
        return idadeCriancas;
    }

    public double getPrecoFinal() {
        return precoFinal;
    } 
}

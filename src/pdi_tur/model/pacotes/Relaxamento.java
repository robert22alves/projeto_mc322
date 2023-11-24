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
            double precopp) {
        super(passagemAerea, hospedagem, quarto, destino, precopp);
        this.categoria = CategoriasViagem.RELAXAMENTO;
    }

    public void calcularPreco(int qtdAdultos, int qtdCriancas, ArrayList<Integer> idadeCriancas) {
        this.qtdAdultos = qtdAdultos;
        this.qtdCriancas = qtdCriancas;
        this.idadeCriancas = idadeCriancas;

        double preco = precopp * qtdAdultos;

        for (Integer idade : idadeCriancas) {
            if (idade.intValue() < 2) {
                preco += precopp * 0.4;
            }
            else if (idade.intValue() < 12) {
                preco += precopp * 0.6;
            }
            else {
                preco += precopp * 0.8;
            }
        }

        this.precoFinal = preco;
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

    @Override
    public double getPrecoFinal() {
        return precoFinal;
    } 
}

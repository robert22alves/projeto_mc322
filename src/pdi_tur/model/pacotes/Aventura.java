package pdi_tur.model.pacotes;

import java.util.ArrayList;

import pdi_tur.model.destino.Destino;
import pdi_tur.model.hospedagem.Hospedagem;
import pdi_tur.model.hospedagem.Quarto;
import pdi_tur.model.passagemAerea.PassagemAerea;

public class Aventura extends Relaxamento{
    private ArrayList<String> atividades;

    public Aventura(PassagemAerea passagemAerea, Hospedagem hospedagem, Quarto quarto, Destino destino, double precopp,
            int qtdAdultos, int qtdCriancas, ArrayList<Integer> idadeCriancas, ArrayList<String> atividades) {
        super(passagemAerea, hospedagem, quarto, destino, precopp, qtdAdultos, qtdCriancas, idadeCriancas);
        this.atividades = atividades;
    }

    public ArrayList<String> getAtividades() {
        return atividades;
    }
}

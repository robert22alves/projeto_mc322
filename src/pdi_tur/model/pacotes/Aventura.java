package pdi_tur.model.pacotes;

import java.util.ArrayList;

import pdi_tur.model.destino.Destino;
import pdi_tur.model.hospedagem.Hospedagem;
import pdi_tur.model.hospedagem.Quarto;
import pdi_tur.model.passagemAerea.PassagemAerea;

public class Aventura extends Relaxamento{
    private ArrayList<String> atividades;

    public Aventura(PassagemAerea passagemAerea, Hospedagem hospedagem, Quarto quarto, Destino destino, double precopp,
            ArrayList<String> atividades) {
        super(passagemAerea, hospedagem, quarto, destino, precopp);
        this.atividades = atividades;
        this.categoria = CategoriasViagem.AVENTURA;
    }

    public ArrayList<String> getAtividades() {
        return atividades;
    }
}

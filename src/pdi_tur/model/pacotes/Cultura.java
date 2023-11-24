package pdi_tur.model.pacotes;

import java.util.ArrayList;

import pdi_tur.model.destino.Destino;
import pdi_tur.model.hospedagem.Hospedagem;
import pdi_tur.model.hospedagem.Quarto;
import pdi_tur.model.passagemAerea.PassagemAerea;

public class Cultura extends Relaxamento{
    private boolean guiaTuristico;
    private ArrayList<String> pontosTuristicos;
    
    public Cultura(PassagemAerea passagemAerea, Hospedagem hospedagem, Quarto quarto, Destino destino, double precopp,
            boolean guiaTuristico, ArrayList<String> pontosTuristicos) {
        super(passagemAerea, hospedagem, quarto, destino, precopp);
        this.guiaTuristico = guiaTuristico;
        this.pontosTuristicos = pontosTuristicos;
        this.categoria = CategoriasViagem.CULTURA;
    }

    public boolean isGuiaTuristico() {
        return guiaTuristico;
    }

    public ArrayList<String> getPontosTuristicos() {
        return pontosTuristicos;
    }
}

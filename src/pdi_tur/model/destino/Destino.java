package pdi_tur.model.destino;

import java.util.ArrayList;
import pdi_tur.model.pacotes.PacoteViagem;

public class Destino{
    private String destino;
    private CategoriasDestino categoria;
    private ArrayList<PacoteViagem> pacotes;

    public Destino(String destino, CategoriasDestino categoria){
        this.categoria = categoria;
        this.destino = destino;
        this.pacotes = new ArrayList<>();
    }

    public String getDestino(){
        return destino;
    }

    public CategoriasDestino getCategoria(){
        return categoria;
    }

    public ArrayList<PacoteViagem> getPacotes() {
        return pacotes;
    }

    @Override
    public String toString() {
        return destino;
    }

}
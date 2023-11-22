package pdi_tur.model.destino;

public class Destino{
    private String destino;
    private CategoriasDestino categoria;

    public Destino(String destino, CategoriasDestino categoria){
        this.categoria = categoria;
        this.destino = destino;
    }

    
}
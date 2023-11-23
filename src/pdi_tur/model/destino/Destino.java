package pdi_tur.model.destino;

public class Destino{
    private String destino;
    private CategoriasDestino categoria;

    public Destino(String destino, CategoriasDestino categoria){
        this.categoria = categoria;
        this.destino = destino;
    }

    public String getDestino(){
        return destino;
    }

    public CategoriasDestino getCategoria(){
        return categoria;
    }

    @Override
    public String toString() {
        return destino + " (" + categoria + ")";
    }

}
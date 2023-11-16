package pdi_tur.model.produtos;

public class Destino{
    private String country;
    private Categorias categoria;

    public Destino(String country, Categorias categoria){
        super(categoria);
        this.country = country;
    }

    
}
package pdi_tur.model.destino;

public enum CategoriasDestino{

    PRAIA("praia"),
    MONTANHA("montanha"),
    CIDADE("cidade"),
    SAVANA("savana"),
    RESORT("resort");
    
    private String descricao;

    private CategoriasDestino(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}

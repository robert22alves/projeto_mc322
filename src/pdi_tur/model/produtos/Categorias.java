package pdi_tur.model.produtos;

public enum Categorias{

    PRAIA("praia"),
    MONTANHA("montanha"),
    CIDADE("cidade"),
    SAVANA("savana"),
    RESORT("resort");
    
    private String descricao;

    public Categorias(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

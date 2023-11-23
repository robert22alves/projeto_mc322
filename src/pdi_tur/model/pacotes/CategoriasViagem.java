package pdi_tur.model.pacotes;

public enum CategoriasViagem {
    AVENTURA("Pacote Aventura"), 
    CULTURA("Pacote Cultura"), 
    RELAXAMENTO("Pacote Relaxamento");

    private String descricao;

    private CategoriasViagem(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}

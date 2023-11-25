package pdi_tur.model.pessoas;

public enum TipoUsuario {
    CLIENTE("Cliente"),
    ADMINISTRADOR("Administrador");

    private String descricao;

    private TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}

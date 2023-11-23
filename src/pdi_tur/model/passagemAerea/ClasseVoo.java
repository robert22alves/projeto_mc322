package pdi_tur.model.passagemAerea;

public enum ClasseVoo {
    ECONOMICA("Classe Economica"),
    EXECUTIVA("Classe Executiva"),
    PRIMEIRACLASSE("Primeira Classe");

    private String descricao;

    private ClasseVoo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}

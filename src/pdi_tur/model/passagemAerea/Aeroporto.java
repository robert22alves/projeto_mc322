package pdi_tur.model.passagemAerea;

public class Aeroporto {
    private String cidade;
    private String aeroporto;
    
    public Aeroporto(String cidade, String aeroporto) {
        this.cidade = cidade;
        this.aeroporto = aeroporto;
    }

    public String getCidade() {
        return cidade;
    }

    public String getAeroporto() {
        return aeroporto;
    }

    @Override
    public String toString() {
        return aeroporto;
    }

    @Override
    public int hashCode() {
        return cidade.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aeroporto other = (Aeroporto) obj;
        if (cidade == null) {
            if (other.cidade != null)
                return false;
        } else if (!cidade.equals(other.cidade))
            return false;
        return true;
    }
}

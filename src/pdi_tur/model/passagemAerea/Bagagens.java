package pdi_tur.model.passagemAerea;

public class Bagagens {
    protected final boolean mochila;
    protected final boolean bagagemMao;
    protected final boolean bagagemDespachar;

    public Bagagens(boolean mochila, boolean bagagemMao, boolean bagagemDespachar) {
        this.mochila = mochila;
        this.bagagemMao = bagagemMao;
        this.bagagemDespachar = bagagemDespachar;
    }

    @Override
    public String toString() {
        if (mochila || bagagemMao || bagagemDespachar) {
            String info = "";

            if (mochila) {
                info = info + "permite uma mochila ou bolsa\n";
            }
            else {
                info = info + "não permite mochila ou bolsa\n";
            }

            if (bagagemMao) {
                info = info + "permite bagagem de mão\n";
            }
            else {
                info = info + "não permite bagagem de mão\n";
            }

            if (bagagemDespachar) {
                info = info + "inclui bagagem para despachar\n";
            }
            else {
                info = info + "não inclui bagagem para despachar\n";
            }

            return info;
        }

        return "Não permite Bagagens";
    }

    
    
}

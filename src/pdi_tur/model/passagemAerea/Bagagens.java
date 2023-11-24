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
            String info = "Bagagem:\n";

            if (mochila) {
                info = info + "inclui uma mochila ou bolsa\n" + "deve caber embaixo do assento dianteiro.\n";
            }

            if (bagagemMao) {
                info = info + "inclui bagagem de mão\n" + "deve caber no compartimento superior do avião.\n";
            }

            if (bagagemDespachar) {
                info = info + "inclui bagagem para despachar\n" + "1 peça de 23Kg por adulto.\n" + "O despache é feito durante o Check-in no aeroporto.";
            }

            return info;
        }

        return "Não pode Bagagens";
    }

    
    
}

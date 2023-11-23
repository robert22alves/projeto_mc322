package pdi_tur.model.pacotes;

public interface Pacote{
    String getNomePacote();
    int getValor();
    Destino getDestino();
    Hospedagem getHospedagem();
    boolean getPrimeiraClasse();
    String getCompanhiaAerea();
    boolean getGuiaTuristico();
    String getAtracoes();

}
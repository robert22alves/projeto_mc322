package pdi_tur.model.pacotes;

import java.util.ArrayList;

public interface Reservaveis{
    double getPrecoFinal();
    boolean isReservado();
    void calcularPreco(int qtdAdultos, int qtdCriancas, ArrayList<Integer> idadeCriancas);
    void setReservado(boolean isReservado);
}
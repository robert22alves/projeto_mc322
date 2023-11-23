package pdi_tur.model.pacotes;

import java.util.ArrayList;
import pdi_tur.model.pessoas.Usuario;

public class ListaReservas<T extends Reservaveis> {

    private ArrayList<String> lista_reservas;

    public ListaReservas() {
        this.lista_reservas = new ArrayList<>();
    }

    public ArrayList<String> getLista_reservas() {
        return lista_reservas;
    }

    public void adicionarReserva(T pacote, Usuario usuario){
        lista_reservas.add(usuario + "reservou o item" + pacote);
        return;
    }

}
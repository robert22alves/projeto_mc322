package pdi_tur.model.pacotes;

import java.util.ArrayList;
import pdi_tur.model.pessoas.Usuario;

public class ListaReservas<T extends Reservaveis> {

    private ArrayList<String> listaReservas;

    public ListaReservas() {
        this.listaReservas = new ArrayList<>();
    }

    public ArrayList<String> getListaReservas() {
        return listaReservas;
    }

    public void adicionarReserva(T pacote, Usuario usuario){
        listaReservas.add(usuario + "reservou o item" + pacote);
        return;
    }

}
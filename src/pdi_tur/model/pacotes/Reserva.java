package pdi_tur.model.pacotes;

import pdi_tur.model.pessoas.Usuario;

public class Reserva extends Reservaveis{
    private String pacote;
    private Usuario usuario;
    private static int num_reservas = 0; //numero de reservas
    private static ListaReservas<Reservaveis> listaReservas = new ListaReservas<>();

    public Reserva(String pacote, Usuario usuario){
        super();
        this.pacote = Reservaveis.getNomePacote();
        Reserva.num_reservas += 1;

        listaReservas.adicionarReserva(pacote, usuario);
    }

    public Reservaveis getPacote(){
        return pacote;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public static int getNum_reservas(){
        return num_reservas;
    }

}
package pdi_tur.model.hospedagem;

import java.util.ArrayList;

import pdi_tur.model.dataHora.Horario;

public class Hospedagem{
    private String nome;
    private String endereco;
    private int distanciaCentro;
    private int classificacao;
    private Horario checkin;
    private Horario checkout;
    private Servicos servicos;
    private ArrayList<Quarto> quartos;

    public Hospedagem(String nome, String endereco, int distanciaCentro, int classificacao, Horario checkin,
        Horario checkout, Servicos servicos, ArrayList<Quarto> quartos) {
        this.nome = nome;
        this.endereco = endereco;
        this.distanciaCentro = distanciaCentro;
        this.classificacao = classificacao;
        this.checkin = checkin;
        this.checkout = checkout;
        this.servicos = servicos;
        this.quartos = quartos;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getDistanciaCentro() {
        return distanciaCentro;
    }

    public int getClassificacao() {
        return classificacao;
    }
    
    public Horario getCheckin() {
        return checkin;
    }
    
    public Horario getCheckout() {
        return checkout;
    }
    
    public Servicos getServicos() {
        return servicos;
    }
    
    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }

}

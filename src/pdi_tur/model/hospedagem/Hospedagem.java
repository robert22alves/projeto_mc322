package pdi_tur.model.hospedagem;

import pdi_tur.model.diversos.Horario;

public class Hospedagem{
    private String nome;
    private String endereco;
    private String localizacao;
    private String distanciaCentro;
    private int classificacao;
    private Horario checkin;
    private Horario checkout;
    private Servicos servicos;

    public Hospedagem(String nome, String endereco, String localizacao, String distanciaCentro, int classificacao, Horario checkin,
        Horario checkout, Servicos servicos) {
        this.nome = nome;
        this.endereco = endereco;
        this.localizacao = localizacao;
        this.distanciaCentro = distanciaCentro;
        this.classificacao = classificacao;
        this.checkin = checkin;
        this.checkout = checkout;
        this.servicos = servicos;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getDistanciaCentro() {
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

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

}

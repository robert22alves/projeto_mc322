package pdi_tur.model.passagemAerea;

import pdi_tur.model.dataHora.Data;
import pdi_tur.model.dataHora.Horario;

public class PassagemAerea {
    private String companhiaAerea;
    private ClasseVoo classe;
    private Voo ida;
    private Voo volta;
    private double tarifaAdulto;
    private double tarifaCrianca; // < 12 anos
    private double tarifaBebe; // < 2 anos
    private double imposto;
    private Bagagens bagagens;

    public PassagemAerea(String companhiaAerea, ClasseVoo classe, Voo ida, Voo volta, double tarifaAdulto,
            double tarifaCrianca, double tarifaBebe, double imposto, Bagagens bagagens) {
        this.companhiaAerea = companhiaAerea;
        this.classe = classe;
        this.ida = ida;
        this.volta = volta;
        this.tarifaAdulto = tarifaAdulto;
        this.tarifaCrianca = tarifaCrianca;
        this.tarifaBebe = tarifaBebe;
        this.imposto = imposto;
        this.bagagens = bagagens;
    }

    // Informações Voo de Ida
    public Data getDataSaidaIda() {
        return ida.dataSaida;
    }

    public Data getDataChegadaIda() {
        return ida.dataChegada;
    }

    public Horario getHorarioSaidaIda() {
        return ida.horarioSaida;
    }

    public Horario getHorarioChegadaIda() {
        return ida.horarioChegada;
    }

    public Horario getDuracaoIda() {
        return ida.duracao;
    }

    public String getIdIda() {
        return ida.id;
    }

    public String getAeroportoSaidaIda() {
        return ida.aeroportoSaida;
    }

    public String getAeroportoChegadaIda() {
        return ida.aeroportoChegada;
    }

    // Informações Voo de Volta
    public Data getDataSaidaVolta() {
        return ida.dataSaida;
    }

    public Data getDataChegadaVolta() {
        return ida.dataChegada;
    }

    public Horario getHorarioSaidaVolta() {
        return ida.horarioSaida;
    }

    public Horario getHorarioChegadaVolta() {
        return ida.horarioChegada;
    }

    public Horario getDuracaoVolta() {
        return ida.duracao;
    }

    public String getIdVolta() {
        return ida.id;
    }

    public String getAeroportoSaidaVolta() {
        return ida.aeroportoSaida;
    }

    public String getAeroportoChegadaVolta() {
        return ida.aeroportoChegada;
    }

    // Informações Bagagens
    public boolean isMochila() {
        return bagagens.mochila;
    }

    public boolean isBagagemMao() {
        return bagagens.bagagemMao;
    }

    public boolean isBagagemDespachar() {
        return bagagens.bagagemDespachar;
    }

    // Getters
    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public ClasseVoo getClasse() {
        return classe;
    }

    public Voo getIda() {
        return ida;
    }

    public Voo getVolta() {
        return volta;
    }

    public double getTarifaAdulto() {
        return tarifaAdulto;
    }

    public double getTarifaCrianca() {
        return tarifaCrianca;
    }

    public double getTarifaBebe() {
        return tarifaBebe;
    }

    public double getImposto() {
        return imposto;
    }

    public Bagagens getBagagens() {
        return bagagens;
    }

}

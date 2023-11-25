package pdi_tur.model.passagemAerea;

import pdi_tur.model.diversos.Data;
import pdi_tur.model.diversos.Horario;

public class Voo {
    protected final Data dataSaida;
    protected final Data dataChegada;
    protected final Horario horarioSaida;
    protected final Horario horarioChegada;
    protected final Horario duracao;
    protected final String id; // Numero do voo
    protected final Aeroporto aeroportoSaida;
    protected final Aeroporto aeroportoChegada;

    public Voo(Data dataSaida, Data dataChegada, Horario horarioSaida, Horario horarioChegada, Horario duracao,
            String id, Aeroporto aeroportoSaida, Aeroporto aeroportoChegada) {
        this.dataSaida = dataSaida;
        this.dataChegada = dataChegada;
        this.horarioSaida = horarioSaida;
        this.horarioChegada = horarioChegada;
        this.duracao = duracao;
        this.id = id;
        this.aeroportoSaida = aeroportoSaida;
        this.aeroportoChegada = aeroportoChegada;
    }
    
}

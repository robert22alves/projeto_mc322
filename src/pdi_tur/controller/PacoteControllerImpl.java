package pdi_tur.controller;

import java.util.ArrayList;
import java.util.HashMap;

import pdi_tur.model.diversos.Data;
import pdi_tur.model.pacotes.*;
import pdi_tur.model.passagemAerea.Aeroporto;

public class PacoteControllerImpl implements PacoteController{
    private ArrayList<PacoteViagem> pacotes;
	private HashMap<String,Aeroporto> cidades;
    
    public PacoteControllerImpl() {
    	this.pacotes = new ArrayList<>();
		this.cidades = new HashMap<>();
    }

	@Override
	public boolean adicionar(PacoteViagem pacote) {
		if(pacotes.contains(pacote)) {
			return false;
		}
		pacotes.add(pacote);
		return true;
	}

	@Override
	public boolean remover(PacoteViagem pacote) {
		if(pacotes.contains(pacote)) {
			pacotes.remove(pacote);
			return true;
		}
		return false;
	}

	@Override
	public boolean novaCidade(Aeroporto cidade) {
		if (cidades.containsKey(cidade.getCidade())) {
			return false;
		}
		cidades.put(cidade.getCidade(), cidade);
		return true;
	}

	@Override
	public Aeroporto buscarCidade(String cidade) {
		return cidades.get(cidade);
	}

	@Override
	public ArrayList<PacoteViagem> buscar(String origem, String destino, Data ida, Data volta) {
		ArrayList<PacoteViagem> busca = new ArrayList<>();

		for (PacoteViagem pacote : pacotes) {
			if (!pacote.getPassagemAerea().getAeroportoSaidaIda().getAeroporto().equals(origem)) {
				continue;
			}
			if (!pacote.getPassagemAerea().getAeroportoChegadaIda().getAeroporto().equals(destino)) {
				continue;
			}
			if (!pacote.getPassagemAerea().getDataSaidaIda().equals(ida)) {
				continue;
			}
			if (!pacote.getPassagemAerea().getDataSaidaVolta().equals(volta)) {
				continue;
			}
			if (pacote.isReservado()) {
				continue;
			}
			busca.add(pacote);
		}

		if (busca.isEmpty()) {
			return null;
		}

		return busca;
	}
    
    
}
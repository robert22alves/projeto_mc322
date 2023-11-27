package pdi_tur.controller;

import java.util.ArrayList;
import pdi_tur.model.pacotes.*;

public class PacoteControllerImpl implements PacoteController{
    private ArrayList<PacoteViagem> pacotes;
    
    public PacoteControllerImpl() {
    	this.pacotes = new ArrayList<>();
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
    
    
}
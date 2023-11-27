package pdi_tur.controller;

import pdi_tur.model.pacotes.*;

public interface PacoteController {
	boolean adicionar(PacoteViagem pacote);
	boolean remover(PacoteViagem pacote);
}
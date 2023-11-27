package pdi_tur.controller;

import java.util.ArrayList;

import pdi_tur.model.diversos.Data;
import pdi_tur.model.pacotes.*;
import pdi_tur.model.passagemAerea.Aeroporto;

public interface PacoteController {
	boolean adicionar(PacoteViagem pacote);
	boolean remover(PacoteViagem pacote);
	boolean novaCidade(Aeroporto cidade);
	Aeroporto buscarCidade(String cidade);
	ArrayList<PacoteViagem> buscar(String origem, String destino, Data ida, Data volta);
}
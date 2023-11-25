package pdi_tur.controller;

import pdi_tur.model.pessoas.Usuario;

public interface UsuarioController {
    Usuario signup(String nome, String senha);
    boolean cadastrar(Usuario usuario);
}

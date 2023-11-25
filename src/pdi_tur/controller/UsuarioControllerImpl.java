package pdi_tur.controller;

import java.util.HashMap;

import pdi_tur.model.pessoas.TipoUsuario;
import pdi_tur.model.pessoas.Usuario;

public class UsuarioControllerImpl implements UsuarioController{
    private HashMap<String, Usuario> usuarios;

    

    public UsuarioControllerImpl() {
        this.usuarios = new HashMap<>();
        Usuario adm0 = new Usuario("Adimin", null, "1234", TipoUsuario.ADMINISTRADOR);

        usuarios.put("Adimin", adm0);
    }

    @Override
    public Usuario signup(String nome, String senha) {
        Usuario busca = usuarios.get(nome);
        if (busca != null && busca.getSenha().equals(senha)) {
            return busca;
        }

        return null;
    }

    @Override
    public boolean cadastrar(Usuario usuario) {
        if (usuarios.containsKey(usuario.getNome()) || usuarios.containsValue(usuario)) {
            return false;
        }

        usuarios.put(usuario.getNome(), usuario);
        return true;
    }
    
}

package pdi_tur.model.pessoas;

import pdi_tur.model.pacotes.PacoteViagem;

public class Usuario implements NotifReserva{
	private String nome;
	private String email;
	private String senha;
	private final TipoUsuario tipo;
	private PacoteViagem reserva;
	
	public Usuario(String nome, String email, String senha, TipoUsuario tipo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.reserva = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public PacoteViagem getReserva() {
		return reserva;
	}

	public void setReserva(PacoteViagem reserva) {
		this.reserva = reserva;
	}

	
}
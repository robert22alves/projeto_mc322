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

	@Override
	public String toString() {
		return nome + " (" + tipo + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	
	
}
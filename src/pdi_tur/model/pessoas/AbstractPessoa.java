package pdi_tur.model.pessoas;

public abstract class AbstractPessoa {
	private String usuario;
	private String senha;
	private final int nivelAcesso;
	
	public AbstractPessoa(String usuario, String senha, int nivelAcesso) {
		this.usuario = usuario;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNivelAcesso() {
		return nivelAcesso;
	}
	
	public abstract void permissoes();
}
package pdi_tur.model.pessoas;

public class Administrador extends AbstractPessoa{
	private int adminID;

	public Administrador(String usuario, String senha, int nivelAcesso, int adminID) {
		super(usuario, senha, nivelAcesso);
		this.adminID = adminID;
	}

	public int getAdminID() {
		return adminID;
	}


	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}


	public void permissoes() {
		System.out.println("gerenciar o conteúdo do sistema, adicionando, editando\r\n"
				+ "ou removendo pacotes de viagem conforme necessário.");
	}
	
}
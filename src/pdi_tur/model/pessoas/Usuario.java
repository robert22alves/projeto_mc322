package pdi_tur.model.pessoas;

public class Usuario extends AbstractPessoa implements NotifReserva{
	private int qtd;

	public Usuario(String usuario, String senha, int nivelAcesso, int qtd) {
		super(usuario, senha, nivelAcesso);
		this.qtd = qtd;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public void permissoes() {
		System.out.println("navegar pelo sistema, visualizar informações detalhadas sobre pacotes\r\n"
				+ "e destinos, e fazer reservas.");
	}
	
	
}
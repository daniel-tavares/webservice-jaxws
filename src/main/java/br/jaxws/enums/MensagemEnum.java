package br.jaxws.enums;

public enum MensagemEnum {

	SUCESSO(100, "Livro criado com sucesso."), 
	ERRO_USUARIO_INVALIDO(200,"Usuário não possui permissão para acessar o sistema."),
    ERRO_GENERICO(999,"Erro durante a requisição");
    
	private int codigo;
	private String motivo;

	private MensagemEnum(int codigo, String motivo) {
		this.codigo = codigo;
		this.motivo = motivo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}

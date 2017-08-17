package br.jaxws.modelo;

import java.util.List;

import br.jaxws.enums.FormatoArquivoEnum;

public class EBook extends Livro {
	private FormatoArquivoEnum formato;

	public EBook() {
		// TODO Auto-generated constructor stub
	}
	public EBook(FormatoArquivoEnum formato) {
		super();
		this.setFormato(formato);
	}

	public EBook(Integer anoDePublicacao, List<Autor> autores, String editora, String nome, String resumo) {
		super(anoDePublicacao, autores, editora, nome, resumo);
	}

	public FormatoArquivoEnum getFormato() {
		return formato;
	}

	public void setFormato(FormatoArquivoEnum formato) {
		this.formato = formato;
	}

	
}
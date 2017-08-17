package br.jaxws.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.jaxws.modelo.Autor;
import br.jaxws.modelo.EBook;
import br.jaxws.modelo.Livro;


public class EbookDAO {
	List<EBook> ebooksDinamico = new ArrayList<EBook>();

	public List<Livro> listarLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro(2012, new ArrayList<Autor>(Arrays.asList(new Autor("Paulo Silveira"), new Autor("Adriano Almeida"))), "Casa do Código", "Guia do Programador", "Vá do \"nunca programei\" ..."));
		livros.add(new Livro(2012, new ArrayList<Autor>(Arrays.asList(new Autor("Vinícius Baggio"),new Autor("Fuentes"))), "Casa do Código", "Ruby on Rails", "Crie rapidamente aplicações web"));
		return livros;
	}

	
	public List<EBook> criarEbook(EBook ebook){
		ebooksDinamico.add(ebook);
		return ebooksDinamico;
	}

}
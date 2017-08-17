package br.jaxws.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import br.jaxws.modelo.Autor;

public class AdaptadorAutores extends XmlAdapter<String, Autor> {

	@Override
	public String marshal(Autor autor) throws Exception {
		return autor.getNome();
	}

	@Override
	public Autor unmarshal(String autor) throws Exception {
		return new Autor(autor, null);
	}

}

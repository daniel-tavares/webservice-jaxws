package br.jaxws.modelo;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.jaxws.adapter.AdaptadorDate;
import br.jaxws.enums.MensagemEnum;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RetornoEbook", namespace = "br.jaxws.modelo.RetornoEbook")
public class RetornoEbook{

	@XmlElement(name = "codigo", required = true)
	private Integer codigo;

	@XmlElement(name = "descricao", required = true)
	private String descricao;

	@XmlElementWrapper(name = "ebooks")
	@XmlElement(name = "ebook")
	private List<EBook> ebooks;

	@XmlJavaTypeAdapter(AdaptadorDate.class)
	private Date data;

	public RetornoEbook() {

	}

	public RetornoEbook(MensagemEnum mensagem, List<EBook> ebooks) {
		super();
		this.codigo = mensagem.getCodigo();
		this.descricao = mensagem.getMotivo();
		this.ebooks = ebooks;
   	    this.data=new Date();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<EBook> getEbooks() {
		return ebooks;
	}

	public void setEbooks(List<EBook> ebooks) {
		this.ebooks = ebooks;
	}

	
}

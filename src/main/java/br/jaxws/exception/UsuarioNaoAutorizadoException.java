package br.jaxws.exception;

import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebFault;

import br.jaxws.enums.MensagemEnum;
import br.jaxws.modelo.RetornoEbook;


@WebFault(targetNamespace="http://br.jaxws.modelo.RetornoEbook",
          name="RetornoEbook")
public class UsuarioNaoAutorizadoException extends Exception {
 
	private static final long serialVersionUID = 1L;

	public UsuarioNaoAutorizadoException() {
		
	}
	
	public UsuarioNaoAutorizadoException(String msg) {
		super(msg);
	} 

	public UsuarioNaoAutorizadoException(Throwable causa, String msg) {
		super(msg);
	}
	
	public UsuarioNaoAutorizadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	      super(message, cause, enableSuppression, writableStackTrace);
	}
	
	 public RetornoEbook getFaultInfo() {
	      return new RetornoEbook(MensagemEnum.ERRO_GENERICO,null);
	 }
	
	   @XmlAccessorType(XmlAccessType.FIELD)
	   public static class UsuarioFaultInfo {

	      @XmlAttribute
	      private String mensagem;

	      private XMLGregorianCalendar data;

	      public UsuarioFaultInfo(String mensagem) {
	         
	         try {
	        	this.mensagem = mensagem;
				this.data = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
				this.data.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
				this.data.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	      }

	      public UsuarioFaultInfo() {
	      }

	      public XMLGregorianCalendar getData() {
	         return data;
	      }

	   }
}

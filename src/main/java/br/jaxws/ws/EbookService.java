package br.jaxws.ws;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.soap.SOAPFaultException;

import br.jaxws.dao.EbookDAO;
import br.jaxws.enums.MensagemEnum;
import br.jaxws.exception.UsuarioNaoAutorizadoException;
import br.jaxws.modelo.EBook;
import br.jaxws.modelo.RetornoEbook;
import br.jaxws.modelo.Usuario;

@WebService
public class EbookService {
    EbookDAO  ebookDAO =new EbookDAO();
	
	
	@WebResult(name="RetornoEbook")
	@RequestWrapper(className="br.jaxws.ws.CriarEbook")
	@ResponseWrapper(className="br.jaxws.ws.CriarEbookResponse")
	public RetornoEbook criarEbook (@WebParam(name="ebook") EBook ebook,
			                       @WebParam(name="usuario", header=true) Usuario usuario) throws UsuarioNaoAutorizadoException, SOAPException{
		
		try{
		  if (usuario.getLogin().equals("DanielTavares") && usuario.getSenha().equals("123456"))
			   return new RetornoEbook(MensagemEnum.SUCESSO, ebookDAO.criarEbook(ebook));
		  else
			   return new RetornoEbook(MensagemEnum.ERRO_USUARIO_INVALIDO, null);
		  
		}catch (Exception e) {
//			SOAPFault soapFault = SOAPFactory.newInstance().createFault("Usuário não autorizado",new QName(SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE,"Client.autorizacao"));
//			soapFault.setFaultActor("http://br.jaxws.ws/EbookService");
//			throw new SOAPFaultException(soapFault); 	
			return new RetornoEbook(MensagemEnum.ERRO_GENERICO, null);
		}  
	}
	
	

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/ebooks", new EbookService());
		System.out.println("Serviço inicializado!");
	}
	
	/*
	 * SOAPFault soapFault = SOAPFactory.newInstance().createFault("Usuário não autorizado",new QName(SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE,"Client.autorizacao"));
	 * soapFault.setFaultActor("http://br.jaxws.ws/LivrosService");
	 * throw new SOAPFaultException(soapFault);
	 * throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
	 */
}
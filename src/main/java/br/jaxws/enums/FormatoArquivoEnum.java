package br.jaxws.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "formato")
public enum FormatoArquivoEnum {
	@XmlEnumValue("PDF") PDF, @XmlEnumValue("MOBI") MOBI, @XmlEnumValue("EPUB") EPUB;
}
package main;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import mundo.Parse_XML_Document;

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Parse_XML_Document p = new Parse_XML_Document();
	try {
	    p.cargarArchivo();
	    p.cargarDocumentoXML();
	    p.leerDocumentoXML();

	} catch (URISyntaxException | ParserConfigurationException | SAXException | IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}

package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import mundo.Estudiante;
import mundo.Parse_XML_Document;

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Parse_XML_Document p = new Parse_XML_Document();
	try {
	    p.cargarArchivo();
	    p.cargarDocumentoXML();
	    p.leerDocumentoXML();

	    List<Estudiante> lista = p.darListaEstudiantes();

	    for (Estudiante estudiante : lista) {
		System.out.println("===========================");
		System.out.println("Roll No: " + estudiante.getRollNo());
		System.out.println("Nombre: " + estudiante.getNombre());
		System.out.println("Apellido: " + estudiante.getApellido());
		System.out.println("Codigo: " + estudiante.getCodigo());
		System.out.println("===========================");
	    }

	} catch (URISyntaxException | ParserConfigurationException | SAXException | IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}

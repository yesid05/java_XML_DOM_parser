package mundo.query;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Query_XML_Document {

    // ==========================
    // Atributos
    // ==========================

    // Ruta del archivo xml
    private static final String RUTA_ARCHIVO = "/extras/doc/";

    // Nombre del archivo xml
    private static final String NOMBRE_ARCHIVO = "query.xml";

    // Atributo para leer el documento
    private File inputFile;

    // Analizador para producir arboles de objetos DOM
    private DocumentBuilderFactory dbFactory;

    // Atributo para obteber la instancia DOM de un documento XML
    private DocumentBuilder dBuilder;

    // Atributo que representa todo el documento XML
    private Document documento;

    // Atributo para la abstraccion de un conjunto ordenado de nodos
    private NodeList nList;
    
 // ==========================
    // Metodos
    // ==========================
    /**
     * Construye un objeto por defecto
     */
    public Query_XML_Document(){
	
    }
    
    public void cargarArchivo() throws URISyntaxException{
	URL url = getClass().getResource(RUTA_ARCHIVO);
	inputFile = new File(url.toURI().getPath()+NOMBRE_ARCHIVO);
	System.out.println("Nombre del archivo xml: "+inputFile.getName());
    }
    

}

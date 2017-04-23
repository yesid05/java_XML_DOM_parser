package mundo.query;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
    public Query_XML_Document() {

    }

    /**
     * Metodo para cargar el archivo xml
     * 
     * @throws URISyntaxException
     *             Si el archivo no existe.
     */
    public void cargarArchivo() throws URISyntaxException {
	URL url = getClass().getResource(RUTA_ARCHIVO);
	inputFile = new File(url.toURI().getPath() + NOMBRE_ARCHIVO);
	System.out.println("Nombre del archivo xml: " + inputFile.getName());
    }

    /**
     * Metodo para cargar el documento XML
     * 
     * @throws ParserConfigurationException
     *             Error en la configuracion
     * @throws SAXException
     *             Error en el analizador XML
     * @throws IOException
     *             Error de entrada o salida de algun tipo
     */
    public void cargarDocumentoXML() throws ParserConfigurationException, SAXException, IOException {
	dbFactory = DocumentBuilderFactory.newInstance();
	dBuilder = dbFactory.newDocumentBuilder();
	documento = dBuilder.parse(inputFile);
	documento.getDocumentElement().normalize();
    }
    
    public void leerDocumentoXML(){
	nList = documento.getElementsByTagName("supercarros");
	System.out.println("Root elemento: "+documento.getDocumentElement().getNodeName());
	for (int i = 0; i < nList.getLength(); i++) {
	    Node nNodo = nList.item(i);
	    System.out.println("Elemento actual: "+nNodo.getNodeName());
	    if(nNodo.getNodeType()== Node.ELEMENT_NODE){
		Element elemento = (Element) nNodo;
		System.out.println("Compañia: "+elemento.getAttribute("empresa"));
		NodeList carroList = elemento.getElementsByTagName("nombrecarro");
		for (int j = 0; j < carroList.getLength(); j++) {
		    Node nNodo1 = carroList.item(j);
		    if(nNodo1.getNodeType()==Node.ELEMENT_NODE){
			Element elmCarro = (Element) nNodo1;
			System.out.println("Nombre: "+elmCarro.getTextContent());
			System.out.println("Tipo: "+elmCarro.getAttribute("type"));
		    }
		}
	    }
	}
    }

}

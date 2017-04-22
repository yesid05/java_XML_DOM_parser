package mundo.parse;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Parse_XML_Document {
    // ==========================
    // Atributos
    // ==========================

    // Ruta del archivo xml
    private static final String RUTA_ARCHIVO = "/extras/doc/";

    // Nombre del archivo xml
    private static final String NOMBRE_ARCHIVO = "parse.xml";

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

    // Lista de estudiantes del XML
    private List<Estudiante> listaEstudiantes;

    // ==========================
    // Metodos
    // ==========================
    /**
     * Construye un objeto por defecto
     */
    public Parse_XML_Document() {
	// TODO Auto-generated constructor stub
	listaEstudiantes = new ArrayList<Estudiante>();
    }

    /**
     * Metodo para cargar el archivo xml
     * 
     * @throws URISyntaxException
     *             Si el archivo no existe
     */
    public void cargarArchivo() throws URISyntaxException {
	URL url = getClass().getResource(RUTA_ARCHIVO);
	inputFile = new File(url.toURI().getPath() + NOMBRE_ARCHIVO);
	System.out.println("Nombre del archivo xml: " + inputFile.getName());
    }

    /**
     * Mettodo para cargar el documento XML
     * 
     * @throws ParserConfigurationException
     *             Error en la configuracion.
     * @throws IOException
     *             Error de entrada o salida de algun tipo
     * @throws SAXException
     *             Error en el analizador XML
     */
    public void cargarDocumentoXML() throws ParserConfigurationException, SAXException, IOException {
	dbFactory = DocumentBuilderFactory.newInstance();
	dBuilder = dbFactory.newDocumentBuilder();
	documento = dBuilder.parse(inputFile);
	documento.getDocumentElement().normalize();
	System.out.println("Nombre del nodo: " + documento.getDocumentElement().getNodeName());
    }

    /**
     * Metodo para recorrer todo el doucmento XML, <br />
     * y crear los estudiantes con los datos proporcionados <br />
     * en el XML. <br />
     */
    public void leerDocumentoXML() {
	nList = documento.getElementsByTagName("estudiante");
	for (int i = 0; i < nList.getLength(); i++) {
	    Node nNodo = nList.item(i);
	    //System.out.println("Nombre item:: " + nNodo.getNodeName());
	    if (nNodo.getNodeType() == Node.ELEMENT_NODE) {
		Element elemento = (Element) nNodo;
		Estudiante e = new Estudiante();
		e.setRollNo(elemento.getAttribute(Estudiante.ROLL_NO));
		e.setNombre(elemento.getElementsByTagName(Estudiante.NOMBRE).item(0).getTextContent());
		e.setApellido(elemento.getElementsByTagName(Estudiante.APELLIDO).item(0).getTextContent());
		e.setCodigo(elemento.getElementsByTagName(Estudiante.CODIGO).item(0).getTextContent());
		listaEstudiantes.add(e);
	    }
	}
    }
    
    /**
     * Retorna una lista con los estudiantes creados del documento XML.
     * @return listaEstudiantes de tipo <b>List</b>
     */
    public List<Estudiante> darListaEstudiantes() {
	return listaEstudiantes;
    }
}

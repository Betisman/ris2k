/*
 * SVGTablero.java
 *
 * Created on 16 de marzo de 2007, 16:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package svgTablero;

import Exceptions.ris2kException;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import model.Tablero;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Carlos
 */
public class SVGTablero {
    static Logger log = Logger.getLogger(SVGTablero.class);    
    /** Creates a new instance of SVGTablero */
    public SVGTablero() {
    }
    
    public Document parsearFichero(File f)
    throws ris2kException{ 
        log.error("Problema al parsear el fichero SVG: "+f.getPath());
        //System.out.println("en parsearFichero()");
        //System.out.println(f.getPath());
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new InputSource(new FileInputStream(f.getPath())));
            if (document == null)
                log.error("No existe el documento a parsear");
                //System.out.println("DOCUMENT NULL en parsearFichero()");
            else
                log.info("Documento válido a parsear");
                //System.out.println("DOCUMENT ¡¡NOT!! NULL en parsearFichero()");
            return document;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
            log.error("Excepción al pasear el fichero");
            throw new ris2kException("IOException al parsear el fichero " + f.getName());
        } catch (SAXException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Document cambiarLinks(Document document, String servlet){
        System.out.println("Se encuentra en cambiarLinks()");
        if (document == null) //System.out.println("DOCUMENT NULL"); 
            log.info("Document NULL");
        try {
            //System.out.println("Bienvenido a cambiarLinks() EN TERRITORIOATACANTE");
            log.info("cambiarLinks en TerritorioAtacante");
            XPath xpath = XPathFactory.newInstance().newXPath();
//            String expression = "//a";
            String expression = "//a";
            NodeList nodos;
            
            nodos = (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);
            
            //System.out.println("numero de nodos = "+String.valueOf(nodos.getLength()));
            log.info("numero de nodos = "+String.valueOf(nodos.getLength()));
            for(int i=0; i<nodos.getLength(); i++){
                Node n = (Node)nodos.item(i);
                String idTerritorio = n.getAttributes().getNamedItem("id").getTextContent();
                System.out.println(idTerritorio);
                idTerritorio = idTerritorio.replace("link", "");
                System.out.println(idTerritorio);
                String link = servlet + "?territorio=" + idTerritorio;
                System.out.println(link);
                n.getAttributes().getNamedItem("xlink:href").setTextContent(link);
                System.out.println(idTerritorio);
                System.out.println(n.getAttributes().getNamedItem("xlink:href").getTextContent());
            }
            return document;
        } catch (XPathExpressionException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public String serializar(Document document){
        OutputFormat format = new OutputFormat(document);
        StringWriter strWriter = new StringWriter();
        XMLSerializer serial = new XMLSerializer(strWriter, format);
        try {
            serial.asDOMSerializer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            serial.serialize(document);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String hola = strWriter.toString();
        //System.out.println("hola = "+hola);
        
        return hola;
    }
    
    public void stringToSvgFile(String str, String ruta){
        /*** temporal */
        ruta = "C:/universidad/Quinto/IS2/temp/ris2k/web/images/tablero.svg";
        /****/
        FileWriter svgFile = null;
        try {
            svgFile = new FileWriter(ruta);
            svgFile.write(str);
            svgFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public Document setRutaFondo(Document document, String ruta){
        //System.out.println("Se encuentra en setRutaFondo()");
        log.info("setRutaFondo()");
        if (document == null) System.out.println("DOCUMENT NULL en setRutaFondo()");
        try {
            //System.out.println("Bienvenido a setRutaFondo() EN TERRITORIOATACANTE");
            log.info("Bienvenido a setRutaFondo() EN TERRITORIOATACANTE");
            XPath xpath = XPathFactory.newInstance().newXPath();
//            String expression = "//a";
            String expression = "//image[@id='fondo']";

            Node n = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
            
            String idImage = n.getAttributes().getNamedItem("id").getTextContent();
            System.out.println(idImage);
            n.getAttributes().getNamedItem("xlink:href").setTextContent(ruta);
            System.out.println(n.getAttributes().getNamedItem("xlink:href").getTextContent());
            
            return document;
        } catch (XPathExpressionException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

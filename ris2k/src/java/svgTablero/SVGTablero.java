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
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import model.Tablero;
import model.Territorio;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
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
        log.info("Entramos en parsear el fichero SVG: "+f.getPath());
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new InputSource(new FileInputStream(f.getPath())));
            if (document == null)
                log.error("No existe el documento a parsear");
            else
                log.info("Documento válido a parsear");
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
        }catch (Exception ex){
            ex.printStackTrace();
            log.error("Error desconocido al parsear el fichero. Error = "+ex.getMessage());
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
//        ruta = "C:/universidad/Quinto/IS2/temp/ris2k/web/images/tablero.svg";
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
    
    public Document setNumEjercitosTerritorio(Document document, Territorio territorio)
    throws ris2kException{
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "/svg/g/text[@id='num"+territorio.getId()+"']/tspan";
        Node nodo = null;
        try {
            nodo = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
            if (nodo == null)
                throw new ris2kException("nodo == null en num"+territorio.getId());
        } catch (XPathExpressionException ex) {
            ex.printStackTrace();
        }
        System.out.println(territorio.getId()+": " + nodo.getTextContent());
        nodo.setTextContent(String.valueOf(territorio.getNumEjercitos()));
        System.out.println(territorio.getId()+": " + nodo.getTextContent());
        return document;
    }
    
    public Document setOwnerTerritorio(Document document, Territorio territorio)
    throws ris2kException{
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "//path[@id='ejercito"+territorio.getId()+"']";
        Node nodo = null;
        try {
            nodo = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
            if (nodo == null)
                throw new ris2kException("nodo == null en ejercito"+territorio.getId());
        } catch (XPathExpressionException ex) {
            ex.printStackTrace();
        }
        System.out.println("color"+territorio.getId()+": " + nodo.getAttributes().getNamedItem("style").getTextContent());
        String style = nodo.getAttributes().getNamedItem("style").getTextContent();
        String cachitos[] = style.split(";");
        cachitos[0] = "fill:"+territorio.getOwner().getColor()+"";
        style = cachitos[0]+";"+cachitos[1]+";"+cachitos[2]+";"+cachitos[3];
        System.out.println(style);
        nodo.getAttributes().getNamedItem("style").setTextContent(style);
        return document;
    }
    
    public Document situarTodosEjercitos(Document document, List<Territorio> territorios)
    throws ris2kException{
        try{
            XPath xpath = XPathFactory.newInstance().newXPath();
            for (Territorio t : territorios){
                log.info("situando ejércitos en "+t.getId());
                document = setNumEjercitosTerritorio(document, t);
                document = setOwnerTerritorio(document, t);
            }
        }catch(ris2kException ex){
            System.out.println("ris2kException : " + ex.getMessage());
        }catch(Exception e){
            //System.out.println("Excepción generada en situarTodosEjercitos()");
            log.error("Excepción generada en situarTodosEjercitos()");
            e.printStackTrace();
        }
        return document;
    }
    
    public Document setMouseOver(Document document, String idTerritorio)
    throws ris2kException{
            XPath xpath = XPathFactory.newInstance().newXPath();
        try{
            /*quitamos el nodo set si lo hubiera*/
            document = removeMouseOver(document, idTerritorio);
        }catch(ris2kException ex){
            System.out.println("ris2kException : " + ex.getMessage());
        }
        try{
            /*Buscamos el nodo correspondiente al territorio*/
            String expression = "/svg/g/path[@id='path"+idTerritorio+"']";
            Node nodo = null;
            try {
                nodo = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
                if (nodo == null)
                    throw new ris2kException("nodo == null en link"+idTerritorio);
            } catch (XPathExpressionException ex) {
                ex.printStackTrace();
            }
            Element setAtt = document.createElement("set");
            /*creamos el nodo y lo rellenamos con sus atributos*/
            setAtt.setAttribute("attributeName", "fill-opacity");
            setAtt.setAttribute("from", "0");
            setAtt.setAttribute("to", "0.3");
            setAtt.setAttribute("begin", "mouseover");
            setAtt.setAttribute("end", "mouseout");
            nodo.appendChild(setAtt);
        }catch(ris2kException ex){
            System.out.println("ris2kException : " + ex.getMessage());
        }catch(Exception e){
            //System.out.println("Excepción generada en situarTodosEjercitos()");
            log.error("Excepción generada en setMouseOver()");
            e.printStackTrace();
        }
        return document;
    }
    
    public Document removeMouseOver(Document document, String idTerritorio)
    throws ris2kException{
        try{
            XPath xpath = XPathFactory.newInstance().newXPath();
            /*Buscamos el nodo correspondiente al territorio*/
            String expression = "/svg/g/path[@id='path"+idTerritorio+"']/set";
            Node nodo = null;
            try {
                nodo = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
                if (nodo == null)
                    throw new ris2kException("No existe nodo set en path"+idTerritorio);
            } catch (XPathExpressionException ex) {
                ex.printStackTrace();
            }
            Node papa = nodo.getParentNode();
            papa.removeChild(nodo);
        }catch(ris2kException ex){
            System.out.println("ris2kException : " + ex.getMessage());
        }catch(Exception e){
            log.error("Excepción generada en removeMouseOver()");
            e.printStackTrace();
        }
        return document;
    }
    
    public Document setSumarEjercito(Document document, String idTerritorio)
    throws ris2kException{
            XPath xpath = XPathFactory.newInstance().newXPath();
        try{
            /*quitamos el atributo onclick si lo hubiera*/
            document = removeSumarEjercito(document, idTerritorio);
        }catch(ris2kException ex){
            System.out.println("ris2kException : " + ex.getMessage());
        }
        try{
            /*Buscamos el nodo correspondiente al territorio*/
            String expression = "/svg/g/path[@id='path"+idTerritorio+"']";
            Node nodo = null;
            try {
                nodo = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
                if (nodo == null)
                    throw new ris2kException("nodo == null en path"+idTerritorio);
            } catch (XPathExpressionException ex) {
                ex.printStackTrace();
            }
            Element elem = (Element)nodo;
            elem.setAttribute("onclick", "sumarEjercito(evt)");
            nodo.getParentNode().replaceChild(elem, nodo);
        }catch(ris2kException ex){
            System.out.println("ris2kException : " + ex.getMessage());
        }catch(Exception e){
            //System.out.println("Excepción generada en situarTodosEjercitos()");
            log.error("Excepción generada en setMouseOver()");
            e.printStackTrace();
        }
        return document;
    }
    
    public Document removeSumarEjercito(Document document, String idTerritorio)
    throws ris2kException{
        try{
            XPath xpath = XPathFactory.newInstance().newXPath();
            /*Buscamos el nodo correspondiente al territorio*/
            String expression = "/svg/g/path[@id='path"+idTerritorio+"']";
            Node nodo = null;
            try {
                nodo = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
                if (nodo == null)
                    throw new ris2kException("No existe nodo set en link"+idTerritorio);
            } catch (XPathExpressionException ex) {
                ex.printStackTrace();
            }
            Node papa = nodo.getParentNode();
            Element elem = (Element)nodo;
            elem.removeAttribute("onclick");
            papa.replaceChild(elem, nodo);
        }catch(ris2kException ex){
            System.out.println("ris2kException : " + ex.getMessage());
        }catch(Exception e){
            log.error("Excepción generada en removeMouseOver()");
            e.printStackTrace();
        }
        return document;
    }
}

/*
 * Tablero.java
 *
 * Created on 7 de marzo de 2007, 23:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import svgTablero.SVGTablero;

/**
 *
 * @author Carlos
 */
public class Tablero {
    private String mapa;
    private String infoXml;
    private List<Continente> continentes = new ArrayList();
    
    /** Creates a new instance of Tablero */
    public Tablero() {
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public List<Continente> getContinentes() {
        return continentes;
    }

    public void setContinentes(List<Continente> continentes) {
        this.continentes = continentes;
    }
    
    public boolean mostrar(){
        if (mapa == null){
            return true;
        }else return false;
    }
    
    public void cambiarLinksTerritorios(String newLink){
        
        try{
            System.out.println("Bienvenido a cambiarLinksTerritorios()");
            File f = new File(this.getMapa());
System.out.println("ABSOLUTE ROUTA: " + f.getAbsolutePath());
            if (f.exists()){
                System.out.println("existe el fichero del mapa... " + f.getPath());
            }else{
                System.out.println("ouch!! no existe el fichero del mapa... " + f.getPath());
            }

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
            Document document = builder.parse(new File(this.getMapa()));
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression = "//a";
            NodeList nodos = (NodeList)xpath.evaluate(expression, document, XPathConstants.NODE);
            for(int i=0; i<nodos.getLength(); i++){
                Node n = nodos.item(i);
                String idTerritorio = n.getAttributes().getNamedItem("id").getTextContent();
System.out.println(idTerritorio);
                idTerritorio = idTerritorio.replace("link", "");
System.out.println(idTerritorio);
                String link = newLink + "?territorio=" + idTerritorio;
System.out.println(link);
                n.getAttributes().getNamedItem("xlink:href").setTextContent(link);
System.out.println(idTerritorio);
System.out.println(n.getAttributes().getNamedItem("xlink:href").getTextContent());
            }
           
            OutputFormat format = new OutputFormat(document);
            FileWriter fileout = new FileWriter(this.getMapa());
            XMLSerializer serial = new XMLSerializer(fileout, format);
            serial.asDOMSerializer();
            serial.serialize(document);

        }catch(Exception e){
            System.out.println("Excepción generada: " + e.getMessage());
            //e.printStackTrace();
        }        
    }
    
    public void cargarTerritorios(String infoXml){
        SVGTablero svgTablero = new SVGTablero();
        Document document = svgTablero.parsearFichero(new File(infoXml));
        try {
            //creamos todos los objetos territorio
            //creamos los continentes
            //asignamos los territorios a sus continentes
            //para cada territorio, buscamos los territorios con los que limita y se los asignamos
            
            //creamos todos los objetos territorio           
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression = "//continente";
            NodeList nodos;
            
            nodos = (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);
            
System.out.println("numero de continentes = "+String.valueOf(nodos.getLength()));
            
            for(int i=0; i<nodos.getLength(); i++){
                Continente c = new Continente();
                Node n = (Node)nodos.item(i);
                c.setId(n.getAttributes().getNamedItem("id").getTextContent());
                c.setNombre(n.getAttributes().getNamedItem("nombre").getTextContent());
                c.setNumRefuerzos(Integer.parseInt(n.getAttributes().getNamedItem("numRefuerzos").getTextContent()));
                continentes.add(c);
            }

            for(Continente c : continentes){
                expression = "//continente[@id='"+c.getId()+"']/territorio";
                nodos = (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);
                for(int i = 0; i < nodos.getLength(); i++){
                    Territorio t = new Territorio();
                    Node n = (Node)nodos.item(i);
                    t.setId(n.getAttributes().getNamedItem("id").getTextContent());
                    t.setNombre(n.getAttributes().getNamedItem("nombre").getTextContent());
                    //añadimos el territorio a su continente
                    c.getTerritorios().add(t);
                }
            }
                        
            for(Continente c : continentes){
                for(Territorio t : c.getTerritorios()){
                    expression = "//territorio[@id='"+t.getId()+"']/limita";
                    nodos = (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);
                    for(int i = 0; i < nodos.getLength(); i++){
                        Node n = (Node)nodos.item(i);
                        Territorio conex = new Territorio();
                        t.getConexiones().add(this.getTerritorio(n.getNodeValue()));
                    }
                }
            }


        } catch (XPathExpressionException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public Territorio getTerritorio(String idTerritorio){
        Territorio objetivo = null;
        for(Continente c : continentes){
            for(Territorio t : c.getTerritorios()){
                if (t.getId() == idTerritorio)
                    objetivo = t;
            }
        }
        return objetivo;
    }
    
    public String toString(){
        String str = null;
        str = "mapa: " + this.getMapa() + "\n";
        for(Continente c : this.getContinentes())
            str = str + c.toString();
        return str;
    } 
    
    public int numTerritoriosTotal(){
        int tmp = 0;
        for(Continente c : this.getContinentes())
            tmp += c.numTerritorios();
        return tmp;
    }
    
    public int numTerritoriosContinente(Continente c){
        return c.numTerritorios();
    }
    
    public int numContinentes(){
        return this.getContinentes().size();
    }
}
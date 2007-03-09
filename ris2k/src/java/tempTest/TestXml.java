/*
 * TestXml.java
 *
 * Created on 4 de marzo de 2007, 21:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tempTest;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import model.Jugador;
import model.Territorio;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author Carlos
 */
public class TestXml {
    
    /** Creates a new instance of TestXml */
    public TestXml() {
/*        try {
            JAXBContext jctx = JAXBContext.newInstance(Territorio.class);
            Unmarshaller u = jctx.createUnmarshaller();
           
            Territorio t = (Territorio)u.unmarshal(new FileInputStream("web/test/newYork.xml"));
            Marshaller m = jctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
           
        } catch (PropertyException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
  */    
        
        try{
            File f = new File("web/test/dibujo.xml");
            if (f.exists()){
                System.out.println("OK");
            }else{
                System.out.println("ouch!!");
            }

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
            Document document = builder.parse(new File("web/test/dibujo.xml"));
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            Vector<String> testTerritorios = new Vector();
            testTerritorios.add("Hackensack");
            testTerritorios.add("JerseyCity");
            testTerritorios.add("Bergen");
            for (String t : testTerritorios){
                String expression = "//text[@id='num"+ t +"']/tspan";
                String nameString = (String)
                xpath.evaluate(expression, document, XPathConstants.STRING);
                System.out.println(t + ": " + nameString + "\n");
            }
            String expression = "/svg/g/text[@id='numHackensack']/tspan";
            Node nodo = (Node)xpath.evaluate(expression, document, XPathConstants.NODE);
            System.out.println("Hackensack: " + nodo.getTextContent());
            nodo.setTextContent("14");
            System.out.println("Hackensack: " + nodo.getTextContent());
            
            OutputFormat format = new OutputFormat(document);
            FileWriter fileout = new FileWriter("web/test/dibujo.xml");
            XMLSerializer serial = new XMLSerializer(fileout, format);
            serial.asDOMSerializer();
            serial.serialize(document);

        }catch(Exception e){
            System.out.println("Excepción generada");
            e.printStackTrace();
        }
    }
    
    public void cambiarOwnerTerritorio(Territorio t, Jugador j){
        System.out.println("El territorio " + t.getNombre() + ", perteneciente al jugador "
                + t.getOwner().getUser() + ", pasa ahora a pertenecer al jugador " + j.getUser() + ".");
        try{
            File f = new File("web/test/dibujo.xml");
            if (f.exists()){
                System.out.println("existe el fichero del mapa... " + f.getPath() + " ______ " + f.getAbsolutePath());
            }else{
                System.out.println("ouch!! no existe el fichero del mapa... " + f.getPath() + " ______ " + f.getAbsolutePath());
            }

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
            Document document = builder.parse(new File("web/test/dibujo.xml"));
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression = "//path[@id='ejercito"+t.getId()+"']";
            Node nodo = (Node)xpath.evaluate(expression, document, XPathConstants.NODE);
            System.out.println("colorHackensack: " + nodo.getAttributes().getNamedItem("style").getTextContent());
            
            String style = nodo.getAttributes().getNamedItem("style").getTextContent();
            String cachitos[] = style.split(";");
            cachitos[0] = "fill:"+j.getColor()+"";
            style = cachitos[0]+";"+cachitos[1]+";"+cachitos[2]+";"+cachitos[3];
            System.out.println(style);
            
            nodo.getAttributes().getNamedItem("style").setTextContent(style);
 
            OutputFormat format = new OutputFormat(document);
            FileWriter fileout = new FileWriter("web/test/dibujo.xml");
            XMLSerializer serial = new XMLSerializer(fileout, format);
            serial.asDOMSerializer();
            serial.serialize(document);

        }catch(Exception e){
            System.out.println("Excepción generada");
            e.printStackTrace();
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestXml test1 = new TestXml();
        
        Jugador j = new Jugador();
        j.setColor("url(#linearGradient3203)");
        j.setUser("Mariano");
        Territorio t = new Territorio();
        t.setId("Hackensack");
        t.setNombre("Hackensack");
        t.setOwner(j);
        test1.cambiarOwnerTerritorio(t, j);   
    }
    
}

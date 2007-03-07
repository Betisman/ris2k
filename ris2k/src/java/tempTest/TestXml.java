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
      /*
            DocumentBuilderFactory factoryDocBuilder = DocumentBuilderFactory.newInstance();
            factoryDocBuilder.setNamespaceAware(true);
            DocumentBuilder builder = factoryDocBuilder.newDocumentBuilder();
            Document doc = builder.parse("web/test/dibujo.xml");
            
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile("text[id='JerseyCity']/tspan");
            
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            Node nodo = (Node)result;
            System.out.println("sale: "+nodo.getNodeValue());
            */
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
                String expression = "/svg/g/text[@id='num"+ t +"']/tspan";
                String nameString = (String)
                xpath.evaluate(expression, document, XPathConstants.STRING);
                System.out.println(t + ": " + nameString + "\n");
            }
            String expression = "/svg/g/text[@id='numHackensack']/tspan";
            Node nodo = (Node)xpath.evaluate(expression, document, XPathConstants.NODE);
            System.out.println("Hackensack: " + nodo.getNodeValue());
            System.out.println("Nombre nodo: " + nodo.getNodeName());
            nodo.setNodeValue("06");
            System.out.println("Hackensack: " + nodo.getNodeValue());
            
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
    
    /**coco{a|s}
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestXml test1 = new TestXml();
    }
    
}

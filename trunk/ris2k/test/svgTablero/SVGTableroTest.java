/*
 * SVGTableroTest.java
 * JUnit based test
 *
 * Created on 22 de abril de 2007, 11:09
 */

package svgTablero;

import junit.framework.*;
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
import model.Jugador;
import model.Partida;
import model.Tablero;
import model.Territorio;
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
public class SVGTableroTest extends TestCase {
    
    public SVGTableroTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of parsearFichero method, of class svgTablero.SVGTablero.
     */
    public void testParsearFichero() throws Exception {
        System.out.println("parsearFichero");
        
        File f = null;
        SVGTablero instance = new SVGTablero();
        
        Document expResult = null;
        Document result = instance.parsearFichero(f);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarLinks method, of class svgTablero.SVGTablero.
     */
    public void testCambiarLinks() {
        System.out.println("cambiarLinks");
        
        Document document = null;
        String servlet = "";
        SVGTablero instance = new SVGTablero();
        
        Document expResult = null;
        Document result = instance.cambiarLinks(document, servlet);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serializar method, of class svgTablero.SVGTablero.
     */
    public void testSerializar() {
        System.out.println("serializar");
        
        Document document = null;
        SVGTablero instance = new SVGTablero();
        
        String expResult = "";
        String result = instance.serializar(document);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stringToSvgFile method, of class svgTablero.SVGTablero.
     */
    public void testStringToSvgFile() {
        System.out.println("stringToSvgFile");
        
        String str = "";
        String ruta = "";
        SVGTablero instance = new SVGTablero();
        
        instance.stringToSvgFile(str, ruta);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRutaFondo method, of class svgTablero.SVGTablero.
     */
    public void testSetRutaFondo() {
        System.out.println("setRutaFondo");
        
        Document document = null;
        String ruta = "";
        SVGTablero instance = new SVGTablero();
        
        Document expResult = null;
        Document result = instance.setRutaFondo(document, ruta);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumEjercitosTerritorio method, of class svgTablero.SVGTablero.
     */
    public void testSetNumEjercitosTerritorio() {
        System.out.println("setNumEjercitosTerritorio");
        
        Document document = null;
        Territorio territorio = null;
        SVGTablero instance = new SVGTablero();
        try {
            
            instance.setNumEjercitosTerritorio(document, territorio);
        } catch (ris2kException ex) {
            ex.printStackTrace();
        }
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOwnerTerritorio method, of class svgTablero.SVGTablero.
     */
    public void testSetOwnerTerritorio() {
        System.out.println("setOwnerTerritorio");
        
        Document document = null;
        Territorio territorio = null;
        SVGTablero instance = new SVGTablero();
        try {
            
            instance.setOwnerTerritorio(document, territorio);
        } catch (ris2kException ex) {
            ex.printStackTrace();
        }
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of situarTodosEjercitos method, of class svgTablero.SVGTablero.
     */
    public void testSituarTodosEjercitos() throws Exception {
        System.out.println("situarTodosEjercitos");
        try {
            File f = new File("web/images/Zonas1024bisAjax.svg");
            List<Territorio> territorios = null;
            Partida p = new Partida();
            SVGTablero svg = new SVGTablero();
            Document document = svg.parsearFichero(f);

            Jugador j1 = new Jugador(); j1.setUser("jugador1"); j1.setColor("#0066cc");
            Jugador j2 = new Jugador(); j2.setUser("jugador2"); j2.setColor("#33ff33");
            Jugador j3 = new Jugador(); j3.setUser("jugador3"); j3.setColor("#ffff33");
            Jugador j4 = new Jugador(); j4.setUser("jugador4"); j4.setColor("#ff00ff");
            Jugador j5 = new Jugador(); j5.setUser("jugador5"); j5.setColor("#ff6600");
            Jugador j6 = new Jugador(); j6.setUser("jugador6"); j6.setColor("#808080");
            p.getJugadores().add(j1); p.getJugadores().add(j2); p.getJugadores().add(j3);
            p.getJugadores().add(j4); p.getJugadores().add(j5); p.getJugadores().add(j6);
        
            p.getTablero().cargarTerritorios("C:/universidad/Quinto/IS2/Ris2k/ris2k/web/test/newYork.xml");
            p.repartirTerritorios();
            
            svg.situarTodosEjercitos(document, p.getTablero().getTodosTerritorios());
            
            svg.stringToSvgFile(svg.serializar(document), "C:/universidad/Quinto/IS2/Ris2k/ris2k/web/images/output.svg");

            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
        } catch (ris2kException ex) {
            System.out.println("ris2kException: "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("Saltó excepción");
            ex.printStackTrace();
        }
    }
    
}

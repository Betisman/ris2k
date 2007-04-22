/*
 * TableroTest.java
 * JUnit based test
 *
 * Created on 26 de marzo de 2007, 18:42
 */

package model;

import Exceptions.ris2kException;
import java.util.ArrayList;
import junit.framework.*;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileWriter;
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
public class TableroTest extends TestCase {
    
    public TableroTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of getMapa method, of class model.Tablero.
     */
    public void testGetMapa() {
        System.out.println("getMapa");
        
        Tablero instance = new Tablero();
        
        String expResult = "";
        String result = instance.getMapa();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMapa method, of class model.Tablero.
     */
    public void testSetMapa() {
        System.out.println("setMapa");
        
        String mapa = "";
        Tablero instance = new Tablero();
        
        instance.setMapa(mapa);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContinentes method, of class model.Tablero.
     */
    public void testGetContinentes() {
        System.out.println("getContinentes");
        
        Tablero instance = new Tablero();
        
        List<Continente> expResult = null;
        List<Continente> result = instance.getContinentes();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContinentes method, of class model.Tablero.
     */
    public void testSetContinentes() {
        System.out.println("setContinentes");
        
        List<Continente> continentes = null;
        Tablero instance = new Tablero();
        
        instance.setContinentes(continentes);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class model.Tablero.
     */
    public void testMostrar() {
        System.out.println("mostrar");
        
        Tablero instance = new Tablero();
        
        boolean expResult = true;
        boolean result = instance.mostrar();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarLinksTerritorios method, of class model.Tablero.
     */
    public void testCambiarLinksTerritorios() {
        System.out.println("cambiarLinksTerritorios");
        
        String newLink = "";
        Tablero instance = new Tablero();
        
        instance.cambiarLinksTerritorios(newLink);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarTerritorios method, of class model.Tablero.
     */
    public void testCargarTerritorios() {
        System.out.println("cargarTerritorios");
        
        String infoXml = "web/test/newYorkInfoTest1.xml";
        Tablero instance = new Tablero();
        try {
            instance.cargarTerritorios(infoXml);
        } catch (ris2kException ex) {
            ex.printStackTrace();
        }
        
        Tablero expected = new Tablero();
        Continente c = new Continente();
        c.setId("Manhattan");
        c.setNombre("Manhattan");
        c.setNumRefuerzos(1);
        List<Territorio> territorios = new ArrayList();
        c.setTerritorios(territorios);
        Territorio tHarlem = new Territorio();
        Territorio tWest = new Territorio();
        Territorio tCentral = new Territorio();
        Territorio tSouth = new Territorio();
        tHarlem.setId("Harlem"); tHarlem.setNombre("Harlem");
        tWest.setId("WestManhattan"); tWest.setNombre("West Manhattan");
        tCentral.setId("CentralManhattan"); tCentral.setNombre("Central Manhattan");
        tSouth.setId("SouthManhattan"); tSouth.setNombre("South Manhattan");
        List<Territorio> conexvacio = new ArrayList();
        tHarlem.setConexiones(conexvacio); tWest.setConexiones(conexvacio);
        tCentral.setConexiones(conexvacio); tSouth.setConexiones(conexvacio);
        
        tHarlem.getConexiones().add(tWest); tHarlem.getConexiones().add(tCentral);
        tWest.getConexiones().add(tHarlem); tWest.getConexiones().add(tCentral); tWest.getConexiones().add(tSouth);
        tCentral.getConexiones().add(tHarlem); tCentral.getConexiones().add(tWest); tCentral.getConexiones().add(tSouth);
        tSouth.getConexiones().add(tWest); tSouth.getConexiones().add(tCentral);
        
        c.getTerritorios().add(tHarlem); c.getTerritorios().add(tWest);
        c.getTerritorios().add(tCentral); c.getTerritorios().add(tSouth);
        
        List<Continente> continentes = new ArrayList();
        continentes.add(c);
        instance.setContinentes(continentes);
        
/*        Tablero tablero = new Tablero();
        tablero.cargarTerritorios("web/test/newYork.xml");
 */
        
        
//        System.out.println(expected.toString());
        
        if (instance.equals(expected)){
            System.out.println("equal ok");
        }else{
            System.out.println("equal not");
        }
        
        this.assertEquals(expected, instance);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTerritorio method, of class model.Tablero.
     */
    public void testGetTerritorio() {
        System.out.println("getTerritorio");
        
        String idTerritorio = "";
        Tablero instance = new Tablero();
        
        Territorio expResult = null;
        Territorio result = instance.getTerritorio(idTerritorio);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void testGetTodosLosTerritorios(){
        System.out.println("cargarTerritorios");
        
        String infoXml = "C:/universidad/Quinto/IS2/Ris2k/ris2k/web/test/newYork.xml";
        Tablero instance = new Tablero();
        try {
            instance.cargarTerritorios(infoXml);
        } catch (ris2kException ex) {
            ex.printStackTrace();
        }
        for(Territorio t : instance.getTodosTerritorios()){
            System.out.println(t.getNombre()+" ("+t.getId()+") ["+String.valueOf(t.getConexiones().size()+"]:"));
            for(Territorio tb : t.getConexiones())
                System.out.println("\t"+tb.getNombre()+" ("+tb.getId()+")");       
        }
    }
    
}

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
     * Test of mostrar method, of class model.Tablero.
     */
    public void testMostrar() {
        System.out.println(">>> test mostrar");
        
        Tablero instance = new Tablero();
        try{
            instance.mostrar();
        }
        catch (ris2kException r)
        {
            fail(r.getMessage());
        }
        catch (Exception e)
        {
            fail("se encontró una excepción inesperada: "+e.getMessage());
        }
    }

    /**
     * Test of cambiarLinksTerritorios method, of class model.Tablero.
     */
    public void testCambiarLinksTerritorios() {
        System.out.println(">>> testcambiarLinksTerritorios");
        
        String newLink = "linkprueba";
        Tablero result = new Tablero();
        Tablero expected = new Tablero();
        
        try
        {
          result.cargarTerritorios("test/model/tableropruebaA.xml");
        }
        catch (Exception ex)
        {
           throw new Error("ERROR EN CARGAR TERRITORIOS");
        }
        
        try
        {
          expected.cargarTerritorios("test/model/tableropruebaB.xml");
        }
        catch (Exception ex)
        {
           throw new Error("ERROR EN CARGAR TERRITORIOS");
        }

 
        result.cambiarLinksTerritorios(newLink);
        
        assertEquals(expected,result);


    }

    /**
     * Test of cargarTerritorios method, of class model.Tablero.
     */
    public void testCargarTerritorios() {
               System.out.println(">>> cargarTerritorios");
        
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
        
        try
        {
          instance.cargarTerritorios("test/model/tableropruebaA.xml");
        }
        catch (Exception ex)
        {
           throw new Error("ERROR EN CARGAR TERRITORIOS");
        }
        
        
        Territorio expResult = new Territorio();
        expResult.setId("JFK Airport");
        expResult.setNombre("JFK Airport");
        expResult.setConexiones(null);
        expResult.setNumEjercitos(0);
        expResult.setOwner(null);
        
        Territorio result = new Territorio();
        result = instance.getTerritorio("JFK Airport");
        
        
        assertEquals(expResult, result);
        
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

    /**
     * Test of toString method, of class model.Tablero.
     */
    public void testToString() {
        System.out.println("toString");
        
        Tablero instance = new Tablero();
        
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numTerritoriosTotal method, of class model.Tablero.
     */
    public void testNumTerritoriosTotal() {
        System.out.println("numTerritoriosTotal");
        
        Tablero instance = new Tablero();
        
        int expResult = 0;
        int result = instance.numTerritoriosTotal();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numTerritoriosContinente method, of class model.Tablero.
     */
    public void testNumTerritoriosContinente() {
        System.out.println("numTerritoriosContinente");
        
        Continente c = null;
        Tablero instance = new Tablero();
        
        int expResult = 0;
        int result = instance.numTerritoriosContinente(c);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numContinentes method, of class model.Tablero.
     */
    public void testNumContinentes() {
        System.out.println("numContinentes");
        
        Tablero instance = new Tablero();
        
        int expResult = 0;
        int result = instance.numContinentes();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTodosTerritorios method, of class model.Tablero.
     */
    public void testGetTodosTerritorios() {
        System.out.println("getTodosTerritorios");
        
        Tablero instance = new Tablero();
        
        List<Territorio> expResult = null;
        List<Territorio> result = instance.getTodosTerritorios();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

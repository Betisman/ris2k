/*
 * TestTablero.java
 * JUnit based test
 *
 * Created on 7 de marzo de 2007, 23:50
 */

package tablero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import junit.framework.*;
import model.Continente;
import model.Tablero;
import model.Territorio;

/**
 *
 * @author Carlos
 */
public class TestTablero extends TestCase {
    
    public TestTablero(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
    
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    public void testMostrar(){
        Tablero tablero = new Tablero();
//        tablero.setMapa("web/test/dibujo.xml");
        try{
            tablero.mostrar();
        }
        catch (ris2kException ex)
        {
            fail(ex.getMessage())
        }
        catch (Exception e)
        {
            fail("se encontró una excepción inesperada: "+ e.getMessage());
        }
    }
    /*
    public void testCargarTerritorios(){
        
    }
     */
    
    public void testGetTerritorio(){
        System.out.println(">>> testgetTerritorio()");
        Tablero tablero = new Tablero();
        Continente c1 = new Continente();
        Continente c2 = new Continente();
        Territorio t1 = new Territorio();
        Territorio t2 = new Territorio();
        Territorio t3 = new Territorio();
        Territorio t4 = new Territorio();
        List<Territorio> territorios = new ArrayList();
        List<Continente> continentes = new ArrayList();
        t1.setId("territorio1");
        t2.setId("territorio2");
        t3.setId("territorio3");
        t4.setId("territorio4");
        c1.setId("continente1");
        c2.setId("continente2");
        territorios.add(t1);
        territorios.add(t2);
        c1.setTerritorios(territorios);
        territorios.clear();
        territorios.add(t3);
        territorios.add(t4);
        c2.setTerritorios(territorios);
        continentes.add(c1);
        continentes.add(c2);
        tablero.setContinentes(continentes);
        System.out.println(tablero.getContinentes().get(0).getTerritorios().get(1).getId());
        Territorio objetivo = new Territorio();
//        objetivo.setId("territorio4");
        objetivo = t4;
        
        this.assertEquals(objetivo, tablero.getTerritorio("territorio4"));
    }
 
}

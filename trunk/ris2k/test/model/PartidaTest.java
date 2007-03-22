/*
 * PartidaTest.java
 * JUnit based test
 *
 * Created on 22 de marzo de 2007, 15:52
 */

package model;

import junit.framework.*;
import Exceptions.ris2kException;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 *
 * @author Ramon
 */
public class PartidaTest extends TestCase {
    
    public PartidaTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of inicializar method, of class model.Partida.
     */
    public void testInicializar() throws Exception {
        System.out.println("inicializar");
        
        String nombre = "";
        Jugador owner = null;
        Tablero tablero = null;
        int maxjugadores = 0;
        Partida instance = new Partida();
        
        boolean expResult = true;
        boolean result = instance.inicializar(nombre, owner, tablero, maxjugadores);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class model.Partida.
     */
    public void testGetNombre() {
        System.out.println("getNombre");
        
        Partida instance = new Partida();
        
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class model.Partida.
     */
    public void testSetNombre() {
        System.out.println("setNombre");
        
        String nombre = "";
        Partida instance = new Partida();
        
        instance.setNombre(nombre);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class model.Partida.
     */
    public void testGetOwner() {
        System.out.println("getOwner");
        
        Partida instance = new Partida();
        
        Jugador expResult = null;
        Jugador result = instance.getOwner();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOwner method, of class model.Partida.
     */
    public void testSetOwner() {
        System.out.println("setOwner");
        
        Jugador owner = null;
        Partida instance = new Partida();
        
        instance.setOwner(owner);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablero method, of class model.Partida.
     */
    public void testGetTablero() {
        System.out.println("getTablero");
        
        Partida instance = new Partida();
        
        Tablero expResult = null;
        Tablero result = instance.getTablero();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTablero method, of class model.Partida.
     */
    public void testSetTablero() {
        System.out.println("setTablero");
        
        Tablero tablero = null;
        Partida instance = new Partida();
        
        instance.setTablero(tablero);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumJugadores method, of class model.Partida.
     */
    public void testGetNumJugadores() {
        System.out.println("getNumJugadores");
        
        Partida instance = new Partida();
        
        int expResult = 0;
        int result = instance.getNumJugadores();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumJugadores method, of class model.Partida.
     */
    public void testSetNumJugadores() {
        System.out.println("setNumJugadores");
        
        int numJugadores = 0;
        Partida instance = new Partida();
        
        instance.setNumJugadores(numJugadores);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJugadores method, of class model.Partida.
     */
    public void testGetJugadores() {
        System.out.println("getJugadores");
        
        Partida instance = new Partida();
        
        Vector<Jugador> expResult = null;
        Vector<Jugador> result = instance.getJugadores();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJugadores method, of class model.Partida.
     */
    public void testSetJugadores() {
        System.out.println("setJugadores");
        
        Vector<Jugador> jugadores = null;
        Partida instance = new Partida();
        
        instance.setJugadores(jugadores);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurno method, of class model.Partida.
     */
    public void testGetTurno() {
        System.out.println("getTurno");
        
        Partida instance = new Partida();
        
        Turno expResult = null;
        Turno result = instance.getTurno();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurno method, of class model.Partida.
     */
    public void testSetTurno() {
        System.out.println("setTurno");
        
        Turno turno = null;
        Partida instance = new Partida();
        
        instance.setTurno(turno);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class model.Partida.
     */
    public void testGetScore() {
        System.out.println("getScore");
        
        Partida instance = new Partida();
        
        Score expResult = null;
        Score result = instance.getScore();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class model.Partida.
     */
    public void testSetScore() {
        System.out.println("setScore");
        
        Score score = null;
        Partida instance = new Partida();
        
        instance.setScore(score);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdPartida method, of class model.Partida.
     */
    public void testGetIdPartida() {
        System.out.println("getIdPartida");
        
        Partida instance = new Partida();
        
        String expResult = "";
        String result = instance.getIdPartida();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPartida method, of class model.Partida.
     */
    public void testSetIdPartida() {
        System.out.println("setIdPartida");
        
        String idPartida = "";
        Partida instance = new Partida();
        
        instance.setIdPartida(idPartida);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

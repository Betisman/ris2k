/*
 * TurnoTest.java
 * JUnit based test
 *
 * Created on 22 de marzo de 2007, 19:16
 */

package model;

import junit.framework.*;
import Exceptions.ris2kException;
import java.util.GregorianCalendar;

/**
 *
 * @author Ramon
 */
public class TurnoTest extends TestCase {
    
    public TurnoTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of TurnoInicial method, of class model.Turno.
     */
    public void testTurnoInicial() throws Exception {
        System.out.println("TurnoInicial");
        
        String idPartida = "Prueba";
        String idCreadorPartida = "Usuario";
        Turno expResult = new Turno();
        Turno result = new Turno();
        
        //todo: varios assert equals para cada parámetro de turno.
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdTurno method, of class model.Turno.
     */
    public void testGetIdTurno() {
        System.out.println("getIdTurno");
        
        Turno instance = new Turno();
        
        String expResult = "";
        String result = instance.getIdTurno();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTurno method, of class model.Turno.
     */
    public void testSetIdTurno() {
        System.out.println("setIdTurno");
        
        String idTurno = "";
        Turno instance = new Turno();
        
        instance.setIdTurno(idTurno);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurno method, of class model.Turno.
     */
    public void testGetTurno() {
        System.out.println("getTurno");
        
        Turno instance = new Turno();
        
        int expResult = 0;
        int result = instance.getTurno();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurno method, of class model.Turno.
     */
    public void testSetTurno() {
        System.out.println("setTurno");
        
        int turno = 0;
        Turno instance = new Turno();
        
        instance.setTurno(turno);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class model.Turno.
     */
    public void testGetEstado() {
        System.out.println("getEstado");
        
        Turno instance = new Turno();
        
        EstadoTurno expResult = null;
        EstadoTurno result = instance.getEstado();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class model.Turno.
     */
    public void testSetEstado() {
        System.out.println("setEstado");
        
        EstadoTurno estado = null;
        Turno instance = new Turno();
        
        instance.setEstado(estado);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJugadorActual method, of class model.Turno.
     */
    public void testGetJugadorActual() {
        System.out.println("getJugadorActual");
        
        Turno instance = new Turno();
        
        Jugador expResult = null;
        Jugador result = instance.getJugadorActual();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJugadorActual method, of class model.Turno.
     */
    public void testSetJugadorActual() {
        System.out.println("setJugadorActual");
        
        Jugador jugadorActual = null;
        Turno instance = new Turno();
        
        instance.setJugadorActual(jugadorActual);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdTurnoAnterior method, of class model.Turno.
     */
    public void testGetIdTurnoAnterior() {
        System.out.println("getIdTurnoAnterior");
        
        Turno instance = new Turno();
        
        String expResult = "";
        String result = instance.getIdTurnoAnterior();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTurnoAnterior method, of class model.Turno.
     */
    public void testSetIdTurnoAnterior() {
        System.out.println("setIdTurnoAnterior");
        
        String idTurnoAnterior = "";
        Turno instance = new Turno();
        
        instance.setIdTurnoAnterior(idTurnoAnterior);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdPartida method, of class model.Turno.
     */
    public void testGetIdPartida() {
        System.out.println("getIdPartida");
        
        Turno instance = new Turno();
        
        String expResult = "";
        String result = instance.getIdPartida();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPartida method, of class model.Turno.
     */
    public void testSetIdPartida() {
        System.out.println("setIdPartida");
        
        String idPartida = "";
        Turno instance = new Turno();
        
        instance.setIdPartida(idPartida);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCreadorPartida method, of class model.Turno.
     */
    public void testGetIdCreadorPartida() {
        System.out.println("getIdCreadorPartida");
        
        Turno instance = new Turno();
        
        String expResult = "";
        String result = instance.getIdCreadorPartida();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCreadorPartida method, of class model.Turno.
     */
    public void testSetIdCreadorPartida() {
        System.out.println("setIdCreadorPartida");
        
        String idCreadorPartida = "";
        Turno instance = new Turno();
        
        instance.setIdCreadorPartida(idCreadorPartida);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

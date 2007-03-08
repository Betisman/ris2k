/*
 * MysqlTest.java
 * JUnit based test
 *
 * Created on 7 de marzo de 2007, 19:12
 */

package persistence;

import java.util.GregorianCalendar;
import junit.framework.*;
import javax.servlet.RequestDispatcher;
import model.Jugador;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;

/**
 *
 * @author Ramon
 */
public class MysqlTest extends TestCase {
    
    public MysqlTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
/*****************************************************************************/
    /**
     * Tests of persistirJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/

    /*prueba si un jugador válido se puede persistir*/
    public void testPersistirJugadorValido() {
        System.out.println("persistirJugadorValido");
//        GregorianCalendar ahora = null;
        Jugador jugador;
        
//        ahora.getTime();
//        String userprueba = ahora.toString();
        
        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("emailvalido@dominiovalido.com");
        
        boolean expResult = true;
        boolean result = Mysql.persistirJugador(jugador);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /*prueba que un jugador nulo no se pueda persistir*/
    public void testPersistirJugadorNulo() throws Exception{
        System.out.println("persistirJugadorNulo");
        try
        {
            Jugador jugador = null;
            boolean expResult = true;
            boolean result = Mysql.persistirJugador(jugador);
            assertEquals(expResult, result);
            fail("Debe lanzarse una excepción");
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }
    
}

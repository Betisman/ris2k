/*
 * MysqlTest.java
 * JUnit based test
 *
 * Created on 7 de marzo de 2007, 19:12
 */

package persistence;

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

    /**
     * Test of persistirJugador method, of class persistence.Mysql.
     */
    public void testPersistirJugador() {
        System.out.println("persistirJugador");
        
        Jugador jugador = null;
        
        boolean expResult = true;
        boolean result = Mysql.persistirJugador(jugador);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

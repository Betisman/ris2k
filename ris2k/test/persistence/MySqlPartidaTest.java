/*
 * MySqlPartidaTest.java
 * JUnit based test
 *
 * Created on 24 de marzo de 2007, 12:31
 */

package persistence;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import junit.framework.*;
import Exceptions.ris2kException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import model.Jugador;
import model.Partida;

/**
 *
 * @author Carlos
 */
public class MySqlPartidaTest extends TestCase {
    List<String> idPartidas = new ArrayList();
    
    public MySqlPartidaTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        System.out.println(">>>setUp");
        Statement stmt = null;
        Connection conn = null;
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
          conn = DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
        }catch(SQLException ex) {}
        
        /* Eliminamos posibles partidas de prueba guardadas con anterioridad */
        try{
                stmt = conn.createStatement();                 
                String strSQL = ("DELETE FROM partida WHERE id LIKE 'null';");
                stmt.executeUpdate(strSQL);
                		
                stmt = conn.createStatement();                 
                strSQL = ("DELETE FROM partida WHERE id LIKE 'prueba%';");
                stmt.executeUpdate(strSQL);

        } catch (Exception ex) {                
                System.out.println("NO SE PUDO INICIALIZAR LA BD");
                throw new Exception("NO SETUP");
         }
    }

    protected void tearDown() throws Exception {
        System.out.println(">>>tearDown");
        Statement stmt = null;
        Connection conn = null;
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
          conn = DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
        }catch(SQLException ex) {}
        
        /* Eliminamos posibles partidas de prueba guardadas con anterioridad */
        try{
                stmt = conn.createStatement();                 
                String strSQL = ("DELETE FROM partida WHERE id LIKE null");
                System.out.println(strSQL);
                stmt.executeUpdate(strSQL);
                
                
                for(String id : idPartidas){
                     stmt = conn.createStatement();                 
                    strSQL = ("DELETE FROM partida WHERE nombre = '" + id + "'");
                    System.out.println(strSQL);
                    stmt.executeUpdate(strSQL);
                    
                }
        } catch (Exception ex) {                
                System.out.println("NO SE PUDO RESETEAR LA BD");
                throw new Exception("NO TEARDOWN");
         }
    }

    /**
     * Test of persistirPartida method, of class persistence.MySqlPartida.
     */
    public void testPersistirPartidaNull() throws Exception {
        System.out.println("persistirPartidaNull");
        
        Partida partida = null;
        String mensaje = "Se introdujo null en vez de una partida válida. (MySqlPartida.java)";
        
        try{
            MySqlPartida.persistirPartida(partida);
        }catch(ris2kException ex){
            assertEquals(mensaje, ex.getMessage());
            return;
        }
        fail("Se esperaba una excepción Se introdujeron valores nulos ");
    }
    
    public void testPersistirPartidaValida() throws Exception {
        System.out.println("persistirPartidaValida");
        GregorianCalendar now = new GregorianCalendar();
        Partida p = new Partida();
        Jugador j = new Jugador();
        j.setColor("rojo");
        j.setEmail("jugador@jugador.com");
        j.setPassword("password");
//        j.setUser("usuarioPruebaPersistirPartidaValida");
        j.setUser("Odonkor");
        p.setNombre("pruebaPartida"+now.getTimeInMillis());
        idPartidas.add(p.getNombre());
        p.setNumJugadores(1);
        p.setOwner(j);
        p.getJugadores().add(j);
        
        try{
            MySqlPartida.persistirPartida(p);
        }catch(ris2kException ex){
            System.out.println("excepción: " + ex.getMessage());
        }
        
    }
    
}

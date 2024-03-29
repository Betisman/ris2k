/*
 * MysqlJugadorTest.java
 * JUnit based test
 *
 * Created on 7 de marzo de 2007, 19:12
 */

package persistence;

import Exceptions.ris2kException;
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
public class MysqlJugadorTest extends TestCase {
    
    public MysqlJugadorTest(String testName) {
        super(testName);
    }
    

    protected void setUp() throws Exception {
        
        System.out.println(">>> setUp");
        Statement stmt_consul=null, stmt_inser = null; 
        ResultSet rs = null; 	
        Connection conn= null;
        
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
          conn =
          DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
        }catch(SQLException ex) {}       
        try{
                stmt_inser = conn.createStatement();                 
                String strSQL = ("DELETE FROM user WHERE user LIKE 'null';");
                stmt_inser.executeUpdate(strSQL);
                		
                stmt_inser = conn.createStatement();                 
                strSQL = ("DELETE FROM user WHERE user LIKE 'prueba%';");
                stmt_inser.executeUpdate(strSQL);

        } catch (Exception ex) {                
                System.out.println("NO SE PUDO INICIALIZAR LA BD");
                throw new Exception("NO SETUP");
         }
    }

    protected void tearDown() throws Exception {
        System.out.println(">>> tearDown");
        Statement stmt_consul=null, stmt_inser = null; 
        ResultSet rs = null; 	
        Connection conn= null;
        
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
          conn =
          DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
        }catch(SQLException ex) {}       
        try{

                stmt_inser = conn.createStatement();                 
                String strSQL = ("DELETE FROM user WHERE user LIKE 'null';");
                stmt_inser.executeUpdate(strSQL);

                stmt_inser = conn.createStatement();                 
                strSQL = ("DELETE FROM user WHERE user LIKE 'prueba%';");
                stmt_inser.executeUpdate(strSQL);

                		
         } catch (Exception ex) {                
                System.out.println("NO SE PUDO HACER EL TEAR DOWN");
                throw new Exception("NO TEARDOWN");
         }
    }

/*****************************************************************************/
    /**
     * Tests of persistirJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/

    /*prueba si un jugador v�lido se puede persistir*/
    public void testPersistirJugadorValido() {
        System.out.println(">>> persistirJugadorValido");
        Jugador jugador = new Jugador();
        GregorianCalendar now = new GregorianCalendar();
        
        String prueba = String.valueOf(now.getTimeInMillis());
        jugador.setUser("prueba"+prueba);
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");

        try
        {
            System.out.println("prueba usuario valida -> insertar prueba"+prueba);
            boolean expResult = true;
            boolean result = MysqlJugador.persistirJugador(jugador);
            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
                String mensaje = ex.getMessage();
                fail("Se ha detectado una excepci�n: "+ mensaje +"");
        }
        return;
    }

    /*prueba que un numero elevado de jugadores validos se puedan persistir*/
    public void testPersistirJugadorValidoMuchos() throws Exception{
        System.out.println(">>> persistirJugadorValidoMuchos");
        Jugador jugador = new Jugador();
        String prueba = null;
        int muchos = 50;
        int antes,despues;
        
        //contamos el n�mero inicial de entradas
                Statement stmt_consul=null, stmt_inser = null; 
                ResultSet rs = null; 	
                Connection conn= null;

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
                  conn =
                  DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
                }catch(SQLException ex) {}       
                try{
                    String sql= "SELECT * from user ";
                    antes=0;
                    stmt_consul = conn.createStatement();                
                    ResultSet rset = stmt_consul.executeQuery(sql);
                    while (rset.next()) {antes++;}

                 } catch (Exception ex) {                
                        throw new Exception("NO SE PUDO CONTAR EL NUMERO DE ENTRADAS ANTERIORES");
                 }

        
        //ejecutamos el bucle con "muchos" test
        for(int i=1;i<=muchos;i++)
        {
            GregorianCalendar now = new GregorianCalendar();

            prueba = String.valueOf(now.getTimeInMillis());
            System.out.println("iteraci�n "+i+" -> insertar prueba"+prueba);
            jugador.setUser("prueba"+prueba);
            jugador.setPassword("prueba");
            jugador.setEmail("prueba@prueba.com");
            
            try 
            {   
                boolean expResult = true;
                boolean result = MysqlJugador.persistirJugador(jugador);
                assertEquals(expResult, result);
            }
            catch (Exception ex) {
                String mensaje = ex.getMessage();
                fail("Se ha detectado una excepci�n: "+ mensaje +"");
            }
        }
        
        //contamos el n�mero final de entradas
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
                  conn =
                  DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
                }catch(SQLException ex) {}       
                try{
                    String sql= "SELECT * from user ";
                    despues=0;
                    stmt_consul = conn.createStatement();                
                    ResultSet rset = stmt_consul.executeQuery(sql);
                    while (rset.next()) {despues++;}

                 } catch (Exception ex) {                
                        throw new Exception("NO SE PUDO CONTAR EL NUMERO DE ENTRADAS POSTERIORES");
                 }

        //comparamos si el n�mero de entradas introducido coincide realmente con "muchos"
        
        if (despues-antes==muchos) return;
        else throw new Exception("NO SE INSERTARON TODOS");
    }
    
    /*prueba que un jugados nulo no se pueda persistir*/
    public void testPersistirJugadorNulo() throws Exception{
        System.out.println(">>> persistirJugadorNulo");
        Jugador jugador = new Jugador();
 
        try
        {
            MysqlJugador.persistirJugador(jugador);
        }
  
        catch (ris2kException ex)
        {
            String expResult = "Se introdujeron valores nulos";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("Se esperaba una excepci�n Se introdujeron valores nulos ");
        
    }        

    /*prueba que un jugador sin nombre no se pueda persistir*/
    public void testPersistirJugadorSinNombre() throws Exception{
        System.out.println(">>> persistirJugadorSinNombre");
        Jugador jugador = new Jugador();

        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
 
        try
        {
            MysqlJugador.persistirJugador(jugador);
        }
  
        catch (ris2kException ex)
        {

            String expResult = "Se introdujeron valores nulos";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("Debe lanzarse una excepci�n Se introdujeron valores nulos");
        
    }

    /*prueba que un jugador sin password no se pueda persistir*/
    public void testPersistirJugadorSinPassword() throws Exception{
        System.out.println(">>> persistirJugadorSinPassword");
        Jugador jugador = new Jugador();
        GregorianCalendar now = new GregorianCalendar();

        String prueba = String.valueOf(now.getTimeInMillis());
        jugador.setUser("prueba"+prueba);
        jugador.setEmail("prueba@prueba.com");
 
        try
        {
            MysqlJugador.persistirJugador(jugador);
        }
  
        catch (ris2kException ex)
        {

            String expResult = "Se introdujeron valores nulos";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("Debe lanzarse una excepci�n Se introdujeron valores nulos");
       
    }
    
    /*prueba que un jugador sin email no se pueda persistir*/
    public void testPersistirJugadorSinEmail() throws Exception{
        System.out.println(">>> persistirJugadorSinEmail");
        Jugador jugador = new Jugador();
        GregorianCalendar now = new GregorianCalendar();
        
        String prueba = String.valueOf(now.getTimeInMillis());
        jugador.setUser("prueba"+prueba);
        jugador.setPassword("prueba");
 
        try
        {
            MysqlJugador.persistirJugador(jugador);
        }
  
        catch (ris2kException ex)
        {

            String expResult = "Se introdujeron valores nulos";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("Debe lanzarse una excepci�n del tipo: Se introdujeron valores nulos");
       
    }
    
    /*prueba que un jugador no se pueda persistir dos veces*/
    public void testPersistirJugadorDuplicado() throws Exception{
        System.out.println(">>> persistirJugadorDuplicado");
 
        Jugador jugador = new Jugador();
        GregorianCalendar now = new GregorianCalendar();
        
        String prueba = String.valueOf(now.getTimeInMillis());
        
        jugador.setUser("prueba"+prueba);
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
 
        try
        {
            MysqlJugador.persistirJugador(jugador);
        }
        catch (Exception ex)
        {
            throw new Error("FALLO EN EL METODO PERSISTIR JUGADOR");
        }
        
        try
        {
            MysqlJugador.persistirJugador(jugador);
        }
        catch (Exception ex)
        {
            String expResult = "Usuario duplicado en la Base de Datos";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        
        fail("Debe lanzarse una excepci�n del tipo: Usuario duplicado en la Base de Datos");
       
    }
    
/*****************************************************************************/
    /**
     * Tests of borrarJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/
    
   /*prueba que un jugador existente se puede borrar*/
    public void testBorrarJugador() {
        System.out.println(">>> borrarJugadorExistente");
        Jugador jugador = new Jugador();
        GregorianCalendar now = new GregorianCalendar();
        
        String prueba = String.valueOf(now.getTimeInMillis());
        
        jugador.setUser("prueba"+prueba);
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        try {
            MysqlJugador.persistirJugador(jugador);
        } 
        catch (Exception ex) {
            throw new Error("FALLO EN EL METODO PERSISTIR JUGADOR");
        }
       
        try {
            MysqlJugador.borrarJugador("prueba"+prueba);
        } 
        catch (Exception ex) {
            fail("Se ha encontrado una excepci�n tipo: "+ex.getMessage());
        }
        
        try {
            MysqlJugador.validarJugador(jugador);
        }
        catch (ris2kException ex){
            String expResult = "Usuario no v�lido en la Base de Datos";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("La entrada sigue en la BD y deber�a haberse borrado");
        
    //    fail("Ha saltado una excepci�n");
    }


/*****************************************************************************/
    /**
     * Tests of validarJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/

   /*prueba que un jugador existente se puede validar*/
    public void testValidarJugadorValido() {
        System.out.println(">>> ValidarJugadorValido");
 
        Jugador jugador = new Jugador();
        GregorianCalendar now = new GregorianCalendar();
        
        String prueba = String.valueOf(now.getTimeInMillis());
        
        jugador.setUser("prueba"+prueba);
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        try {
            MysqlJugador.persistirJugador(jugador);
        } 
        catch (Exception ex) {
            throw new Error("FALLO EN EL METODO PERSISTIR JUGADOR");
        }
 
        try {
        boolean expResult = true;
        boolean result = MysqlJugador.validarJugador(jugador);
        assertEquals(expResult, result);
        return;
        }
        catch(Exception ex){
            fail("Deber�a haber validado");
        }   
    }
    
    public void testValidarJugadorInexistente()throws Exception{
        System.out.println(">>> validarrJugadorInexistente");
      
        MysqlJugador.borrarJugador("prueba00000000");
        
        try
        {
            Jugador jugador = new Jugador();
            jugador.setUser("prueba00000000");
            jugador.setPassword("prueba");
            jugador.setEmail("prueba@prueba.com");

            boolean expResult = false;
            boolean result = MysqlJugador.validarJugador(jugador);
        }
        catch (Exception e)
        {
              System.out.println(e.getMessage());
              assertEquals(e.getMessage(),"Usuario no v�lido en la Base de Datos");
              return;
        }
        fail("No deber�a haber validado");
    }
    
    public void testValidarJugadorPasswordErroneo(){
        System.out.println(">>> validarrJugadorPasswordErroneo");

        Jugador jugador = new Jugador();
        GregorianCalendar now = new GregorianCalendar();
        
        String prueba = String.valueOf(now.getTimeInMillis());
        
        jugador.setUser("prueba"+prueba);
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        try {
            MysqlJugador.persistirJugador(jugador);
        } 
        catch (Exception ex) {
            throw new Error("FALLO EN EL METODO PERSISTIR JUGADOR");
        }
        
        try
        {
            jugador.setUser("prueba"+prueba);
            jugador.setPassword("erroneo");
            jugador.setEmail("prueba@prueba.com");

            boolean expResult = false;
            boolean result = MysqlJugador.validarJugador(jugador);
        }
        catch (Exception e)
        {
              System.out.println(e.getMessage());
              assertEquals(e.getMessage(),"Usuario no v�lido en la Base de Datos");
              return;
        }
        fail("No deber�a haber validado");
    }
    
    public void testValidarJugadorVacio()throws Exception{
        System.out.println(">>> validarJugadorVacio");
      
        
        try
        {
            Jugador jugador = new Jugador();

            boolean expResult = false;
            boolean result = MysqlJugador.validarJugador(jugador);
        }
        catch (Exception e)
        {
              System.out.println(e.getMessage());
              assertEquals(e.getMessage(),"Usuario no v�lido en la Base de Datos");
              return;
        }
        fail("No deber�a haber validado");
    }

//***************************************************************************/
/*****************************************************************************/
    /**
     * Tests of getJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/

   /*prueba que un jugador existente se puede recuperar*/
    public void testGetJugadorValido() {
        System.out.println(">>> GetJugadorValido");
 
        Jugador jugador = new Jugador();
        GregorianCalendar now = new GregorianCalendar();
        
        String prueba = String.valueOf(now.getTimeInMillis());
        
        //jugador.setUser("prueba"+prueba);
        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        Jugador result = new Jugador();

        try {
            MysqlJugador.persistirJugador(jugador);
        } 
        catch (Exception ex) {
            throw new Error("FALLO EN EL METODO PERSISTIR JUGADOR");
        }
 
        try {
        result = MysqlJugador.getJugador(jugador.getUser());
        assertEquals(jugador.getUser(), result.getUser());
        return;
        }
        catch(Exception ex){
            fail(ex.getMessage());
        }   
    }
    
    public void testGetJugadorInexistente()throws Exception{
        System.out.println(">>> validarrJugadorInexistente");
      
        MysqlJugador.borrarJugador("prueba00000000");
        
        try
        {
            MysqlJugador.getJugador("prueba00000000");
        }
        catch (Exception e)
        {
              System.out.println(e.getMessage());
              assertEquals(e.getMessage(),"Error al obtener el jugador prueba00000000 de la base de datos.");
              return;
        }
        fail("No deber�a haber validado");
    }
    
//***************************************************************************/
}
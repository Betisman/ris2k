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
                String strSQL = ("DELETE FROM user WHERE user LIKE 'prueba%';");
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
                String strSQL = ("DELETE FROM user WHERE user LIKE 'prueba%';");
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

    /*prueba si un jugador válido se puede persistir*/
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
            boolean result = Mysql.persistirJugador(jugador);
            assertEquals(expResult, result);
            
        }
        catch (Exception ex)
        {
                String mensaje = ex.getMessage();
                fail("Se ha detectado una excepción: "+ mensaje +"");
        }
        return;
    }

    /*prueba que un numero elevado de jugadores validos se puedan persistir*/
    public void testPersistirJugadorValidoMuchos() throws Exception{
        System.out.println(">>> persistirJugadorValidoMuchos");
        Jugador jugador = new Jugador();
        String prueba = null;
        int muchos = 10;
        int antes,despues;
        
        //contamos el número inicial de entradas
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
            System.out.println("iteración "+i+" -> insertar prueba"+prueba);
            jugador.setUser("prueba"+prueba);
            jugador.setPassword("prueba");
            jugador.setEmail("prueba@prueba.com");
            
            try 
            {   
                boolean expResult = true;
                boolean result = Mysql.persistirJugador(jugador);
                assertEquals(expResult, result);
            }
            catch (Exception ex) {
                String mensaje = ex.getMessage();
                fail("Se ha detectado una excepción: "+ mensaje +"");
            }
        }
        
        //contamos el número final de entradas
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

        //comparamos si el número de entradas introducido coincide realmente con "muchos"
        
        if (despues-antes==muchos) return;
        else throw new Exception("NO SE INSERTARON TODOS");
    }
    
    /*prueba que un jugados nulo no se pueda persistir*/
    public void testPersistirJugadorNulo() throws Exception{
        System.out.println(">>> persistirJugadorNulo");
        Jugador jugador = new Jugador();
 
        
        try
        {
            Mysql.persistirJugador(jugador);
        }
  
        catch (Exception ex)
        {
            String expResult = "NO INSERT";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("Se esperaba una excepción NO INSERT ");
        
    }        

    /*prueba que un jugador sin nombre no se pueda persistir*/
    /*public void testPersistirJugadorSinNombre() throws Exception{
        System.out.println(">>> persistirJugadorSinNombre");
        Jugador jugador = new Jugador();
//        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
 
        try
        {
            Mysql.persistirJugador(jugador);
        }
  
        catch (Exception ex)
        {

            String expResult = "NO INSERT";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("Debe lanzarse una excepción NO INSERT");
        
    }
*/
    /*prueba que un jugador sin password no se pueda persistir*/
  /*  public void testPersistirJugadorSinPassword() throws Exception{
        System.out.println(">>> persistirJugadorSinPassword");
        try
        {
            Jugador jugador = null;
            jugador.setUser("prueba");
//            jugador.setPassword("prueba");
            jugador.setEmail("prueba@prueba.com");

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
    */
    /*prueba que un jugador sin email no se pueda persistir*/
   /* public void testPersistirJugadorSinEmail() throws Exception{
        System.out.println(">>> persistirJugadorSinEmail");
        try
        {
            Jugador jugador = null;
            jugador.setUser("prueba");
            jugador.setPassword("prueba");
//            jugador.setEmail("prueba@prueba.com");

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
    */
/*****************************************************************************/
    /**
     * Tests of borrarJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/
    
   /*prueba si un jugador existente se puede borrar*/
   /* public void testBorrarJugador() {
        System.out.println(">>> borrarJugadorExistente");
        Jugador jugador = new Jugador();
       
        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        System.out.println("INSERTAMOS USUARIO DE PRUEBA DE LA BD(Si no existe anteriormente)");
        try {
            Mysql.persistirJugador(jugador);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        Mysql.borrarJugador("prueba");
        
        boolean expResult = false;
        boolean result = Mysql.validarJugador(jugador);
        assertEquals(expResult, result);
                
    //    fail("Ha saltado una excepción");
    }
*/

/*****************************************************************************/
    /**
     * Tests of validarJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/

  /*  public void testValidarJugadorValido() {
        System.out.println(">>> ValidarJugadorValido");
 
        Jugador jugador = new Jugador();
       
        System.out.println("NOS ASEGURAMOS DE QUE EXISTA UN USUARIO DE PRUEBA CONCRETO");

        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        Mysql.borrarJugador("prueba");
        try {
            Mysql.persistirJugador(jugador);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
 //       TODO:                
        
        System.out.println("COMPROBAMOS QUE AL CONSULTAR ESE MISMO USUARIO, EL RESULTADO ES CORRECTO");
        boolean expResult = true;
        boolean result = Mysql.validarJugador(jugador);
        assertEquals(expResult, result);
                
    //    fail("Ha saltado una excepción");
    }
    
    public void testValidarJugadorInexistente()throws Exception{
        System.out.println(">>> validarrJugadorInexistente");

        System.out.println("NOS ASEGURAMOS DE QUE NO EXISTA UN USUARIO DE PRUEBA CONCRETO");
        Mysql.borrarJugador("prueba");
        
        try
        {
            Jugador jugador = null;
            jugador.setUser("prueba");
            jugador.setPassword("prueba");
            jugador.setEmail("prueba@prueba.com");

            boolean expResult = true;
            boolean result = Mysql.validarJugador(jugador);
            assertEquals(expResult, result);
            fail("Debe lanzarse una excepción");
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }
    
    public void testValidarJugadorPasswordErroneo(){
        System.out.println(">>> validarrJugadorPasswordErroneo");

        Jugador jugador = new Jugador();
       
        System.out.println("NOS ASEGURAMOS DE QUE EXISTA UN USUARIO DE PRUEBA CONCRETO");

        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        Mysql.borrarJugador("prueba");
        try {
            Mysql.persistirJugador(jugador);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try
        {
            jugador.setUser("prueba");
            jugador.setPassword("error");
            jugador.setEmail("prueba@prueba.com");

            boolean expResult = false;
            boolean result = Mysql.validarJugador(jugador);
            assertEquals(expResult, result);
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }
    */
    //*************************************************************************************
}
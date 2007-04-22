/*
 * MySqlPartidaTest.java
 * JUnit based test
 *
 * Created on 21 de abril de 2007, 19:05
 */

package persistence;

import java.util.GregorianCalendar;
import junit.framework.*;
import Exceptions.ris2kException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import model.Jugador;
import model.Partida;
import persistence.MysqlJugador;

/**
 *
 * @author Ramon
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
        idPartidas.clear();
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
                String strSQL = ("DELETE FROM partida");
                stmt.executeUpdate(strSQL);
                		
                stmt = conn.createStatement();                 
                strSQL = ("DELETE FROM partida_user;");
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
                String strSQL = ("DELETE FROM partida");
                System.out.println(strSQL);
                stmt.executeUpdate(strSQL);
                
                
                for(String id : idPartidas){
                     stmt = conn.createStatement();                 
                    strSQL = ("DELETE FROM partida_user");
                    System.out.println(strSQL);
                    stmt.executeUpdate(strSQL);
                    
                }
        } catch (Exception ex) {                
                System.out.println("NO SE PUDO RESETEAR LA BD");
                throw new Exception("NO TEARDOWN");
         }
    }

 
    
 /*****************************************************************************/
    /**
     * Tests of persistirPartida method, of class persistence.Mysqlpartida.
     */
/*****************************************************************************/

    /*prueba si una partida válido se puede persistir*/
    public void testPersistirPartidaValida() {
        System.out.println(">>> persistirPartidaValido");
        GregorianCalendar now = new GregorianCalendar();
        Partida p = new Partida();
        Jugador j = new Jugador();
 
        j.setEmail("jugador@jugador.com");
        j.setPassword("password");
        j.setUser("Odonkor");
        p.setNombre("pruebaPartida"+now.getTimeInMillis());
        idPartidas.add(p.getNombre());
        p.setNumJugadores(1);
        p.setOwner(j);
        p.getJugadores().add(j);
       
        
        try{
            MySqlPartida.persistirPartida(p);
        }catch(Exception ex){
            System.out.println("excepción: " + ex.getMessage());
        }
        
    }

    /*prueba que un numero elevado de partidas, con distintos creadores se puedan persistir*/
    public void testPersistirPartidaValidaMuchos() throws Exception{
        System.out.println(">>> persistirPartidaValidaMuchos");
        Partida p = new Partida();
        Jugador j = new Jugador();
        String prueba = null;
        int muchos = 3;
        int antes,despues;
        GregorianCalendar now;
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
                    String sql= "SELECT * from partida ";
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
            now = new GregorianCalendar();

            prueba = String.valueOf(now.getTimeInMillis()+i);
            System.out.println("iteración "+i+" -> insertar prueba"+prueba);
            
            j.setUser("prueba"+prueba);
            j.setEmail("jugador@jugador.com");
            j.setPassword("password");
            
            try 
            {   
                MysqlJugador.persistirJugador(j);
            }
            catch (Exception ex) {
                throw new Error("FALLO EN EL METODO PERSISTIR JUGADOR: " +ex.getMessage());
            }
            
            
            p.setIdPartida(null);
            p.setNombre("pruebaPartida"+prueba);
            idPartidas.add(p.getNombre());
            p.setNumJugadores(1);
            p.setOwner(j);
            p.getJugadores().add(j);

            try 
            {   
                MySqlPartida.persistirPartida(p);
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
                    String sql= "SELECT * from partida ";
                    despues=0;
                    stmt_consul = conn.createStatement();                
                    ResultSet rset = stmt_consul.executeQuery(sql);
                    while (rset.next()) {despues++;}

                 } catch (Exception ex) {                
                        throw new Exception("NO SE PUDO CONTAR EL NUMERO DE ENTRADAS POSTERIORES");
                 }

        //comparamos si el número de entradas introducido coincide realmente con "muchos"
        
        if (despues-antes==muchos) return;
        else throw new Error("NO SE INSERTARON TODOS: tenían que entrar "+muchos+" y entraron solo"+(despues-antes));
    }
    
    
    /*prueba que una partida nulo no se pueda persistir*/
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
    
    /*prueba que una partida sin nombre no se pueda persistir*/
    public void testPersistirPartidaSinNombre() throws Exception{
        System.out.println(">>> persistirPartida sun nombre");
        GregorianCalendar now = new GregorianCalendar();
        Partida p = new Partida();
        Jugador j = new Jugador();
 
        j.setEmail("jugador@jugador.com");
        j.setPassword("password");
        j.setUser("Odonkor");
//        p.setNombre("pruebaPartida"+now.getTimeInMillis());
        idPartidas.add(p.getNombre());
        p.setNumJugadores(1);
        p.setOwner(j);
        p.getJugadores().add(j);
 
        try
        {
            MySqlPartida.persistirPartida(p);
        }
  
        catch (ris2kException ex)
        {

            String result = ex.getMessage();
            if (result.contains("Se introdujeron valores nulos"))return;
            else fail("se detecto una excepción, pero no era la esperada: "+result);
        }
        fail("No se debía haber dejado persistir la partida incorrecta");
        
    }

    /*prueba que una partida sin owner no se pueda persistir*/
    public void testPersistirPartidaSinOwner() throws Exception{
        System.out.println(">>> persistirPartida sin owner");
        GregorianCalendar now = new GregorianCalendar();
        Partida p = new Partida();
        Jugador j = new Jugador();
 
        j.setEmail("jugador@jugador.com");
        j.setPassword("password");
        j.setUser("Odonkor");
        p.setNombre("pruebaPartida"+now.getTimeInMillis());
        idPartidas.add(p.getNombre());
        p.setNumJugadores(1);
//        p.setOwner(j);
        p.getJugadores().add(j);
 
        try
        {
            MySqlPartida.persistirPartida(p);
        }
  
        catch (ris2kException ex)
        {

            String result = ex.getMessage();
            if (result.contains("Error en la consulta de inserción de una nueva partida"))return;
            else fail("se detecto una excepción, pero no era la esperada: "+result);
        }
        fail("No se debía haber dejado persistir la partida incorrecta");
        
    }

      /*prueba que una partida sin nombre no se pueda persistir*/
    public void testPersistirPartidaSinJugadores() throws Exception{
        System.out.println(">>> persistirPartida sun nombre");
        GregorianCalendar now = new GregorianCalendar();
        Partida p = new Partida();
 
        idPartidas.add(p.getNombre());
        p.setNumJugadores(0);
 //     p.setOwner(j);
 //     p.getJugadores().add(j);
 
        try
        {
            MySqlPartida.persistirPartida(p);
        }
  
        catch (ris2kException ex)
        {

            String result = ex.getMessage();
            if (result.contains("Se introdujeron valores nulos"))return;
            else fail("se detecto una excepción, pero no era la esperada: "+result);
        }
        fail("No se debía haber dejado persistir la partida incorrecta");
        
    }
  
    /*prueba que un jugador no se pueda persistir dos veces*/
    public void testPersistirPartidaDuplicada() throws Exception{
        System.out.println(">>> persistirPartidaDuplicado");
        GregorianCalendar now = new GregorianCalendar();
        Partida p = new Partida();
        Partida q = new Partida();
        Jugador j = new Jugador();
        Jugador k = new Jugador();
 
        j.setEmail("jugador@jugador.com");
        j.setPassword("password");
        j.setUser("Odonkor"+now.getTimeInMillis());
        
        k.setEmail("jugador@jugador.com");
        k.setPassword("password");
        k.setUser("Prosinecki");
        String nombre= "Lopera"+now.getTimeInMillis();
        
        p.setNombre(nombre);
        idPartidas.add(p.getNombre());
        p.setNumJugadores(1);
        p.setOwner(j);
        p.getJugadores().add(j);
       
        q.setNombre(nombre);
        idPartidas.add(q.getNombre());
        q.setNumJugadores(1);
        q.setOwner(k);
        q.getJugadores().add(k);
       
        
 
        try
        {
            MysqlJugador.persistirJugador(j);
        }
        catch (Exception ex)
        {
            throw new Error("FALLO EN EL METODO PERSISTIR JUGADOR: "+ex.getMessage());
        }

        try
        {
            MySqlPartida.persistirPartida(p);
        }
        catch (Exception ex)
        {
            throw new Error("FALLO EN EL METODO PERSISTIR PARTIDA: "+ex.getMessage());
        }
        
        try
        {
            MySqlPartida.persistirPartida(q);
        }
        catch (Exception ex)
        {
            if (ex.getMessage().contains("Ya existe una partida llamada"))return;
            else fail("se detecto una excepción, pero no era la esperada: "+ex.getMessage());
        }
        
        fail("Debe lanzarse una excepción del tipo: Ya existe una partida llamada así");
       
    }
    
/*****************************************************************************/
    /**
     * Tests get partida, of class persistence.Mysql.
     */
/*****************************************************************************/
    

   /*prueba que un jugador existente se puede recuperar*/
    public void testGetPartidaValida() {
        System.out.println(">>> getPartidaValido");
        GregorianCalendar now = new GregorianCalendar();
        Partida p = new Partida();
        Jugador j = new Jugador();
 
        j.setEmail("jugador@jugador.com");
        j.setPassword("password");
        j.setUser("Odonkor");
        p.setNombre("pruebaPartida"+now.getTimeInMillis());
        idPartidas.add(p.getNombre());
        p.setNumJugadores(1);
        p.setOwner(j);
        p.getJugadores().add(j);
         
        
        try {
            MySqlPartida.persistirPartida(p);
        } 
        catch (Exception ex) {
            throw new Error("FALLO EN EL METODO PERSISTIR PARTIDA: "+ex.getMessage());
        }
 
        Partida result = new Partida();

        try {
        result = MySqlPartida.getPartida(p.getIdPartida());
        assertEquals(p.getIdPartida(), result.getIdPartida());
        return;
        }
        catch(Exception ex){
            fail(ex.getMessage());
        }   
    }

   /*prueba que un jugador inexistente no se puede recuperar*/
    public void testGetPartidaInexistente() {
        System.out.println(">>> getPartidaInexistente");
 
          
        try
        {
            MySqlPartida.getPartida("prueba00000000");
        }
        catch (Exception e)
        {
              System.out.println(e.getMessage());
              if (e.getMessage().contains("Error al obtener la partida"))return;
              else fail("Se recibio una excepción, pero no la esperada: "+e.getMessage());
        }
        fail("No debería haber validado");
        
    }   
    
  
//***************************************************************************/
   
}

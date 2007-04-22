/*
 * MySqlPartida.java
 *
 * Created on 23 de marzo de 2007, 20:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package persistence;

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
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Carlos
 */
public class MySqlPartida {
    static Logger log = Logger.getLogger(MySqlPartida.class);    
    /** Creates a new instance of MySqlPartida */
    public MySqlPartida() {
    }
    
    public static String persistirPartida(Partida partida) 
    throws ris2kException {  
        Statement stmt=null; 
        ResultSet rs = null; 	
        Connection conn= null;
        if (partida == null){
            log.warn("Se introdujo null en vez de una partida válida");
            throw new ris2kException("Se introdujo null en vez de una partida válida. (MySqlPartida.java)");
        }
        /*recogemos los valores de la partida a persistir*/
        String idPartida = partida.getIdPartida();
        String nombre = partida.getNombre();  
        Jugador owner = partida.getOwner();
//        Tablero tablero = partida.getTablero();
        int numJugadores = partida.getNumJugadores();
        List<Jugador> jugadores = partida.getJugadores();
//        Vector <Jugada> jugadas = partida.getJugadas();
//        Turno turno = partida.getTurno();
//        Score score = partida.getScore();
       
        //control de elementos nulos, los cuales no se pueden persistir
        if ((nombre==null)||(owner==null)||(jugadores==null)){
            log.warn("Se introdujeron valores nulos");
            throw new ris2kException("Se introdujeron valores nulos");
        }
        int contador=0;
        
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
        }catch(SQLException ex) {
            log.error("Fallo en la conexión a la base de datos");
            throw new ris2kException("Fallo en la conexión a la base de datos");
        }       
        try{ //insertamos una nueva Partida
                stmt = conn.createStatement();
                String strSQLPartida = null;
                if (idPartida == null){ //partida Nueva
                    strSQLPartida = ("INSERT INTO partida VALUES (0, '" 
                            + nombre + "','" + owner.getUser() +"', "+partida.getNumJugadores()+") ");
                }else{ //ya existe la partida
                    strSQLPartida = ("UPDATE partida SET "
                            + "nombre='"+ nombre + "', "
                            + "idcreador='" + owner.getUser() + "', "
                            + "numjugadores='" + partida.getNumJugadores()+"' "
                            + "WHERE id = " + idPartida);
                }
                System.out.println("debugging: " + strSQLPartida);
                stmt.executeUpdate(strSQLPartida);
                //System.out.println("SE INSERTARON LOS DATOS");     
                log.info("Se insertaron los datos relativos a la partida");
         } catch (SQLException ex) {
             if (ex.getMessage().contains("Duplicate entry")){
                log.info("Ya existe una partida con ese nombre");
                throw new ris2kException("Ya existe una partida llamada '" + partida.getNombre()
                    + "' en la Base de Datos");
             }else{
                 log.warn("Error en la consulta de inserción de una nueva partida.");
                 throw new ris2kException("Error en la consulta de inserción de una nueva partida: "+ ex.getMessage());
             }
         }
        try{ //insertamos los jugadores de la Partida
                stmt = conn.createStatement();
                if (idPartida == null){ /*si la partida es nueva, obtenemos su id */
                    String strSql = "SELECT MAX(id) FROM partida";
                    rs = stmt.executeQuery(strSql);
                    rs.next();
                    idPartida = String.valueOf(rs.getInt(1));
                    partida.setIdPartida(String.valueOf(idPartida));
                }
                for(Jugador j : jugadores){
                    String strSQLPartida = ("INSERT INTO partida_user VALUES (" + idPartida
                            + ",'" + j.getUser() +"')");
                    //System.out.println("debugging: " + strSQLPartida);
                    log.debug("debugging: " + strSQLPartida);
                    try{
                        stmt.executeUpdate(strSQLPartida);
                    }catch(SQLException ex){
                        if (ex.getMessage().contains("Duplicate entry"))
                            log.info("Duplicación al asociar el jugador " + j.getUser() + " a la partida " + idPartida);
                            //System.out.println("Duplicación al asociar el jugador " + j.getUser() + " a la partida " + idPartida);
                    }
                    System.out.println("Insertado " + j.toString() + " en la partida " + partida.getIdPartida());
                }
                log.info("Se insertaron los datos relativos a la partida");
                //System.out.println("SE INSERTARON LOS DATOS");
                stmt.close();
                return idPartida;                		
         } catch (SQLException ex) {
             if (ex.getMessage().contains("Duplicate entry")){
                 log.info("Usuario duplicado en la base de datos"); 
                 throw new ris2kException("Usuario duplicado en la Base de Datos");
             }
             else{
                 log.info("Error en la consulta de inserción de jugadores en la partida. ");
                 throw new ris2kException("Error en la consulta de inserción de jugadores en la partida. " + ex.getMessage());
             }
         }    
   }
    
    public static Partida getPartida(String idPartida) 
    throws ris2kException {
        Partida partida = new Partida();
        //configurar conexion a la base de datos (deberíamos crear un objeto conexion para no repetir esto)
        Statement stmt=null; 
        ResultSet rs = null; 	
        Connection conn= null;
        if (idPartida == null)
            throw new ris2kException("Se introdujo null en vez de un id de una partida válida. (MySqlPartida.getPartida())");
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
        }catch(SQLException ex) {
            log.error("Fallo en la conexión a la base de datos.");
            throw new ris2kException("Fallo en la conexión a la base de datos");
        }
        
        //buscar la partida en la base de datos y recuperarla
        try{
            stmt = conn.createStatement();
            String strSQLPartida = null;
            strSQLPartida = "SELECT id, nombre, idcreador, numjugadores FROM partida WHERE id = '" + idPartida + "'";
            rs = stmt.executeQuery(strSQLPartida);
            rs.next();
            partida.setIdPartida(idPartida);
            
            ResultSetMetaData metaDatos = rs.getMetaData();
            // Se obtiene el número de columnas.
            int numeroColumnas = metaDatos.getColumnCount();
            // Se obtiene cada una de las etiquetas para cada columna
            for (int i = 0; i < numeroColumnas; i++)
               System.out.println(metaDatos.getColumnLabel(i + 1));
            
            
            partida.setNombre(rs.getString("nombre"));
            String idCreador = rs.getString("idcreador");
            partida.setOwner(MysqlJugador.getJugador(idCreador));
            partida.setNumJugadores(rs.getInt("numjugadores"));
            /*
            partida.setNombre(rs.getString(2));
            String idCreador = rs.getString(3);
            partida.setOwner(MysqlJugador.getJugador(idCreador));
            partida.setNumJugadores(rs.getInt(4));
             */
            
            
            System.out.println(partida.toString());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());

            log.warn("Error al obtener la partida de la base de datos");
            throw new ris2kException("Error al obtener la partida "+ idPartida + " de la base de datos.");
        }catch(ris2kException ex){
            System.out.println(ex.getMessage());
        }
        //buscar los jugadores que pertenecen a la partida y meterlos en el objeto partida
        try{
            stmt = conn.createStatement();
            String strSQLPartida = null;
            strSQLPartida = "SELECT idpartida, idjugador FROM partida_user WHERE idpartida = '" + idPartida + "'";
            rs = stmt.executeQuery(strSQLPartida);
            while(rs.next() != false){
                partida.getJugadores().add(MysqlJugador.getJugador(rs.getString("idjugador")));
//                partida.getJugadores().add(MysqlJugador.getJugador(rs.getString(2)));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());System.out.println("falla aquí");
            log.error("Error al obtener los jugadores de la partida");
            throw new ris2kException("Error al obtener los jugadores de la partida "+ idPartida + " de la base de datos.");
        }catch(ris2kException ex){
            System.out.println(ex.getMessage());
        }
        
        return partida;
    }
    
    public static List<Partida> getTodasPartidas() 
    throws ris2kException {
        List<Partida> partidas = new ArrayList();
        
        //configurar conexion a la base de datos (deberíamos crear un objeto conexion para no repetir esto)
        Statement stmt=null; 
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
        }catch(SQLException ex) {
            log.error("Fallo en la conexión a la base de datos.");
            throw new ris2kException("Fallo en la conexión a la base de datos");
        }
        
        //buscar la partida en la base de datos y recuperarla
        try{
            stmt = conn.createStatement();
            String strSQLPartida = null;
            strSQLPartida = "SELECT id FROM partida";
            rs = stmt.executeQuery(strSQLPartida);
            while(rs.next() != false){
                String id = rs.getString("id");
                Partida p = getPartida(id);
                partidas.add(p);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return partidas;
    }
    
    public static List<Partida> getPartidasAbiertas() 
    throws ris2kException {
        List<Partida> partidas = getTodasPartidas();
        System.out.println("partidas = " + String.valueOf(partidas.size()));
        List<Partida> aux = new ArrayList();
        for(Partida p : partidas){
            System.out.println("num = " + p.getNumJugadores() + " - jugs = " + p.getJugadores().size());
            if (p.getNumJugadores() > p.getJugadores().size())
                aux.add(p);
        }
        log.debug("partidas tras corte = " + String.valueOf(partidas.size()));
        //System.out.println("partidas tras corte = " + String.valueOf(partidas.size()));
        return aux;
    }
    
}

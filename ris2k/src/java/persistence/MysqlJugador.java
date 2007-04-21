package persistence;

import Exceptions.ris2kException;
import javax.servlet.RequestDispatcher;
import model.Jugador;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MysqlJugador {
    static Logger log = Logger.getLogger(MysqlJugador.class);    
    public MysqlJugador() {
    }
   
    
    public static boolean persistirJugador(Jugador jugador) 
    throws ris2kException {  
        Statement stmt_consul=null, stmt_inser = null; 
        ResultSet rs = null; 	
        Connection conn= null;
        String user=jugador.getUser();
        String password=jugador.getPassword();
        String email=jugador.getEmail();
        PropertyConfigurator.configure("log4j.properties");
       
        //control de elementos nulos, los cuales no se pueden persistir
        if ((user==null)||(password==null)||(email==null)){ 
            log.info("Se introdujeron valores nulos");
            throw new ris2kException("Se introdujeron valores nulos");
        }
       
        int contador=0;
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                log.error(ex.toString());
                ex.printStackTrace();                
            } catch (IllegalAccessException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            }
          conn =
          DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
        }catch(SQLException ex) {
            log.error("Fallo en la conexión a la base de datos");
            throw new ris2kException("Fallo en la conexión a la base de datos");            
        }       
        try{
                stmt_inser = conn.createStatement();                 
                String strSQL = ("INSERT INTO user VALUES ('" + user + "','" + password + "','" + email +"') ");
                stmt_inser.executeUpdate(strSQL);
                System.out.println("SE INSERTARON LOS DATOS");
                log.info("Se insertaron los datos");
                return true;
                		
         } catch (SQLException ex) {                
             log.info("Usuario duplicado en la base de datos");   
             throw new ris2kException("Usuario duplicado en la Base de Datos");
         }
   }
    public static boolean validarJugador(Jugador jugador) throws ris2kException {
        Statement stmt_consul = null, stmt_inser =  null;
        ResultSet rs = null;
        Connection conn= null;
        String user = jugador.getUser();
        String password = jugador.getPassword();
        String sql;
    
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            }
          conn =
            DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");  
        }catch(SQLException ex) {
        log.error("Fallo en la conexión a la base de datos");
        throw new ris2kException("Fallo en la conexión a la base de datos");
        } 
        try{
                
                sql= "SELECT * from user where user='"+user+"' and password='"+password+"'";                
                int rows=0;
                stmt_consul = conn.createStatement();                
                ResultSet rset = stmt_consul.executeQuery(sql);
                while (rset.next()) {rows++;}
 
                int resultcount = 0;                
                System.out.println("ROWCOUNT: "+rows);
                if (rows != 0)                    
                {
                    //System.out.println("USUARIO ACTUALMENTE VALIDO EN BD");
                    log.info("Usuario actualmente válido en Base de Datos");
                    return true;
                }
                                
         } catch (SQLException ex) {               
                //System.out.println("ACCESO INCORRECTO");
                log.info("Acceso incorrecto");
                return false;
         } 
         log.info("Usuario no valido en la Base de Datos");
         throw new ris2kException("Usuario no válido en la Base de Datos");
         
   }

    public static boolean borrarJugador(String user) throws ris2kException {  
        Statement stmt_consul=null, stmt_inser = null; 
        ResultSet rs = null; 	
        Connection conn= null;
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            }
          conn =
          DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
        }catch(SQLException ex) {
        log.error("Fallo en la conexión a la base de datos");
        throw new ris2kException("Fallo en la conexión a la base de datos");
        }       
        try{
                stmt_inser = conn.createStatement();                 
                String strSQL = ("DELETE FROM user WHERE user='"+ user +"'");
                stmt_inser.executeUpdate(strSQL);
                //System.out.println("SE BORRARON LOS DATOS");
                log.info("Se borraron los datos del usuario: "+user);
                return true;
                		
         } catch (SQLException ex) {    
                log.info("No se pudo borrar de la base de datos");
                throw new ris2kException ("No se pudo borrar de la base de datos");
         }
 }
    public static Jugador getJugador(String id)
    throws ris2kException {
        Jugador jugador = new Jugador();
        //configurar conexion a la base de datos (deberíamos crear un objeto conexion para no repetir esto)
        Statement stmt=null; 
        ResultSet rs = null; 	
        Connection conn= null;
        if (id == null)
            throw new ris2kException("Se introdujo null en vez de un id de un jugador válido. (MySql.getJugador())");
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                log.error(ex.toString());
                ex.printStackTrace();
            }
          conn =
          DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
        }catch(SQLException ex) {
            log.error("Fallo en la conexión a la base de datos");
            throw new ris2kException("Fallo en la conexión a la base de datos");
        }
        try{
            stmt = conn.createStatement();
            String strSQL = null;
            strSQL = "SELECT user, password, email FROM user WHERE user = '" + id + "'";
            rs = stmt.executeQuery(strSQL);
            rs.next();
            jugador.setUser(id);
            
            jugador.setPassword(rs.getString("password"));
            jugador.setEmail(rs.getString("email"));

            //RAMON: OYE BETISMAN, EL FALLO SE ARREGLA INICIALIZANDO EL COLOR COMO NULO, 
            //PERO NO SERÍA MEJOR QUITARLO DE LA CLASE Y PUNTO??
            jugador.setColor(null);

            return jugador;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            log.error("Error al obtener el jugador "+ id + " de la base de datos.");
            throw new ris2kException("Error al obtener el jugador "+ id + " de la base de datos.");
        }
    }
    
}
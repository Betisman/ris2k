package persistence;

import Exceptions.ris2kException;
import javax.servlet.RequestDispatcher;
import model.Jugador;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class Mysql {
    
    public Mysql() {
    }
   

    public static boolean persistirJugador(Jugador jugador) 
    throws ris2kException {  
        Statement stmt_consul=null, stmt_inser = null; 
        ResultSet rs = null; 	
        Connection conn= null;
        String user=jugador.getUser();
        String password=jugador.getPassword();
        String email=jugador.getEmail();
       
        //control de elementos nulos, los cuales no se pueden persistir
        if ((user==null)||(password==null)||(email==null)) throw new ris2kException("Se introdujeron valores nulos");
       
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
            throw new ris2kException("Fallo en la conexión a la base de datos");
        }       
        try{
                stmt_inser = conn.createStatement();                 
                String strSQL = ("INSERT INTO user VALUES ('" + user + "','" + password + "','" + email +"') ");
                stmt_inser.executeUpdate(strSQL);
                System.out.println("SE INSERTARON LOS DATOS");
                return true;
                		
         } catch (SQLException ex) {                
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
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
          conn =
            DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");  
        }catch(SQLException ex) {
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
                    System.out.println("USUARIO ACTUALMENTE VALIDO EN BD");
                    return true;
                }
                                
         } catch (SQLException ex) {               
                System.out.println("ACCESO INCORRECTO");
                return false;
         } 
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
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
          conn =
          DriverManager.getConnection("jdbc:mysql://localhost/ris2k?user=prueba&password=prueba");          
        }catch(SQLException ex) {
        throw new ris2kException("Fallo en la conexión a la base de datos");
        }       
        try{
                stmt_inser = conn.createStatement();                 
                String strSQL = ("DELETE FROM user WHERE user='"+ user +"'");
                stmt_inser.executeUpdate(strSQL);
                System.out.println("SE BORRARON LOS DATOS");
                return true;
                		
         } catch (SQLException ex) {                
                throw new ris2kException ("No se pudo borrar de la base de datos");
         }
 }
}
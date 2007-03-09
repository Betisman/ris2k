package persistence;

import javax.servlet.RequestDispatcher;
import model.Jugador;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;

public class Mysql {
    
    public Mysql() {
    }
   

    public static boolean persistirJugador(Jugador jugador) {  
        Statement stmt_consul=null, stmt_inser = null; 
        ResultSet rs = null; 	
        Connection conn= null;
        String user=jugador.getUser();
        String password=jugador.getPassword();
        String email=jugador.getEmail();
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
        }catch(SQLException ex) {}       
        try{
                stmt_inser = conn.createStatement();                 
                String strSQL = ("INSERT INTO user VALUES ('" + user + "','" + password + "','" + email +"') ");
                stmt_inser.executeUpdate(strSQL);
                System.out.println("SE INSERTARON LOS DATOS");
                return true;
                		
         } catch (SQLException ex) {                
                System.out.println("NO SE INSERTARON LOS DATOS");
                return false;
         }
         }
    public static boolean validarJugador(Jugador jugador) {
        Statement stmt_consul = null, stmt_inser =  null;
        ResultSet rs = null;
        Connection conn= null;
        String user = jugador.getUser();
        String password = jugador.getPassword();
        //String email = jugador.getEmail();
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
        }catch(SQLException ex) {} 
        try{
                
                sql= "SELECT * from user where user='"+user+"' and password='"+password+"'";                
                int rows=0;
                stmt_consul = conn.createStatement();                
                ResultSet rset = stmt_consul.executeQuery(sql);
                while (rset.next()) {rows++;}

                //rs.next();
                //rs = stmt_consul.getResultSet();  
                int resultcount = 0;                
                System.out.println("ROWCOUNT: "+rows);
                if (rows != 0)                    
                {
                    System.out.println("USUARIO ACTUALMENTE VALIDO EN BD");
                    //System.out.println("EL RESULTADO ES: "+rs.toString());
                    return true;
                }
                else
                {
                    System.out.println("USUARIO ACTUALMENTE NO VALIDO EN BD");
                    return false;
                }
         } catch (SQLException ex) {               
                System.out.println("ACCESO INCORRECTO");
                return false;
         }
    }

    public static boolean borrarJugador(String user) {  
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
                String strSQL = ("DELETE FROM user WHERE user='"+ user +"'");
                stmt_inser.executeUpdate(strSQL);
                System.out.println("SE BORRARON LOS DATOS");
                return true;
                		
         } catch (SQLException ex) {                
                System.out.println("NO SE BORRARON LOS DATOS");
                return false;
         }
 }
}
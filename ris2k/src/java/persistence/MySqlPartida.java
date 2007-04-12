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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import model.Jugador;
import model.Partida;

/**
 *
 * @author Carlos
 */
public class MySqlPartida {
    
    /** Creates a new instance of MySqlPartida */
    public MySqlPartida() {
    }
    
    public static String persistirPartida(Partida partida) 
    throws ris2kException {  
        Statement stmt=null; 
        ResultSet rs = null; 	
        Connection conn= null;
        if (partida == null)
            throw new ris2kException("Se introdujo null en vez de una partida válida. (MySqlPartida.java)");
        
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
        if ((nombre==null)||(owner==null)||(jugadores==null))
            throw new ris2kException("Se introdujeron valores nulos");
       
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
                            + "WHERE idpartida = " + idPartida);
                }
                System.out.println("debugging: " + strSQLPartida);
                stmt.executeUpdate(strSQLPartida);
                System.out.println("SE INSERTARON LOS DATOS");                		
         } catch (SQLException ex) {
             if (ex.getMessage().contains("Duplicate entry"))
                throw new ris2kException("Ya existe una partida llamada '" + partida.getNombre()
                    + "' en la Base de Datos");
             else
                 throw new ris2kException("Error en la consulta de inserción de una nueva partida.");
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
                    System.out.println("debugging: " + strSQLPartida);
                    stmt.executeUpdate(strSQLPartida);
                }
                System.out.println("SE INSERTARON LOS DATOS");
                stmt.close();
                return idPartida;                		
         } catch (SQLException ex) {
             if (ex.getMessage().contains("Duplicate entry"))
                throw new ris2kException("Usuario duplicado en la Base de Datos");
             else
                 throw new ris2kException("Error en la consulta de inserción de jugadores en la partida. " + ex.getMessage());
         }    
   }
    
}

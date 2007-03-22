/*
 * Partida.java
 *
 * Created on 15 de marzo de 2007, 10:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import Exceptions.ris2kException;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 *
 * @author Ramon
 */
public class Partida {
    
    private String idPartida = null;
    private String nombre = null; 
    
    private Jugador owner = null;
    private Tablero tablero = null;
    
    private int numJugadores = 0;
    private Vector <Jugador> jugadores= null;
    
    private Turno turno = new Turno();
    
    private Score score = new Score();
    

    
    
    /** Creates a new instance of Partida */
    public Partida() {
        
    }
    /*******************************************************************/
    /**                      otros métodos                            **/
    /*******************************************************************/
    
    public boolean inicializar(String nombre, Jugador owner, Tablero tablero, int maxjugadores)
    throws ris2kException
    {
        try{
        GregorianCalendar now = new GregorianCalendar();
        String id = String.valueOf(now.getTimeInMillis());
        this.setIdPartida("partida"+id);
 
        this.setNombre(nombre);
        this.setOwner(owner);
        this.setTablero(tablero);
        this.setNumJugadores(maxjugadores);
        turno.TurnoInicial(this.getIdPartida(),this.getOwner().getUser());
        
        return true;
        }
        catch (ris2kException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new ris2kException("No se pudo inicializar partida");
        }
    }
    /*******************************************************************/
    /**                      setter y getter                          **/
    /*******************************************************************/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador getOwner() {
        return owner;
    }

    public void setOwner(Jugador owner) {
        this.owner = owner;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public Vector<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Vector<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }
    
    
}

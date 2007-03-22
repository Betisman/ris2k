/*
 * Turno.java
 *
 * Created on 15 de marzo de 2007, 11:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import Exceptions.ris2kException;
import java.util.GregorianCalendar;

/**
 *
 * @author Ramon
 */
public class Turno {
    
    private String idTurno;
    private String idTurnoAnterior;
   
    private String idPartida;
    private String idCreadorPartida;
    
    private int turno;
    private Jugador jugadorActual;
    private EstadoTurno estado;
    
    /** Creates a new instance of Turno */
    
    public Turno() {
    }
    /*******************************************************************/
    /**                      otros métodos                            **/
    /*******************************************************************/
    
    public boolean TurnoInicial(String idPartida, String idCreadorPartida) throws ris2kException
            //TODO: todo, jeje
    {
        try{
        GregorianCalendar now = new GregorianCalendar();
        
        String id = String.valueOf(now.getTimeInMillis());
        this.setIdTurno("turno"+id);
        this.setTurno(0);
        this.setIdPartida(idPartida);
        this.setIdCreadorPartida(idCreadorPartida);
      
        EstadoTurno estado = new EstadoTurno();
        estado.estadoInicial();
        this.setEstado(estado);
        
        this.setJugadorActual(null);
        this.setIdTurnoAnterior(null);
                
        return true; 
        }
        catch (Exception ex)
        {
            throw new ris2kException("No se pudo crear un turno inicial");
        }
        
    }
    /*******************************************************************/
    /**                      setter y getter                          **/
    /*******************************************************************/

    public String getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(String idTurno) {
        this.idTurno = idTurno;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public String getIdTurnoAnterior() {
        return idTurnoAnterior;
    }

    public void setIdTurnoAnterior(String idTurnoAnterior) {
        this.idTurnoAnterior = idTurnoAnterior;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getIdCreadorPartida() {
        return idCreadorPartida;
    }

    public void setIdCreadorPartida(String idCreadorPartida) {
        this.idCreadorPartida = idCreadorPartida;
    }

}

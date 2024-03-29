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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Ramon
 */
public class Partida {
    
    private String idPartida = null;
    private String nombre = null;  
    private Jugador owner = new Jugador();
    private Tablero tablero = new Tablero();
    private int numJugadores = 0;
    private List <Jugador> jugadores= new ArrayList();
    private List <Jugada> jugadas = new ArrayList();
    
    private Turno turno = new Turno();
    private Score score = new Score();
    
    private String estado = null;
 
    
    /** Creates a new instance of Partida */
    public Partida() {
        
    }
    /*******************************************************************/
    /**                      otros m�todos                            **/
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
        catch (ris2kException ex){
            throw ex;
        }
        catch (Exception ex){
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
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

    public List<Jugada> getJugadas() {
        return jugadas;
    }

    public void setJugadas(Vector<Jugada> jugadas) {
        this.jugadas = jugadas;
    }
    
    public void repartirTerritorios(){
    try{
        List<Territorio> territorios = tablero.getTodosTerritorios();
        int i = 0;
        while(territorios.size()>0){
            for(Jugador j : jugadores){
                if (territorios.size()>0){
                 int pos = (int)(Math.round(Math.random()*(territorios.size()-1)));
                    Territorio t = territorios.remove(pos);
                    tablero.getTerritorio(t.getId()).setOwner(j);
                    tablero.getTerritorio(t.getId()).setNumEjercitos(1);
                    i++; System.out.println(i + ". Territorio " + t.getNombre() + " asignado a " + j.getUser() + ".");
                }
            }
        }
    }catch(Exception ex){
        System.out.println("EXCEPCI�N: " + ex.getMessage());
    }
    } 
    
    public boolean estaJugador(Jugador jugador){
        boolean esta = false;
        for(Jugador j : jugadores){
            if (j.getUser().equals(jugador.getUser()))
                esta = true;
        }
        return esta;
    }
    
    public String getColorJugador(Jugador jugador)
    throws ris2kException{
        String color = null;
        for(Jugador j : jugadores){
            if (j.getUser().equals(jugador.getUser()))
                color = j.getColor();
        }
        if (color == null)
            throw new ris2kException("No se ha podido recoger el color del jugador " + jugador.getUser());
        return color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

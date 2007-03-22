/*
 * Juego.java
 *
 * Created on 22 de marzo de 2007, 17:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import java.util.List;

/**
 *
 * @author Carlos
 */
public class Juego {
    private List<Partida> partidas;
    
    /** Creates a new instance of Juego */
    public Juego() {
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
    
    public void anadirPartida(Partida p){
        this.partidas.add(p);
    }
    
    
}

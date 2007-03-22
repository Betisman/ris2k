/*
 * Jugada.java
 *
 * Created on 22 de marzo de 2007, 21:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

/**
 *
 * @author CEU
 */
public class Jugada {
    
    private Jugador jugadorAtacante;
    private Jugador jugadorDefensor;
    private Territorio territorioAtacante;
    private Territorio territorioDefensor;
    private int dados;
    
    /** Creates a new instance of Jugada */
    public Jugada() {
    }

    public Jugador getJugadorAtacante() {
        return jugadorAtacante;
    }

    public void setJugadorAtacante(Jugador jugadorAtacante) {
        this.jugadorAtacante = jugadorAtacante;
    }

    public Jugador getJugadorDefensor() {
        return jugadorDefensor;
    }

    public void setJugadorDefensor(Jugador jugadorDefensor) {
        this.jugadorDefensor = jugadorDefensor;
    }

    public Territorio getTerritorioAtacante() {
        return territorioAtacante;
    }

    public void setTerritorioAtacante(Territorio territorioAtacante) {
        this.territorioAtacante = territorioAtacante;
    }

    public Territorio getTerritorioDefensor() {
        return territorioDefensor;
    }

    public void setTerritorioDefensor(Territorio territorioDefensor) {
        this.territorioDefensor = territorioDefensor;
    }

    public int getDados() {
        return dados;
    }

    public void setDados(int dados) {
        this.dados = dados;
    }
    
}

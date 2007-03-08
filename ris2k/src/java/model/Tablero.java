/*
 * Tablero.java
 *
 * Created on 7 de marzo de 2007, 23:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import java.util.Collection;

/**
 *
 * @author Carlos
 */
public class Tablero {
    private String mapa;
    private Collection<Continente> continentes;
    /** Creates a new instance of Tablero */
    public Tablero() {
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public Collection<Continente> getContinentes() {
        return continentes;
    }

    public void setContinentes(Collection<Continente> continentes) {
        this.continentes = continentes;
    }
    
    public boolean mostrar(){
        if (mapa == null){
            return true;
        }else return false;
    }
}

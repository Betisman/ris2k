/*
 * Tablero.java
 *
 * Created on 7 de marzo de 2007, 23:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Carlos
 */
public class Tablero {
    private String mapa;
    /** Creates a new instance of Tablero */
    public Tablero() {
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }
    
    public boolean mostrar(){
        if (mapa == null){
            return true;
        }else return false;
    }
}

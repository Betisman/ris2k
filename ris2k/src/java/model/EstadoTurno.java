/*
 * EstadoTurno.java
 *
 * Created on 22 de marzo de 2007, 11:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Ramon
 */
public class EstadoTurno {
    private String estado;
        
    /**
     * Creates a new instance of EstadoTurno
     */
    public EstadoTurno() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void estadoInicial(){
        this.setEstado("ESPERA");
    }
    
    public void estadoSiguiente(){
        if (this.getEstado()== "ESPERA")
            this.setEstado("REFUERZO");
        if (this.getEstado()== "REFUERZO")
            this.setEstado("COMBATE");
        if (this.getEstado()== "COMBATE")
            this.setEstado("REPOBLACION");
        if (this.getEstado()== "REPOBLACION")
            this.setEstado("ESPERA");
    }
    
}

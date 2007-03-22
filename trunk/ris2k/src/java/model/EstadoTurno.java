/*
 * EstadoTurno.java
 *
 * Created on 22 de marzo de 2007, 11:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import Exceptions.ris2kException;

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
    
    public EstadoTurno estadoSiguiente()  throws ris2kException{
       
        EstadoTurno estado=new EstadoTurno();
        try
        {
        if (this.getEstado()== "ESPERA"){
            estado.setEstado("REFUERZO");
            return estado;}
        else if (this.getEstado()== "REFUERZO"){
            estado.setEstado("COMBATE");
            return estado;}
        else if (this.getEstado()== "COMBATE"){
            estado.setEstado("REPOBLACION");
            return estado;}
        else if (this.getEstado()== "REPOBLACION"){
            estado.setEstado("ESPERA");
            return estado;}
        else throw new ris2kException("El estado no es válido");
        }
        catch (ris2kException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new ris2kException("Error en el control de estados del turno");
        }
        
    }
    
}

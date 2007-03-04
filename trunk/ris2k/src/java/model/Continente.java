/*
 * Continente.java
 *
 * Created on 4 de marzo de 2007, 19:03
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
public class Continente {
    private String id;
    private String nombre;
    private int numRefuerzos;
    private Collection<Territorio> territorios;
    
    /** Creates a new instance of Continente */
    public Continente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumRefuerzos() {
        return numRefuerzos;
    }

    public void setNumRefuerzos(int numRefuerzos) {
        this.numRefuerzos = numRefuerzos;
    }

    public Collection<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(Collection<Territorio> territorios) {
        this.territorios = territorios;
    }
    
}

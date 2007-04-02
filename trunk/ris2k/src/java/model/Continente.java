/*
 * Continente.java
 *
 * Created on 4 de marzo de 2007, 19:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class Continente {
    private String id;
    private String nombre;
    private int numRefuerzos;
    private List<Territorio> territorios = new ArrayList();
    
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

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<Territorio> territorios) {
        this.territorios = territorios;
    }
    
    public String toString(){
        String str = null;
        str = "id: " + this.getId() + "\n"
                + "continente: " + this.getNombre() + "\n"
                + "numRefuerzos: " + String.valueOf(this.getNumRefuerzos()) + "\n"
                + "territorios:\n";
        for(Territorio t : this.getTerritorios())
            str = t.toString();
        return str;
    }
    
    public int numTerritorios(){
        return this.getTerritorios().size();
    }
    
}

/*
 * Territorio.java
 *
 * Created on 2 de marzo de 2007, 1:11
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
public class Territorio {
    private String id;
    private String nombre;
    private Collection<Territorio> conexiones;
    
    /** Creates a new instance of Territorio */
    public Territorio() {
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

    public Collection<Territorio> getConexiones() {
        return conexiones;
    }

    public void setConexiones(Collection<Territorio> conexiones) {
        this.conexiones = conexiones;
    }
    
}

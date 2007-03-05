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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Carlos
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "limita"
})
@XmlRootElement(name="customer")
public class Territorio {
    @XmlAttribute(name = "id", required = true)
    private String id;
    @XmlAttribute(required = true)
    private String nombre;
    @XmlTransient
    private Jugador owner;
    @XmlTransient
    private int numEjercitos;
    @XmlTransient
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

    public Jugador getOwner() {
        return owner;
    }

    public void setOwner(Jugador owner) {
        this.owner = owner;
    }

    public int getNumEjercitos() {
        return numEjercitos;
    }

    public void setNumEjercitos(int numEjercitos) {
        this.numEjercitos = numEjercitos;
    }
    
    public String toString() {
        return "id: " + getId() +
                "\nnombre: " + getNombre() +
                "\ndueño: " + getOwner() +
                "\nejercitos: " + getNumEjercitos();
    }
}

/*
 * Jugador.java
 *
 * Created on 28 de febrero de 2007, 15:22
 */

package model;

import java.util.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
import java.util.ResourceBundle;


public class Jugador {
    private String user = null;
    private String password = null;
    private String email = null; 

    
    /** Creates a new instance of Friend */
    public Jugador() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
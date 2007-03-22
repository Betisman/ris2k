/*
 * accesoServlet.java
 *
 * Created on 4 de marzo de 2007, 12:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;



import Exceptions.ris2kException;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import persistence.Mysql;
import model.Jugador;

public class accesoServlet extends MiServlet {   
    String error1=null; //Defino este string para saber que tipo de error de validación se produce.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Jugador jugador = new Jugador(); 
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        /*int contador = 0;
        String errorBD = null;
        String errorUser1 = null;
        String errorUser2 = null;
        String Password1 = null;
        String Password2 = null;
        
        String user = request.getParameter("user");       
        request.getSession().setAttribute("errorUser1","");
        if(user.length()>128 || !user.matches("[a-zA-Z0-9]+")){ 
         contador++;
         request.getSession().setAttribute("errorUser1","¡ERROR! Nombre de usuario incorrecto, sólo puede contener letras y dígitos");
         System.out.println("FALLO: "+user);            
        }
        
        request.getSession().setAttribute("errorUser2","");
        if(user.matches("puta")||user.matches("cabron[a-zA-Z]*")||user.matches("mierda")){ 
         contador++;
         request.getSession().setAttribute("errorUser2","¡ERROR! Ese nombre de usuario puede resultar ofensivo, no se pudo registrar con él");
         System.out.println("FALLO: "+user);            
        }
        
        
        String password = request.getParameter("password");
    
        request.getSession().setAttribute("errorPassword1","");
        if (password.length()<6){
            contador++;
            request.getSession().setAttribute("errorPassword1","¡ERROR! La contraseña es demasiado corta (mínimo 6 caracteres)");
            System.out.println("FALLO: "+password);
        }
        
        request.getSession().setAttribute("errorPassword2","");
        if (!password.matches("[a-zA-Z0-9]+")){
            contador++;
            request.getSession().setAttribute("errorPassword2","¡ERROR! La contraseña sólo puede contener letras y dígitos");
            System.out.println("FALLO: "+password);
        }
       
        request.getSession().setAttribute("errorBD","");
        if (contador == 0){*/
            jugador.setUser(user);
            jugador.setPassword(password);
            try {
                Mysql.validarJugador(jugador);
                request.getSession().setAttribute("jugador","Bienvenid@, "+user.toUpperCase());
                /*Al ser un jugador válido, lo metemos en el objeto session*/
                request.getSession().setAttribute("usuario", jugador);
                    /***********************************************************/
                 gotoJSPPage(menuForm,request,response);
                
            } catch (ris2kException ex) {
                request.getSession().setAttribute("errorRis2k",ex.getMessage());
                gotoJSPPage(errorForm,request,response);
            }
           request.getSession().setAttribute("errorRis2k","Error Desconocido");
           gotoJSPPage(errorForm,request,response);
            
        
    }  
  
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
   
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
  
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}

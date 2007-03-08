/*
 * accesoServlet.java
 *
 * Created on 4 de marzo de 2007, 12:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;



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
        //String email = request.getParameter("email");
    
        jugador.setUser(user);
        jugador.setPassword(password);
        //jugador.setEmail(email);   
    
        if(Mysql.validarJugador(jugador)==true)
        {
           gotoJSPPage(exitoAltaForm,request,response);
           //Mysql.persistirJugador(jugador);
        }
        else
        {         
           gotoJSPPage(errorAltaForm,request,response);
        }
    }  
    // <editor-fold defaultstate=3D"collapsed" desc=3D"HttpServlet =methods. Click on the + sign on the left to edit the code.">
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
    // </editor-fold>
}

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
    throws ServletException, IOException 
    {
        Jugador jugador = new Jugador(); 
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        jugador.setUser(user);
        jugador.setPassword(password);
        try {
            Mysql.validarJugador(jugador);
            request.getSession().setAttribute("jugador","Bienvenid@, "+user.toUpperCase());
            /*Al ser un jugador válido, lo metemos en el objeto session*/
            request.getSession().setAttribute("usuario", jugador);
                /***********************************************************/
            gotoJSPPage(menuForm,request,response);
            return;

        } catch (ris2kException ex) {
            request.getSession().setAttribute("errorRis2k",ex.getMessage());
            gotoJSPPage(errorForm,request,response);
        }catch (Exception ex){
            request.getSession().setAttribute("errorRis2k","Error Desconocido");
            gotoJSPPage(errorForm,request,response); 
        }

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

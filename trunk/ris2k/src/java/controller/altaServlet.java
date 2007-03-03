

package controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import persistence.Mysql;
import model.Jugador;

/**
 *
 * @author Iñigo
 * @version
 */
public class altaServlet extends MiServlet {    
    
    String error1=null; //Defino este string para saber que tipo de error de validación se produce.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Jugador jugador = new Jugador();               
        int contador=0;
        //modificado para soportar validaciones        
        String user = request.getParameter("user");        
        if(user.length()>128 || !user.matches("[a-zA-Z0-9]+")){ 
         //Compruebo que el nombre no tenga más de 128 caracteres y que sólo sean letras.   
         error1="NOMBRE DE USUARIO INCORRECTO";
         contador++;
         System.out.println("FALLO: "+user);            
        }
        
        //modificado para soportar validaciones
        String password = request.getParameter("password");
        if(password.length()<6 || !password.matches("[a-zA-Z0-9]+")){
          //El teléfono sólo debe contener dígitos.  
          error1="CONTRASEÑA INCORRECTA";
          contador++;
          System.out.println("FALLO: "+password);                  
        }           
       
        String email = request.getParameter("email");
              
        jugador.setUser(user);
        jugador.setPassword(password);
        jugador.setEmail(email);      
        
        if(contador==0&Mysql.persistirJugador(jugador)==true){
           gotoJSPPage(exitoAltaForm,request,response); 
           //Mysql.persistirJugador(jugador);
        } else {            
           gotoJSPPage(errorAltaForm,request,response);
            
        }
        
       
    }    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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



package controller;

import Exceptions.ris2kException;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import persistence.MysqlJugador;
import model.Jugador;
import mail.Correo;



public class altaServlet extends MiServlet {    
    public altaServlet(){
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        Jugador jugador = new Jugador();               
        int contador=0;
        string errorUser1 = null;
        string errorUser2 = null;
        string errorPassword1 = null;
        string errorPassword2 = null;
        string errorMail = null;
            
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
         request.getSession().setAttribute("errorUser2","¡ERROR! Ese nombre de usuario puede resultar ofensivo, por favor cámbielo");
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
       
        String email = request.getParameter("email");
        
        request.getSession().setAttribute("errorMail","");
        if (!email.matches("[a-zA-Z0-9_]+@[a-zA-Z0-9_]+[.][a-zA-Z]+")){
            contador++;
            request.getSession().setAttribute("errorMail","¡ERROR! Escriba una direccion de correo válida");
            System.out.println("FALLO: "+email);
        }
             
        request.getSession().setAttribute("errorBD","");
        if (contador == 0){
            jugador.setUser(user);
            jugador.setPassword(password);
            jugador.setEmail(email);
            try {
                MysqlJugador.persistirJugador(jugador);
            } catch (ris2kException ex) {
                
                request.getSession().setAttribute("errorRis2k",ex.getMessage());
                gotoJSPPage(errorAltaForm,request,response);
            }
                Correo.enviarCorreo(jugador);
                request.getSession().setAttribute("jugador","Bienvenido, "+user.toUpperCase());
                gotoJSPPage(menuForm,request,response);
            
                
            
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

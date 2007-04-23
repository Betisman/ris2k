/*
 * AnadirJugadorAPartida.java
 *
 * Created on 15 de abril de 2007, 12:35
 */

package controller;

import Exceptions.ris2kException;
import java.io.*;
import java.net.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Jugador;
import model.Partida;
import persistence.MySqlPartida;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Carlos
 * @version
 */
public class AnadirJugadorAPartida extends MiServlet {
    static Logger log = Logger.getLogger(AnadirJugadorAPartida.class);
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //recuperamos el id de la partida que va implícito en el request de la petición http
        String idPartida = request.getParameter("partida");
        try {
            //System.out.println("anadirJugadorAPartida");
            log.info("anadirJugadorAPartida");
            Jugador jugadorActual = (Jugador)request.getSession().getAttribute("usuario");
            //System.out.println(jugadorActual.getUser() + " (" + jugadorActual.getPassword() + ") - " + jugadorActual.getEmail());
            log.info(jugadorActual.getUser() + " (" + jugadorActual.getPassword() + ") - " + jugadorActual.getEmail());
            Partida partida = MySqlPartida.getPartida(idPartida);
            if (partida.estaJugador(jugadorActual)){
                System.out.println("La partida " + partida.getNombre() + " ya contiene al jugador " + jugadorActual.getUser());
            }else{
                partida.getJugadores().add(jugadorActual);
                //System.out.println("Añadimos a la partida " + partida.getNombre() + " el jugador " + jugadorActual.getUser());
                log.info("Añadimos a la partida " + partida.getNombre() + " el jugador " + jugadorActual.getUser());
                MySqlPartida.persistirPartida(partida);
            }                
            
            request.setAttribute("partida", partida);
            gotoJSPPage("/view/esperaPartida.jsp", request, response);
        }catch (ris2kException ex) {
            request.getSession().setAttribute("errorRis2k",ex.getMessage());
            gotoJSPPage(errorForm,request,response);
        }catch (Exception ex){
            request.getSession().setAttribute("errorRis2k","Error Desconocido");
            ex.printStackTrace();
            gotoJSPPage(errorForm,request,response); 
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

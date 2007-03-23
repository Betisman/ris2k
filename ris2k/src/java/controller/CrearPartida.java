/*
 * CrearPartida.java
 *
 * Created on 20 de marzo de 2007, 16:10
 */

package controller;

import Exceptions.ris2kException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Jugador;
import model.Partida;
import model.Tablero;
import persistence.MySqlPartida;

/**
 *
 * @author Carlos
 * @version
 */
public class CrearPartida extends MiServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            Jugador creador = new Jugador();
            creador = (Jugador)request.getSession().getAttribute("usuario");
            
            Vector<Jugador> jugadores = new Vector();
            jugadores.add(creador);
            
            Partida partida = new Partida();
            /*ahora mismo tiramos con esto, pero hay que recordar que tenemos que cambia la
             *bd para adaptar las tablas a valores autonuméricos*/
            Tablero t = new Tablero();
            partida.inicializar("", creador, t, 0); //para ponerle el idPartida
            /******************************************************/
            partida.setJugadores(jugadores);
            partida.setNombre(request.getParameter("nombrePartida"));
            partida.setNumJugadores(Integer.valueOf(request.getParameter("numJugadores")));
            partida.setOwner(creador);
//        partida.setScore();
//        partida.setTablero();
//        partida.setTurno();
            /****************/
            System.out.println("partida = " + partida.getNombre());
            List<Partida> partidas = new ArrayList();
            partidas.add(partida);
            
            MySqlPartida.persistirPartida(partida);
            
            Collection partidasC = (Collection)partidas;
            request.getSession().setAttribute("partidas", partidasC);
            /****************/
//        request.getSession().setAttribute("partida", partida);
            gotoJSPPage("/view/partidas.jsp", request, response);
//        gotoJSPPage(partidas, request, response);
        } catch (ris2kException ex) {
            request.getSession().setAttribute("errorRis2k",ex.getMessage());
            gotoJSPPage(errorForm,request,response);
        }catch (Exception ex){
            request.getSession().setAttribute("errorRis2k","Error Desconocido");
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

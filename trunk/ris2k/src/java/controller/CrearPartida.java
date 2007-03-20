/*
 * CrearPartida.java
 *
 * Created on 20 de marzo de 2007, 16:10
 */

package controller;

import java.io.*;
import java.net.*;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Jugador;
import model.Partida;

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
/*        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 */
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CrearPartida</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet CrearPartida at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
//        out.close();
        
        Jugador creador = new Jugador();
        creador = (Jugador)request.getSession().getAttribute("usuario");
        
        Vector<Jugador> jugadores = new Vector();
        jugadores.add(creador);
        
        Partida partida = new Partida();
        partida.setJugadores(jugadores);
        partida.setNombre(request.getParameter("nombrePartida"));
        partida.setNumJugadores(Integer.valueOf(request.getParameter("numJugadores")));
        partida.setOwner(creador);
//        partida.setScore();
//        partida.setTablero();
//        partida.setTurno();
        
        request.getSession().setAttribute("partida", partida);
        
        request.getSession().setAttribute("nombrePartida", partida.getNombre());
        request.getSession().setAttribute("owner", partida.getOwner().getUser());
        
        
        gotoJSPPage(partidas, request, response);
//        SafeRedirect(response, partidas+"?nombrePartida="+partida.getNombre());
        
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

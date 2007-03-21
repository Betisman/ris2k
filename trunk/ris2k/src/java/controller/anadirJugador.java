/*
 * anadirJugador.java
 *
 * Created on 21 de marzo de 2007, 15:38
 */

package controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Jugador;
import model.Partida;

/**
 *
 * @author Administrador
 * @version
 */
public class anadirJugador extends MiServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet anadirJugador</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet anadirJugador at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
        //out.close();
        Jugador jugador = new Jugador();
        jugador = (Jugador)request.getSession().getAttribute("usuario");
        Partida partida = new Partida();
        partida.getNombre();
        gotoJSPPage(partidasActivas, request, response);
        
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

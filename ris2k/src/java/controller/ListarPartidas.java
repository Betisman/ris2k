/*
 * ListarPartidas.java
 *
 * Created on 22 de marzo de 2007, 17:36
 */

package controller;

import Exceptions.ris2kException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Jugador;
import model.Partida;
import model.Tablero;

/**
 *
 * @author Carlos
 * @version
 */
public class ListarPartidas extends MiServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Partida> partidas = new ArrayList();
//        partidas.getFromPersistencia();
/*        Partida p1 = new Partida();
        Partida p2 = new Partida();
        Tablero t = new Tablero();
        try {
            p1.inicializar("Partida1", (Jugador) request.getSession().getAttribute("usuario"), t, 2);
            p2.inicializar("Partida2", (Jugador) request.getSession().getAttribute("usuario"), t, 4);
        } catch (ris2kException ex) {
            ex.printStackTrace();
        }
        System.out.println("partida1 = " + p1.getNombre());
        partidas.add(p1);
        partidas.add(p2);
        
        request.getSession().setAttribute("partidas", partidas);
        System.out.println("en request: " + partidas.iterator().next().getNombre());
        System.out.println("en request: " + partidas.iterator().next().getNombre());
  */
        System.out.println("partidas:");
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        partidas = (List)context.getAttribute("partidasActivas");
        for(Partida p : partidas)
            System.out.println("\t"+p.getNombre());
        
        gotoJSPPage(listaPartidas, request, response);
        
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

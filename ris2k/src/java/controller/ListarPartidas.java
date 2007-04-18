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
import persistence.*;

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
        List<Partida> partidasAbiertas;
        try {
            partidasAbiertas = MySqlPartida.getPartidasAbiertas();
            request.setAttribute("partidas", partidasAbiertas);
        } catch (ris2kException ex) {
            ex.printStackTrace();
        }
/*        System.out.println("partidas:");
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        partidas = (List)context.getAttribute("partidasActivas");
        System.out.println("LISTAR PARTIDAS, partidasActivas.size() = " + String.valueOf(partidas.size()));
        for(Partida p : partidas){
            System.out.println("\t"+p.getNombre() + " by " + p.getOwner().getUser());
            for(Jugador j : p.getJugadores())
                System.out.println("\t\t"+j.getUser());
        }
 */
//        request.setAttribute("partidasActivas", partidas);
        try{
        gotoJSPPage("/view/partidas.jsp", request, response);        
        }catch(Exception ex){
            System.out.println("lo puse yo: "+ex.getMessage());ex.printStackTrace();  
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

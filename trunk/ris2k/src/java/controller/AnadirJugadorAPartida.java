/*
 * AnadirJugadorAPartida.java
 *
 * Created on 15 de abril de 2007, 12:35
 */

package controller;

import Exceptions.ris2kException;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Jugador;
import model.Partida;
import persistence.MySqlPartida;

/**
 *
 * @author Carlos
 * @version
 */
public class AnadirJugadorAPartida extends MiServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String idPartida = request.getParameter("partida");
        try {
            System.out.println("anadirJugadorAPartida");
            Partida partida = MySqlPartida.getPartida(idPartida);
    for(Jugador j : partida.getJugadores()){ System.out.println(j.toString());}
            partida.getJugadores().add((Jugador)request.getSession().getAttribute("usuario"));
    for(Jugador j : partida.getJugadores()){ System.out.println(j.toString());}
            MySqlPartida.persistirPartida(partida);
            System.out.println(partida.toString());
//            gotoJSPPage("/view/");
        }catch (ris2kException ex) {
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

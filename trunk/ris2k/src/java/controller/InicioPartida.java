/*
 * InicioPartida.java
 *
 * Created on 23 de abril de 2007, 1:14
 */

package controller;

import Exceptions.ris2kException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Jugador;
import model.Partida;
import model.Tablero;
import model.Territorio;
import org.w3c.dom.Document;
import svgTablero.SVGTablero;

/**
 *
 * @author Carlos
 * @version
 */
public class InicioPartida extends MiServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("InicioPartida Servlet");
        Partida partida = new Partida();
        partida = (Partida)request.getSession().getAttribute("partida");
        request.getSession().setAttribute("idPartida", partida.getIdPartida());
        try {
                Tablero tablero = new Tablero();
                tablero.cargarTerritorios("C:/universidad/Quinto/IS2/Ris2k/ris2k/web/test/newYork.xml");
                partida.setTablero(tablero);

                partida.repartirTerritorios();
                
                File f = new File("C:/universidad/Quinto/IS2/Ris2k/ris2k/web/images/Zonas1024bisAjax.svg");
                SVGTablero svg = new SVGTablero();
                Document document = null;
                document = svg.parsearFichero(f);
                List<Territorio> territorios = partida.getTablero().getTodosTerritorios();
                svg.situarTodosEjercitos(document, territorios);
                svg.stringToSvgFile(svg.serializar(document), "C:/universidad/Quinto/IS2/Ris2k/ris2k/web/images/output.svg");
                request.getSession().setAttribute("partidas"+partida.getIdPartida(), partida);
                request.getSession().setAttribute("partida", "partidas"+partida.getIdPartida());
                
                /*Preparación del tablero - originalmente en tableroMenuAjax.jsp */
                File f2 = new File("C:/universidad/Quinto/IS2/Ris2k/ris2k/web/images/output.svg");
                document = svg.parsearFichero(f2);
                Jugador j = (Jugador)request.getSession().getAttribute("usuario");
                for(Territorio c : partida.getTablero().getTodosTerritorios()){
                    if (c.getOwner().getUser().equals(j.getUser())){
                        document = svg.setMouseOver(document, c.getId());
                        document = svg.setSumarEjercito(document, c.getId());
                    }else{
                        document = svg.removeMouseOver(document, c.getId());
                        document = svg.removeSumarEjercito(document, c.getId());
                    }
                }
                svg.stringToSvgFile(svg.serializar(document), "C:/universidad/Quinto/IS2/Ris2k/ris2k/web/images/output.svg");
            } catch (ris2kException ex) {
                request.getSession().setAttribute("errorRis2k",ex.getMessage());
                gotoJSPPage(errorAltaForm,request,response);
            }
            gotoJSPPage("/view/tableroMenuAjax.jsp", request, response);
 //       }
        
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

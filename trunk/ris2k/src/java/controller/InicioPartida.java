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
        partida = (Partida)request.getAttribute("partida");
        request.setAttribute("idPartida", partida.getIdPartida());
        if (partida.getEstado().equals("jugando")){
            gotoJSPPage("/view/tableroMenu.jsp", request, response);
        }else{
            try {
                partida.setEstado("jugando");
                partida.repartirTerritorios();

                File f = new File("/images/Zonas1024bisAjax.svg");
                SVGTablero svg = new SVGTablero();
                Document document = null;
                document = svg.parsearFichero(f);
                svg.situarTodosEjercitos(document, partida.getTablero().getTodosTerritorios());
                svg.stringToSvgFile(svg.serializar(document), "/images/output.svg");
                /*********************************esto no habría que hacerlo, pero por ahora, tiramos así*/
                Vector<String> colores = new Vector();
                colores.add("#ff00ff");colores.add("#ff55ff");colores.add("#ff0000");
                colores.add("#ff666");colores.add("#6600ff");colores.add("#6688ff");
                List<Jugador> jugadoresColoreados = new ArrayList();
                for(Jugador j : partida.getJugadores()){
                    int pos = (int)(Math.round(Math.random()*(colores.size()-1)));
                    j.setColor(colores.remove(pos));
                    jugadoresColoreados.add(j);
                }
                partida.setJugadores(jugadoresColoreados);
                /*********************************/

                ServletConfig config = getServletConfig();
                ServletContext context = config.getServletContext();
                context.setAttribute("partidas"+partida.getIdPartida(), partida);
            } catch (ris2kException ex) {
                request.getSession().setAttribute("errorRis2k",ex.getMessage());
                gotoJSPPage(errorAltaForm,request,response);
            }
            gotoJSPPage("/view/tableroMenu.jsp", request, response);
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

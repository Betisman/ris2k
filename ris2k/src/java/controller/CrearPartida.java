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
            /* Recogemos los parámetros del formulario */
            String nombrePartida = request.getParameter("nombrePartida");
            int numJugadores = Integer.valueOf(request.getParameter("numJugadores"));
            Tablero tablero = new Tablero();
            //tablero.cargarTablero(request.getParameter("mapa"));
            
            /* Creamos partida vacía nueva y la vamos rellenando */
            Partida partida = new Partida();
            /* Establecemos el creador de la partida */
            partida.setOwner((Jugador)request.getSession().getAttribute("usuario"));
            /* Añadimos al creador de la partida como jugador de la misma */
            partida.getJugadores().add(partida.getOwner());
            
            /*ahora mismo tiramos con esto, pero hay que recordar que tenemos que cambia la
             *bd para adaptar las tablas a valores autonuméricos*/
            tablero.setMapa("/web/test/newYork.xml"); //hay que cambiarlo para recogerlo como parámetro
            tablero.cargarTerritorios(tablero.getMapa());
            partida.setTablero(tablero);
//            partida.inicializar("", creador, t, 0); //para ponerle el idPartida
            /******************************************************/
            partida.setNombre(nombrePartida);
            partida.setNumJugadores(numJugadores);
//        partida.setScore();
//        partida.setTablero();
//        partida.setTurno();
            /****************/
            System.out.println("partida = " + partida.getNombre());
            System.out.println("idPartida = " + partida.getIdPartida());
            System.out.println("numJugadores = " + String.valueOf(partida.getNumJugadores()));
            
            //Persistimos la partida y recogemos la id que se le da en la BD
            partida.setIdPartida(MySqlPartida.persistirPartida(partida));
            /****************/
//        request.getSession().setAttribute("partida", partida);
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        List<Partida> partidasActivas = (List)context.getAttribute("partidasActivas");
        partidasActivas.add(partida);
        context.setAttribute("partidasActivas", partidasActivas);
        
        List<Partida> test = (List)context.getAttribute("partidasActivas");
        System.out.println("CREAR PARTIDA, partidasActivas.size() = " + String.valueOf(test.size()));
        
        request.setAttribute("partida", partida);
            gotoJSPPage("/view/esperaPartida.jsp", request, response);
//        gotoJSPPage(partidas, request, response);
        } catch (ris2kException ex) {
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

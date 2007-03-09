/*
 * TerritorioAtacante.java
 *
 * Created on 9 de marzo de 2007, 13:20
 */

package controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Tablero;

/**
 *
 * @author Carlos
 * @version
 */
public class TerritorioAtacante extends MiServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String territorio = request.getParameter("territorio");
        System.out.println("Territorio atacante: " + territorio);
        Tablero tablero = new Tablero();
//        tablero.setMapa("C:/universidad/Quinto/IS2/ProyectoRis2k/ris2k/ris2k/web/test/dibujo.xml");
        
        tablero.setMapa(request.getParameter("pathTablero"));
        
        request.getSession().setAttribute("atacante", territorio);
        
        File f = new File(tablero.getMapa());
        //System.out.println("RUTA ABSOLUTA: "+f.);
        System.out.println("en TerritorioAtacante probando lo del mapa de los huevos");
            if (f.exists()){
                System.out.println("existe el fichero del mapa... " + f.getPath());
            }else{
                System.out.println("ouch!! no existe el fichero del mapa... " + f.getPath());
            }
        
        
        
        tablero.cambiarLinksTerritorios("TerritorioDefensor");
        
        gotoJSPPage(territorioDefensor,request,response);
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

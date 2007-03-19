/*
 * TerritorioAtacante.java
 *
 * Created on 9 de marzo de 2007, 13:20
 */

package controller;

import java.io.*;
import java.net.*;
import java.util.GregorianCalendar;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Tablero;
import org.w3c.dom.Document;
import svgTablero.SVGTablero;

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
        GregorianCalendar now = new GregorianCalendar();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>TerritorioAtacante @ " + now.getTime().toString());
        
        System.out.println("POST: desde "+request.getRemoteAddr()+" "
            + request.getHeader("X-Forwarded-For")+" "
            + request.getHeader("Forwarded")+" "
            + request.getHeader("Via")+" "
            + request.getHeader("user-agent")+" "
            + request.getHeader("Client-ip"));
        Tablero tablero = new Tablero();
        String rutaCarpetaTablero = request.getSession().getServletContext().getRealPath("/WEB-INF");
        tablero.setMapa(rutaCarpetaTablero + "/tableros/newYork/newYorkMap.xml");
        File f = new File(tablero.getMapa());
        SVGTablero svg = new SVGTablero();
        Document document = svg.parsearFichero(f);
         if (document == null)
                System.out.println("DOCUMENT NULL en TerritorioDefensor tras parsearFichero");
            else
                System.out.println("DOCUMENT ¡¡NOT!! NULL TerritorioDefensor tras parsearFichero");
        document = svg.cambiarLinks(document, "TerritorioDefensor");
//        document = svg.setRutaFondo(document, rutaCarpetaTablero.replaceAll("\\\\", "/") + "/tableros/newYork/newYorkBg.jpg");
        String str;
        str = svg.serializar(document);
        String ruta = "no hace falta mientras probamos";
        svg.stringToSvgFile(str, ruta);
        
        /*******************************************/
        //gotoJSPPage("/view/tablero.jsp",request,response);
        /*******************************************/
        request.getSession().setAttribute("strSvg", str);
        
             
        response.setContentType("image/svg+xml");
        PrintWriter out = response.getWriter();
        out.print(str);
        out.close();
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

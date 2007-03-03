/*
 * FrontController.java
 *
 * Created on 23 de noviembre de 2006, 21:51
 */

package controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author Iñigo
 * @version
 */
public class FrontController extends MiServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String form = request.getParameter("form");
        String persistenceMechanism = (String) getServletContext().getAttribute("persistenceMechanism");
        //if no form is specified or there is no active persistence mechanism
        if (form == null || (persistenceMechanism != null && persistenceMechanism.equals("none"))){
            gotoJSPPage(altaForm,request, response) ;
        } else if(form.equals("errorAltaForm")){
            gotoJSPPage(errorAltaForm,request,response);
        } else if(form.equals("exitoAltaForm")){
            gotoJSPPage(exitoAltaForm,request,response);        
        } else {
            gotoJSPPage(mainForm,request, response);
        }
        /* TODO output your page here*/
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet FrontController</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet FrontController at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
        
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

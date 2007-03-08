/*
 * NewClass.java
 *
 * Created on 28 de febrero de 2007, 18:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MiServlet extends HttpServlet {
    
    /** Creates a new instance of NewClass */
    public MiServlet() {
    }
    
    
    protected String altaForm = null;    
    protected String errorAltaForm = null;    
    protected String exitoAltaForm = null;      
    protected String mainForm = null;      
    protected String altaServlet = null;   
    protected String persistenceMechanism = null;
    
    protected String accesoForm = null;
    protected String errorAccesoForm = null;
    protected String exitoAccesoForm = null;
    protected String accesoServlet = null;
    
    protected void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getNamedDispatcher(address);
        dispatcher.forward(request, response);
        
    }
    
    protected void gotoJSPPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
        
    }
    
    
    
    public void init(){
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();
        altaForm = context.getInitParameter("altaForm");
        errorAltaForm = context.getInitParameter("errorAltaForm");
        exitoAltaForm = context.getInitParameter("exitoAltaForm");        
        mainForm = context.getInitParameter("mainForm");
        altaServlet  = context.getInitParameter("altaServlet");        
        persistenceMechanism = context.getInitParameter("persistenceMechanism");
        accesoForm = context.getInitParameter("accesoForm");
        errorAccesoForm = context.getInitParameter("errorAccesoForm");
        exitoAccesoForm = context.getInitParameter("exitoAccesoForm");
        accesoServlet  = context.getInitParameter("accesoServlet");    
        
    }
    
}

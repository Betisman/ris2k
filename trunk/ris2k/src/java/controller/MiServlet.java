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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Partida;


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
    protected String errorForm = null;
    protected String exitoAccesoForm = null;
    protected String menuForm = null;
    protected String accesoServlet = null;
    protected String actualizacionJugada = null;
    
    protected String territorioAtacante = null;
    protected String territorioDefensor = null;
    protected String pathTablero = null;
    
    protected String tableroMenu = null;
    protected String partidas = null;
    protected String partidasActivas = null;
    protected String listaPartidas = null;
    
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
        menuForm = context.getInitParameter("menuForm");
        accesoServlet  = context.getInitParameter("accesoServlet");
        territorioAtacante = context.getInitParameter("territorioAtacante");
        territorioDefensor = context.getInitParameter("territorioDefensor");
        pathTablero = context.getInitParameter("pathTablero");
        tableroMenu = context.getInitParameter("tableroMenu");
        partidas = context.getInitParameter("partidas");
        partidasActivas = context.getInitParameter("partidasActivas");
        errorForm = context.getInitParameter("errorForm");
        actualizacionJugada = context.getInitParameter("actualizacionJugada");
        listaPartidas = context.getInitParameter("listaPartidas");
        
        ArrayList<Partida> partidas = new ArrayList();
        context.setAttribute("partidasActivas", partidas);
    }
    
}

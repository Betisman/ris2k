/*
 * NewPlayer.java
 *
 * Created on 25 de febrero de 2007, 17:18
 */

package test;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

//Conjunto de clases importadas para el uso del MySQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos
 * @version
 */
public class NewPlayer extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            /* Carga del Driver JDBC de MySQL */
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        try{
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql:@localhost:1521:prueba",//configConn.getDB_URL(),
                "prueba",//configConn.getDB_USER(),
                "prueba"/*configConn.getDB_PASSWORD()*/);
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        request.getSession().setAttribute("newPlayerName", "");
        request.getSession().setAttribute("newPlayerNick", "");
        request.getSession().setAttribute("newPlayerEmail", "");
         
        String name = request.getParameter("newPlayerName");
        String phone = request.getParameter("newPlayerNick");
        String address = request.getParameter("newPlayerEmail");
       
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

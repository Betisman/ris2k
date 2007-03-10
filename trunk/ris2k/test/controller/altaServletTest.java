/*
 * altaServletTest.java
 * JUnit based test
 *
 * Created on 10 de marzo de 2007, 19:37
 */

package controller;

import junit.framework.*;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import persistence.Mysql;
import model.Jugador;

/**
 *
 * @author Ramon
 */
public class altaServletTest extends TestCase {
    
    public altaServletTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * Test of processRequest method, of class controller.altaServlet.
     */
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        
        altaServlet instance = new altaServlet();
        
        request.setAttribute("user","pruebadealta");
        request.setAttribute("password","password");
        request.setAttribute("email","prueba@prueba.com");
        
        
        instance.processRequest(request, response);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doGet method, of class controller.altaServlet.
     */
    /*public void testDoGet() throws Exception {
        System.out.println("doGet");
        
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        altaServlet instance = new altaServlet();
        
        instance.doGet(request, response);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class controller.altaServlet.
     */
  /*  public void testDoPost() throws Exception {
        System.out.println("doPost");
        
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        altaServlet instance = new altaServlet();
        
        instance.doPost(request, response);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getServletInfo method, of class controller.altaServlet.
     */
/*    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        
        altaServlet instance = new altaServlet();
        
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
  */
}

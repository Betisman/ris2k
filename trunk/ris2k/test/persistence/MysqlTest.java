/*
 * MysqlTest.java
 * JUnit based test
 *
 * Created on 7 de marzo de 2007, 19:12
 */

package persistence;

import java.util.GregorianCalendar;
import junit.framework.*;
import javax.servlet.RequestDispatcher;
import model.Jugador;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.sql.*;

/**
 *
 * @author Ramon
 */
public class MysqlTest extends TestCase {
    
    public MysqlTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
/*****************************************************************************/
    /**
     * Tests of persistirJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/

    /*prueba si un jugador válido se puede persistir*/
    public void testPersistirJugadorValido() {
        System.out.println(">>> persistirJugadorValido");
        Jugador jugador = new Jugador();
       
        System.out.println("BORRAMOS USUARIO DE PRUEBA DE LA BD(Si existe anteriormente)");
        Mysql.borrarJugador("prueba");
        
        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        Mysql.persistirJugador(jugador);
        
        boolean expResult = true;
        boolean result = Mysql.validarJugador(jugador);
        assertEquals(expResult, result);
                
    //    fail("Ha saltado una excepción");
    }
    
    /*prueba que un jugador nulo no se pueda persistir*/
    public void testPersistirJugadorNulo() throws Exception{
        System.out.println(">>> persistirJugadorNulo");
        try
        {
            Jugador jugador = null;
            boolean expResult = true;
            boolean result = Mysql.persistirJugador(jugador);
            assertEquals(expResult, result);
            fail("Debe lanzarse una excepción");
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }

    /*prueba que un jugador sin nombre no se pueda persistir*/
    public void testPersistirJugadorSinNombre() throws Exception{
        System.out.println(">>> persistirJugadorSinNombre");
        try
        {
            Jugador jugador = null;
//            jugador.setUser("prueba");
            jugador.setPassword("prueba");
            jugador.setEmail("prueba@prueba.com");

            boolean expResult = true;
            boolean result = Mysql.persistirJugador(jugador);
            assertEquals(expResult, result);
            fail("Debe lanzarse una excepción");
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }

    /*prueba que un jugador sin password no se pueda persistir*/
    public void testPersistirJugadorSinPassword() throws Exception{
        System.out.println(">>> persistirJugadorSinPassword");
        try
        {
            Jugador jugador = null;
            jugador.setUser("prueba");
//            jugador.setPassword("prueba");
            jugador.setEmail("prueba@prueba.com");

            boolean expResult = true;
            boolean result = Mysql.persistirJugador(jugador);
            assertEquals(expResult, result);
            fail("Debe lanzarse una excepción");
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }
    
    /*prueba que un jugador sin email no se pueda persistir*/
    public void testPersistirJugadorSinEmail() throws Exception{
        System.out.println(">>> persistirJugadorSinEmail");
        try
        {
            Jugador jugador = null;
            jugador.setUser("prueba");
            jugador.setPassword("prueba");
//            jugador.setEmail("prueba@prueba.com");

            boolean expResult = true;
            boolean result = Mysql.persistirJugador(jugador);
            assertEquals(expResult, result);
            fail("Debe lanzarse una excepción");
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }
    
/*****************************************************************************/
    /**
     * Tests of borrarJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/
    
   /*prueba si un jugador existente se puede borrar*/
    public void testBorrarJugador() {
        System.out.println(">>> borrarJugadorExistente");
        Jugador jugador = new Jugador();
       
        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        System.out.println("INSERTAMOS USUARIO DE PRUEBA DE LA BD(Si no existe anteriormente)");
        Mysql.persistirJugador(jugador);
        
        
        Mysql.borrarJugador("prueba");
        
        boolean expResult = false;
        boolean result = Mysql.validarJugador(jugador);
        assertEquals(expResult, result);
                
    //    fail("Ha saltado una excepción");
    }


/*****************************************************************************/
    /**
     * Tests of validarJugador method, of class persistence.Mysql.
     */
/*****************************************************************************/

    public void testValidarJugadorValido() {
        System.out.println(">>> ValidarJugadorValido");
 
        Jugador jugador = new Jugador();
       
        System.out.println("NOS ASEGURAMOS DE QUE EXISTA UN USUARIO DE PRUEBA CONCRETO");

        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        Mysql.borrarJugador("prueba");
        Mysql.persistirJugador(jugador);
        
 //       TODO:                
        
        System.out.println("COMPROBAMOS QUE AL CONSULTAR ESE MISMO USUARIO, EL RESULTADO ES CORRECTO");
        boolean expResult = true;
        boolean result = Mysql.validarJugador(jugador);
        assertEquals(expResult, result);
                
    //    fail("Ha saltado una excepción");
    }
    
    public void testValidarJugadorInexistente() throws Exception{
        System.out.println(">>> validarrJugadorInexistente");

        System.out.println("NOS ASEGURAMOS DE QUE NO EXISTA UN USUARIO DE PRUEBA CONCRETO");
        Mysql.borrarJugador("prueba");
        
        try
        {
            Jugador jugador = null;
            jugador.setUser("prueba");
            jugador.setPassword("prueba");
            jugador.setEmail("prueba@prueba.com");

            boolean expResult = true;
            boolean result = Mysql.validarJugador(jugador);
            assertEquals(expResult, result);
            fail("Debe lanzarse una excepción");
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }
    
    public void testValidarJugadorPasswordErroneo() throws Exception{
        System.out.println(">>> validarrJugadorPasswordErroneo");

        Jugador jugador = new Jugador();
       
        System.out.println("NOS ASEGURAMOS DE QUE EXISTA UN USUARIO DE PRUEBA CONCRETO");

        jugador.setUser("prueba");
        jugador.setPassword("prueba");
        jugador.setEmail("prueba@prueba.com");
        
        Mysql.borrarJugador("prueba");
        Mysql.persistirJugador(jugador);
        
        try
        {
            jugador.setUser("prueba");
            jugador.setPassword("error");
            jugador.setEmail("prueba@prueba.com");

            boolean expResult = true;
            boolean result = Mysql.validarJugador(jugador);
            assertEquals(expResult, result);
            fail("Debe lanzarse una excepción");
        }
        catch (Exception e)
        {
            //cogemos la excepción para que el caso no falle
        }
    }
    
    //*************************************************************************************
}
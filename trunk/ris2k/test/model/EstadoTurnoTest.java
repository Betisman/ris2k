/*
 * EstadoTurnoTest.java
 * JUnit based test
 *
 * Created on 22 de marzo de 2007, 12:17
 */

package model;

import junit.framework.*;

/**
 *
 * @author Ramon
 */
public class EstadoTurnoTest extends TestCase {
    
    public EstadoTurnoTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

 /*****************************************************************************/
    /**
     * Tests of estadoInicial method, of class model.EstadoTurno.
     */
/*****************************************************************************/


    public void testEstadoInicialValido() {
        System.out.println(">>> estado inicial");
        EstadoTurno expResult = new EstadoTurno();
        EstadoTurno result= new EstadoTurno();
        expResult.setEstado("ESPERA");
               
        result.estadoInicial();
        assertEquals(expResult.getEstado(), result.getEstado());
        
        }
        
        

 
    
 /*****************************************************************************/
    /**
     * Tests of estadoSiguiente method, of class model.EstadoTurno.
     */
/*****************************************************************************/

    public void testEstadoSiguiente_1() {
        System.out.println(">>> estado siguiente_1");
        EstadoTurno estado = new EstadoTurno();
        estado.setEstado("ESPERA");

        try
        {
            System.out.println(estado.getEstado());
            estado = estado.estadoSiguiente();
            System.out.println(estado.getEstado());

            String result = estado.getEstado();
            String expResult = "REFUERZO";

            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
            fail("Se ha detectado una excepción: "+ex.getMessage());
        }
    }
    public void testEstadoSiguiente_2() {
        System.out.println(">>> estado siguiente_2");
        EstadoTurno estado = new EstadoTurno();
        estado.setEstado("REFUERZO");

        try
        {
            System.out.println(estado.getEstado());
            estado = estado.estadoSiguiente();
            System.out.println(estado.getEstado());

            String result = estado.getEstado();
            String expResult = "COMBATE";

            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
            fail("Se ha detectado una excepción: "+ex.getMessage());
        }
    }
    public void testEstadoSiguiente_3() {
        System.out.println(">>> estado siguiente_3");
        EstadoTurno estado = new EstadoTurno();
        estado.setEstado("COMBATE");

        try
        {
            System.out.println(estado.getEstado());
            estado = estado.estadoSiguiente();
            System.out.println(estado.getEstado());

            String result = estado.getEstado();
            String expResult = "REPOBLACION";

            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
            fail("Se ha detectado una excepción: "+ex.getMessage());
        }
    }
    public void testEstadoSiguiente_4() {
        System.out.println(">>> estado siguiente_4");
        EstadoTurno estado = new EstadoTurno();
        estado.setEstado("REPOBLACION");

        try
        {
            System.out.println(estado.getEstado());
            estado = estado.estadoSiguiente();
            System.out.println(estado.getEstado());

            String result = estado.getEstado();
            String expResult = "ESPERA";

            assertEquals(expResult, result);
        }
        catch (Exception ex)
        {
            fail("Se ha detectado una excepción: "+ex.getMessage());
        }
    }
    public void testEstadoSiguienteNoValido() {
        System.out.println(">>> estado siguiente no valido");
        EstadoTurno estado = new EstadoTurno();
        estado.setEstado("NO VALIDO");

        try
        {
            estado = estado.estadoSiguiente();
        }
        catch (Exception ex)
        {
            String expResult = "El estado no es válido";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("Se esperaba la siguiente excepción: El estado no es válido");
    }
    public void testEstadoSiguienteNulo() {
        System.out.println(">>> estado siguiente no valido");
        EstadoTurno estado = new EstadoTurno();
        estado.setEstado(null);

        try
        {
            estado = estado.estadoSiguiente();
        }
        catch (Exception ex)
        {
            String expResult = "El estado no es válido";
            String result = ex.getMessage();
            assertEquals(expResult, result);
            return;
        }
        fail("Se esperaba la siguiente excepción: El estado no es válido");
    }
}
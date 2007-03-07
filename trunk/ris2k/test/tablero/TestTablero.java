/*
 * TestTablero.java
 * JUnit based test
 *
 * Created on 7 de marzo de 2007, 23:50
 */

package tablero;

import junit.framework.*;
import model.Tablero;

/**
 *
 * @author Carlos
 */
public class TestTablero extends TestCase {
    
    public TestTablero(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
    
    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    public void testMostrar(){
        Tablero tablero = new Tablero();
        tablero.setMapa("web/test/dibujo.xml");
        assert(tablero.mostrar());
    }
    

}

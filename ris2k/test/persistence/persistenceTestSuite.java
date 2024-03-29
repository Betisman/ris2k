/*
 * persistenceTestSuite.java
 * JUnit based test
 *
 * Created on 21 de abril de 2007, 18:19
 */

package persistence;

import junit.framework.*;
import persistence.MySqlPartidaTest;
import persistence.MysqlJugadorTest;

/**
 *
 * @author Ramon
 */
public class persistenceTestSuite extends TestCase {
    
    public persistenceTestSuite(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    /**
     * suite method automatically generated by JUnit module
     */
    public static Test suite() {
        TestSuite suite = new TestSuite("persistenceTestSuite");
        
        //mysqljugador
        suite.addTest(new MysqlJugadorTest("testPersistirJugadorValido"));
        suite.addTest(new MysqlJugadorTest("testPersistirJugadorValidoMuchos"));
        suite.addTest(new MysqlJugadorTest("testPersistirJugadorNulo"));
        suite.addTest(new MysqlJugadorTest("testPersistirJugadorSinNombre"));
        suite.addTest(new MysqlJugadorTest("testPersistirJugadorSinPassword"));
        suite.addTest(new MysqlJugadorTest("testPersistirJugadorSinEmail"));
        suite.addTest(new MysqlJugadorTest("testPersistirJugadorDuplicado"));
        suite.addTest(new MysqlJugadorTest("testBorrarJugador"));
        suite.addTest(new MysqlJugadorTest("testValidarJugadorValido"));
        suite.addTest(new MysqlJugadorTest("testValidarJugadorInexistente"));
        suite.addTest(new MysqlJugadorTest("testValidarJugadorPasswordErroneo"));
        suite.addTest(new MysqlJugadorTest("testValidarJugadorVacio"));
        suite.addTest(new MysqlJugadorTest("testGetJugadorValido"));
        suite.addTest(new MysqlJugadorTest("testGetJugadorInexistente"));
        
        //mysqlpartida
        suite.addTest(new MySqlPartidaTest("testPersistirPartidaValida"));
        suite.addTest(new MySqlPartidaTest("testPersistirPartidaValidaMuchos"));
        suite.addTest(new MySqlPartidaTest("testPersistirPartidaNull"));
        suite.addTest(new MySqlPartidaTest("testPersistirPartidaSinNombre"));
        suite.addTest(new MySqlPartidaTest("testPersistirPartidaSinOwner"));
        suite.addTest(new MySqlPartidaTest("testPersistirPartidaSinJugadores"));
        suite.addTest(new MySqlPartidaTest("testPersistirPartidaDuplicada"));
        suite.addTest(new MySqlPartidaTest("testGetPartidaValida"));
        suite.addTest(new MySqlPartidaTest("testGetPartidaInexistente"));
        
        
        return suite;
    }
    
}

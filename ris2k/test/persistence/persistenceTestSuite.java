/*
 * persistenceTestSuite.java
 * JUnit based test
 *
 * Created on 21 de abril de 2007, 18:19
 */

package persistence;

import junit.framework.*;

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
        
        TestSuite mysqljugadorSuite = new TestSuite("persistenceTestSuite");
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testPersistirJugadorValido"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testPersistirJugadorValidoMuchos"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testPersistirJugadorNulo"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testPersistirJugadorSinNombre"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testPersistirJugadorSinPassword"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testPersistirJugadorSinEmail"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testPersistirJugadorDuplicado"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testBorrarJugador"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testValidarJugadorValido"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testValidarJugadorInexistente"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testValidarJugadorPasswordErroneo"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testValidarJugadorVacio"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testGetJugadorValido"));
        mysqljugadorSuite.addTest(new MysqlJugadorTest("testGetJugadorInexistente"));
        
        TestSuite mysqlpartidaSuite = new TestSuite("persistenceTestSuite");
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaValida"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaValidaMuchos"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaNull"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinNombre"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinOwner"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinJugadores"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaDuplicada"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testGetPartidaValida"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testGetPartidaInexistente"));
/*        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinNombre"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinNombre"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinNombre"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinNombre"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinNombre"));
        mysqlpartidaSuite.addTest(new MySqlPartidaTest("testPersistirPartidaSinNombre"));
   */     
        
        
 //       suite.addTest(mysqljugadorSuite);
        suite.addTest(mysqlpartidaSuite);
        return suite;
    }
    
}

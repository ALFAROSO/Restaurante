/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.dao;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import restaurante.modelos.Cliente;

/**
 *
 * @author ALFA
 */
public class ActualizadorTest {
    Connection conn;
    public ActualizadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        conn = CreadorDeConexiones.crearConexion();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actualizar method, of class Actualizador.
     */
    @Test
    public void testActualizarConClienteVacio() throws Exception {
        System.out.println("testActualizarConClienteVacio");
        Connection conn = null;
        Cliente cliente = null;
        boolean expResult = false;
        boolean result = Actualizador.actualizar(conn, cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testActualizarConClienteNoVacio() throws Exception {
        System.out.println("testActualizarConClienteNoVacio");
        //Connection conn = null;
        Cliente cliente = new Cliente();
        cliente.setCli_login("PRUEBA");
        cliente.setCli_nombre("nombrecitas");
        cliente.setCli_clave("clavemao");
        boolean expResult = true;
        boolean result = Actualizador.actualizar(conn, cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

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
public class BorradorTest {
    Connection conn;
    Cliente cliente;
    
    public BorradorTest() {
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
        
        cliente = new Cliente();
        cliente.setCli_login("PRUEBA");
        cliente.setCli_nombre("nombrecitas");
        cliente.setCli_clave("clavemao");
        
        Insertador.insercion(conn, cliente);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of borrar method, of class Borrador.
     */
    @Test
    public void testBorrarConCienteVacio() throws Exception {
        System.out.println("borrar");
        //Connection conn = null;
        Cliente cliente = null;
        boolean expResult = false;
        boolean result = Borrador.borrar(conn, cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testBorrarCienteEspecifico() throws Exception {
        System.out.println("borrar");
        //Connection conn = null;
        Cliente cliente = null;
        boolean expResult = false;
        boolean result = Borrador.borrar(conn, cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

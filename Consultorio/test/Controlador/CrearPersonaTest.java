/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jessi
 */
public class CrearPersonaTest {
    
    public CrearPersonaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conectarBD method, of class ControladorPersona.
     */
//    @Test
//    public void testConectarBD() {
//        System.out.println("conectarBD");
//        ControladorPersona instance = new ControladorPersona();
//        instance.conectarBD();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of desconectarBd method, of class ControladorPersona.
     */
//    @Test
//    public void testDesconectarBd() {
//        System.out.println("desconectarBd");
//        ControladorPersona instance = new ControladorPersona();
//        instance.desconectarBd();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of crear method, of class ControladorPersona.
     */
    @Test
    public void testCrear() {
        System.out.println("crear");
        Persona p = new Persona(0,"0107122198","Erick","Mendez","Azogues","2475662","15-03-1997","erick@gmail.com","12345");
        ControladorPersona instance = new ControladorPersona();
        instance.crear(p);
        
    }

    /**
     * Test of idPersona method, of class ControladorPersona.
     */
//    @Test
//    public void testIdPersona() {
//        System.out.println("idPersona");
//        String cedula = "";
//        String clave = "";
//        ControladorPersona instance = new ControladorPersona();
//        String expResult = "";
//        String result = instance.idPersona(cedula, clave);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of validar method, of class ControladorPersona.
     */
//    @Test
//    public void testValidar() {
//        System.out.println("validar");
//        String usuario = "";
//        String clave = "";
//        String opc = "";
//        ControladorPersona instance = new ControladorPersona();
//        String expResult = "";
//        String result = instance.validar(usuario, clave, opc);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

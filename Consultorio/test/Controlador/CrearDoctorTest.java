/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Medico;
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
public class CrearDoctorTest {
    
    public CrearDoctorTest() {
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
     * Test of crear method, of class ControladorDoctor.
     */
    @Test
    public void testCrear() {
        ControladorPersona conPer = new ControladorPersona();
        Persona pers = conPer.buscar(1);
        
        System.out.println("crear doctor");
        Medico m = new Medico(0, "Ginecologo", pers);
        int persona = 0;
        ControladorDoctor instance = new ControladorDoctor();
        instance.crear(m, persona);
    }

    /**
     * Test of esDoctor method, of class ControladorDoctor.
     */
    /*@Test
    public void testEsDoctor() {
        System.out.println("esDoctor");
        String cedula = "";
        String clave = "";
        ControladorDoctor instance = new ControladorDoctor();
        String expResult = "";
        String result = instance.esDoctor(cedula, clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}

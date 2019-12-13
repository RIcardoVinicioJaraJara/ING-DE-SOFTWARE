/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
/**
 *
 * @author Usuario
 */
public class ControladorPersonaTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][]{
            {"0000000000", "Suarez", "SECRETARIA", "Usuario no encontrado"},
            {"0107137416", "patito", "PACIENTE", "PACIENTE"},
            {"0107137416", "patito", "SECRETARIA", "SECRETARIA"},
            {"0107137416", "patito", "DOCTOR", "DOCTOR"}
        });
    }

    String usuario2, clave2, opcion2, resultado2;

    public ControladorPersonaTest(String usuario, String clave, String opcion, String resultado) {
        this.usuario2 = usuario;
        this.clave2 = clave;
        this.opcion2 = opcion;
        this.resultado2 = resultado;
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
     * Test of idPersona method, of class ControladorPersona.
     */
    /*@Test
    public void testIdPersona() {
        System.out.println("idPersona");
        String cedula = "";
        String clave = "";
        ControladorPersona instance = new ControladorPersona();
        String expResult = "";
        String result = instance.idPersona(cedula, clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /**
     * Test of validar method, of class ControladorPersona.
     */
    @Test
    public void testValidar() {
        System.out.println("validar");
        String usuario = usuario2;
        String clave = clave2;
        String opc = opcion2;
        ControladorPersona instance = new ControladorPersona();
        String expResult = resultado2;
        String result = instance.validar(usuario, clave, opc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

}

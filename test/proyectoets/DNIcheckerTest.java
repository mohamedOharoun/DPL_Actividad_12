/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoets;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mhz_2
 */
public class DNIcheckerTest {
    
    public DNIcheckerTest() {
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
     * Test of validarDNI method, of class DNIchecker.
     */
    @Test
    public void testValidarDNI_Correcto() {
        System.out.println("validarDNI");
        String DNI = "42248958M";
        DNIchecker instance = new DNIchecker();
        boolean expResult = true;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testValidarDNI_ConExtensionMenor() {
        System.out.println("validarDNI");
        String DNI = "422489M";
        DNIchecker instance = new DNIchecker();
        boolean expResult = false;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testValidarDNI_ConExtensionMayor() {
        System.out.println("validarDNI");
        String DNI = "422489593M";
        DNIchecker instance = new DNIchecker();
        boolean expResult = false;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testValidarDNI_ConSecuenciaIncorrecta() {
        System.out.println("validarDNI");
        String DNI = "4224U959M";
        DNIchecker instance = new DNIchecker();
        boolean expResult = false;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testValidarDNI_ConLetraIncorrecta() {
        System.out.println("validarDNI");
        String DNI = "42248959F";
        DNIchecker instance = new DNIchecker();
        boolean expResult = false;
        boolean result = instance.validarDNI(DNI);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

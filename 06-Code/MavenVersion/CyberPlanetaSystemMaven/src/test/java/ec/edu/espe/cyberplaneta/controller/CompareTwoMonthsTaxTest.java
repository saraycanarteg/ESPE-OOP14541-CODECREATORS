/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public class CompareTwoMonthsTaxTest {
    
    public CompareTwoMonthsTaxTest() {
    }

    /**
     * Test of calculateDifference method, of class C_TaxesOperation.
     */
    @Test
    public void testCalculateDifference1() {
        System.out.println("calculateDifference");
        double primerMes = 1200.0;
        double segundoMes = 1000.0;
        double expResult = 200.0;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
        
    }
    @Test
    public void testCalculateDifference2() {
        System.out.println("calculateDifference");
        double primerMes = 2700.0;
        double segundoMes = 1100.0;
        double expResult = 1600.0;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
        
    }
    @Test
    public void testCalculateDifference3() {
        System.out.println("calculateDifference");
        double primerMes = 123.7;
        double segundoMes = 23.4;
        double expResult = 100.3;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
        
    }
    @Test
    public void testCalculateDifference4() {
        System.out.println("calculateDifference");
        double primerMes = 444.2;
        double segundoMes = 231.1;
        double expResult = 213.1;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
        
    }
    @Test
    public void testCalculateDifference5() {
        System.out.println("calculateDifference");
        double primerMes = 32.1;
        double segundoMes = 121.4;
        double expResult = 89.3;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
        
    }
    @Test
    public void testCalculateDifference6() {
        System.out.println("calculateDifference");
        double primerMes = 123.2;
        double segundoMes = 241.5;
        double expResult = 118.3;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
        
    }
     @Test
    public void testCalculateDifference7() {
        System.out.println("calculateDifference7");
        double primerMes = 789.5;
        double segundoMes = 123.4;
        double expResult = 666.1;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testCalculateDifference8() {
        System.out.println("calculateDifference8");
        double primerMes = 0.0;
        double segundoMes = 250.5;
        double expResult = 250.5;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testCalculateDifference9() {
        System.out.println("calculateDifference9");
        double primerMes = 999.9;
        double segundoMes = 0.1;
        double expResult = 999.8;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testCalculateDifference10() {
        System.out.println("calculateDifference10");
        double primerMes = 456.7;
        double segundoMes = 123.2;
        double expResult = 333.5;
        double result = C_TaxesOperation.calculateDifference(primerMes, segundoMes);
        assertEquals(expResult, result, 0.1);
    }
}

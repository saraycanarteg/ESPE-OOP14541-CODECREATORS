/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lilit
 */
public class CalcuteAverageMonthlyTaxesTest {
    
    public CalcuteAverageMonthlyTaxesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculateAverageMonthlyTaxes method, of class TaxesAverageController.
     */
  
    
     @Test
    public void testCalculateAverageMonthlyTaxes1() {
        System.out.println("calculateAverageMonthlyTaxes1");
        int numberOfMonths = 2;
        double[] monthlyTaxes = {100.0, 50.0};
        double expResult = 75.0;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateAverageMonthlyTaxes2() {
        System.out.println("calculateAverageMonthlyTaxes2");
        int numberOfMonths = 2;
        double[] monthlyTaxes = {200.0, 100.0};
        double expResult = 150.0;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateAverageMonthlyTaxes3() {
        System.out.println("calculateAverageMonthlyTaxes3");
        int numberOfMonths = 3;
        double[] monthlyTaxes = {300.0, 300.0, 300.0};
        double expResult = 300.0;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateAverageMonthlyTaxes4() {
        System.out.println("calculateAverageMonthlyTaxes4");
        int numberOfMonths = 2;
        double[] monthlyTaxes = {150.0, 200.0};
        double expResult = 175.0;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateAverageMonthlyTaxes5() {
        System.out.println("calculateAverageMonthlyTaxes5");
        int numberOfMonths = 2;
        double[] monthlyTaxes = {0.0, 100.0};
        double expResult = 50.0;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateAverageMonthlyTaxes6() {
        System.out.println("calculateAverageMonthlyTaxes6");
        int numberOfMonths = 2;
        double[] monthlyTaxes = {500.5, 250.5};
        double expResult = 375.5;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

  

    @Test
    public void testCalculateAverageMonthlyTaxes7() {
        System.out.println("calculateAverageMonthlyTaxes7");
        int numberOfMonths = 1;
        double[] monthlyTaxes = {100.0};
        double expResult = 100.0;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateAverageMonthlyTaxes8() {
        System.out.println("calculateAverageMonthlyTaxes8");
        int numberOfMonths = 2;
        double[] monthlyTaxes = {1000.0, 500.0};
        double expResult = 750.0;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateAverageMonthlyTaxes9() {
        System.out.println("calculateAverageMonthlyTaxes9");
        int numberOfMonths = 2;
        double[] monthlyTaxes = {150.75, 100.25};
        double expResult = 125.5;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateAverageMonthlyTaxes10() {
        System.out.println("calculateAverageMonthlyTaxes10");
        int numberOfMonths = 2;
        double[] monthlyTaxes = {0.0, 0.0};
        double expResult = 0.0;
        double result = TaxesAverageController.calculateAverageMonthlyTaxes(numberOfMonths, monthlyTaxes);
        assertEquals(expResult, result, 0.01);
    }
}

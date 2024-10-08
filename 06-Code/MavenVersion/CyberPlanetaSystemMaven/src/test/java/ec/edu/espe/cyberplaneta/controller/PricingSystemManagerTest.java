package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Saray Cañarte, Code Creators, DCCO-ESPE
 */
public class PricingSystemManagerTest {

    public PricingSystemManagerTest() {
    }

    /**
     * Test of calculateTotalPrice method, of class C_PricingSystem.
     */
    @Test
    public void testCalculateTotalPrice1() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,1, "Declaración de IVA en 0", 5.0f, 15f);
        float numDocumentation = 20.0F;
        float expResult = 6.9F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice2() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,1, "Declaración de IVA en 0", 5.0f, 15f);
        float numDocumentation = 0.0F;
        float expResult = 5.75F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice3() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,2, "Declaración de IVA mensual", 20.0f, 15f);
        float numDocumentation = 123.0F;
        float expResult = 30.07F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice4() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,3, "Declaración de IVA semestral", 50.0f, 15f);
        float numDocumentation = 10.0F;
        float expResult = 58.07F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice5() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,4, "Devolución Impuesto a la Renta", 3.5f, 15f);
        float numDocumentation = 9.0F;
        float expResult = 4.54F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice6() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,4, "Devolución Impuesto a la Renta", 3.5f, 15f);
        float numDocumentation = 0.0F;
        float expResult = 4.02F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice7() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,5, "Anexo de Accionista", 5.0f, 15f);
        float numDocumentation = 453.0F;
        float expResult = 31.79F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice8() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,5, "Anexo de Accionista", 5.0f, 15f);
        float numDocumentation = 40.0F;
        float expResult = 8.05F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice9() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,2, "Declaración de IVA mensual", 20.0f, 15f);
        float numDocumentation = 40.0F;
        float expResult = 25.30F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTotalPrice10() {
        System.out.println("calculateTotalPrice");
        PriceList selectedProcess = new PriceList(1,1, "Declaración de IVA en 0", 5.0f, 15f);
        float numDocumentation = 40.0F;
        float expResult = 8.05F;
        float result = C_PricingSystem.calculateTotalPrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calculateBasePrice method, of class C_PricingSystem.
     */
    @Test
    public void testCalculateBasePrice1() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,1, "Declaración de IVA en 0", 5.0f, 15f);
        float numDocumentation = 20.0F;
        float expResult = 6.0F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice2() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,1, "Declaración de IVA en 0", 5.0f, 15f);
        float numDocumentation = 0.0F;
        float expResult = 5.0F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice3() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,2, "Declaración de IVA mensual", 20.0f, 15f);
        float numDocumentation = 123.0F;
        float expResult = 26.15F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice4() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,2, "Declaración de IVA semestral", 20.0f, 15f);
        float numDocumentation = 50.0F;
        float expResult = 22.5F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice5() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,3, "Declaración de IVA semestral", 50.0f, 15f);
        float numDocumentation = 137.0F;
        float expResult = 56.85F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice6() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,3, "Declaración de IVA semestral", 50.0f, 15f);
        float numDocumentation = 46.0F;
        float expResult = 52.3F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice7() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,4, "Declaración de IVA semestral", 3.5f, 15f);
        float numDocumentation = 81.0F;
        float expResult = 7.55F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice8() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,4, "Declaración de IVA semestral", 3.5f, 15f);
        float numDocumentation = 0.0F;
        float expResult = 3.5F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice9() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,5, "Declaración de IVA semestral", 5.0f, 15f);
        float numDocumentation = 246.0F;
        float expResult = 17.3F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateBasePrice10() {
        System.out.println("calculateBasePrice");
        PriceList selectedProcess = new PriceList(1,5, "Declaración de IVA semestral", 5.0f, 15f);
        float numDocumentation = 451.0F;
        float expResult = 27.55F;
        float result = C_PricingSystem.calculateBasePrice(selectedProcess, numDocumentation);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calculateTax method, of class C_PricingSystem.
     */
    @Test
    public void testCalculateTax1() {
        System.out.println("calculateTax");
        float basePrice = 6.0F;
        float taxRate = 15.0F;
        float expResult = 0.9F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax2() {
        System.out.println("calculateTax");
        float basePrice = 324.34F;
        float taxRate = 15.0F;
        float expResult = 48.65F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax3() {
        System.out.println("calculateTax");
        float basePrice = 15.00F;
        float taxRate = 15.0F;
        float expResult = 2.25F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax4() {
        System.out.println("calculateTax");
        float basePrice = 9755.03F;
        float taxRate = 15.0F;
        float expResult = 1463.25F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax5() {
        System.out.println("calculateTax");
        float basePrice = 1000.03F;
        float taxRate = 15.0F;
        float expResult = 150.00F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax6() {
        System.out.println("calculateTax");
        float basePrice = 25.32F;
        float taxRate = 15.0F;
        float expResult = 3.79F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax7() {
        System.out.println("calculateTax");
        float basePrice = 329.01F;
        float taxRate = 15.0F;
        float expResult = 49.35F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax8() {
        System.out.println("calculateTax");
        float basePrice = 1.11F;
        float taxRate = 15.0F;
        float expResult = 0.16F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax9() {
        System.out.println("calculateTax");
        float basePrice = 0.03F;
        float taxRate = 15.0F;
        float expResult = 0.00F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateTax10() {
        System.out.println("calculateTax");
        float basePrice = 1500.09F;
        float taxRate = 15.0F;
        float expResult = 225.01F;
        float result = C_PricingSystem.calculateTax(basePrice, taxRate);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calculateCAGR method, of class C_PricingSystem.
     */
    @Test
    public void testCalculateCAGR1() {
        System.out.println("calculateCAGR");
        double initialValue = 1000.0;
        double finalValue = 2000.0;
        int numYears = 5;
        double expResult = 14.86;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateCAGR2() {
        System.out.println("calculateCAGR");
        double initialValue = 240.0;
        double finalValue = 340.0;
        int numYears = 3;
        double expResult = 12.31;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateCAGR3() {
        System.out.println("calculateCAGR");
        double initialValue = 240.0;
        double finalValue = 340.0;
        int numYears = 4;
        double expResult = 9.09;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testCalculateCAGR4() {
        System.out.println("calculateCAGR");
        double initialValue = 350.0;
        double finalValue = 140.0;
        int numYears = 4;
        double expResult = 20.47;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testCalculateCAGR5() {
        System.out.println("calculateCAGR");
        double initialValue = 200.0;
        double finalValue = 100.0;
        int numYears = 4;
        double expResult = 15.91;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testCalculateCAGR6() {
        System.out.println("calculateCAGR");
        double initialValue = 460.0;
        double finalValue = 700.0;
        int numYears = 1;
        double expResult = 51.17;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testCalculateCAGR7() {
        System.out.println("calculateCAGR");
        double initialValue = 920.0;
        double finalValue = 1000.0;
        int numYears = 2;
        double expResult = 4.26;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testCalculateCAGR8() {
        System.out.println("calculateCAGR");
        double initialValue = 1500.0;
        double finalValue = 140.0;
        int numYears = 1;
        double expResult = 90.67;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }
    @Test
    public void testCalculateCAGR09() {
        System.out.println("calculateCAGR");
        double initialValue = 9000.0;
        double finalValue = 15000.0;
        int numYears = 1;
        double expResult = 66.67;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testCalculateCAGR10() {
        System.out.println("calculateCAGR");
        double initialValue = 78587.25;
        double finalValue = 108742.52;
        int numYears = 8;
        double expResult = 4.14;
        double result = C_CompoundAnualGrowth.calculateCAGR(initialValue, finalValue, numYears);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calculateFutureValue method, of class C_PricingSystem.
     */
    @Test
    public void testCalculateFutureValue1() {
        System.out.println("calculateFutureValue");
        double finalValue = 1000.0;
        double cagr = 10.0;
        int numYears = 5;
        double expResult = 1610.51;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue2() {
        System.out.println("calculateFutureValue");
        double finalValue = 1000.0;
        double cagr = 10.0;
        int numYears = 3;
        double expResult = 1331.00;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue3() {
        System.out.println("calculateFutureValue");
        double finalValue = 34575.34;
        double cagr = 23.45;
        int numYears = 4;
        double expResult = 80302.83F;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue4() {
        System.out.println("calculateFutureValue");
        double finalValue = 4512.45;
        double cagr = 23.45;
        int numYears = 4;
        double expResult = 10480.37F;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue5() {
        System.out.println("calculateFutureValue");
        double finalValue = 4512.45;
        double cagr = 20.45;
        int numYears = 3;
        double expResult = 7885.56F;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue6() {
        System.out.println("calculateFutureValue");
        double finalValue = 340.22;
        double cagr = 4.03;
        int numYears = 3;
        double expResult = 383.03F;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue7() {
        System.out.println("calculateFutureValue");
        double finalValue = 340.22;
        double cagr = 4.03;
        int numYears = 1;
        double expResult = 353.93F;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue8() {
        System.out.println("calculateFutureValue");
        double finalValue = 1.00;
        double cagr = 0.0;
        int numYears = 1;
        double expResult = 1.00F;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue9() {
        System.out.println("calculateFutureValue");
        double finalValue = 1.00;
        double cagr = 123.0;
        int numYears = 34;
        double expResult = 695609242235.93F;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testCalculateFutureValue10() {
        System.out.println("calculateFutureValue");
        double finalValue = 675.66;
        double cagr = 0.01;
        int numYears = 7;
        double expResult = 676.13F;
        double result = C_CompoundAnualGrowth.calculateFutureValue(finalValue, cagr, numYears);
        assertEquals(expResult, result, 0.01);
    }

}

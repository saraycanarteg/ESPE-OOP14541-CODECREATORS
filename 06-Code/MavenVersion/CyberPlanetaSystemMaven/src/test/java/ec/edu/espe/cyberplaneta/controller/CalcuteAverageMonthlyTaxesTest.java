/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE
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
     * Test of calcularPromedio method, of class CalcuteAverageMonthlyTaxes.
     */
    @Test
    public void testCalcularPromedio1() {
        JTextField[] camposImpuesto = {new JTextField(), new JTextField()};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("0.0", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio2() {
        JTextField[] camposImpuesto = {new JTextField("100")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("100.0", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio3() {
        JTextField[] camposImpuesto = {new JTextField("100"), new JTextField("200"), new JTextField("300")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("200.0", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio4() {
        JTextField[] camposImpuesto = {new JTextField("-100"), new JTextField("-200")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("-150.0", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio5() {
        JTextField[] camposImpuesto = {new JTextField("100"), new JTextField("-50")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("25.0", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio6() {
        JTextField[] camposImpuesto = {null, new JTextField("100")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("50.0", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio7() {
        JTextField[] camposImpuesto = {new JTextField(" "), new JTextField("100")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("100.0", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio8() {
        JTextField[] camposImpuesto = {new JTextField("100.5"), new JTextField("200.5")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("150.5", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio9() {
        JTextField[] camposImpuesto = {new JTextField("1000000"), new JTextField("2000000")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("1500000.0", resultadoLabel.getText());
    }

    @Test
    public void testCalcularPromedio10() {
        JTextField[] camposImpuesto = {new JTextField("0.01"), new JTextField("0.02")};
        JLabel resultadoLabel = new JLabel();
        CalcuteAverageMonthlyTaxes instance = new CalcuteAverageMonthlyTaxes();
        instance.calcularPromedio(camposImpuesto, resultadoLabel);
        assertEquals("0.015", resultadoLabel.getText());
    }
    
}

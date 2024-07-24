package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.CalcuteAverage;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcuteAverageMonthlyTaxes {
      public static double calculateAverageMonthlyTaxes(int numberOfMonths, double[] monthlyTaxes) {
        if (numberOfMonths <= 0 || monthlyTaxes == null || monthlyTaxes.length != numberOfMonths) {
            throw new IllegalArgumentException("Número de meses inválido o arreglo de impuestos no coincide.");
        }

        double totalTaxes = 0;
        for (double tax : monthlyTaxes) {
            totalTaxes += tax;
        }

        return calculateAverage(totalTaxes, numberOfMonths);
    }

    private static double calculateAverage(double totalTaxes, int numberOfMonths) {
        return totalTaxes / numberOfMonths;
    }

    
}







package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.CalcuteAverage;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class CalcuteAverageMonthlyTaxes {
    private CalcuteAverage model;


    public void calcularPromedio(JTextField[] camposImpuesto, JLabel resultadoLabel) {
        double[] impuestos = new double[camposImpuesto.length];

        for (int i = 0; i < camposImpuesto.length; i++) {
            try {
                impuestos[i] = Double.parseDouble(camposImpuesto[i].getText());
            } catch (NumberFormatException e) {
                impuestos[i] = 0; // Manejar entrada no válida
            }
        }

        double promedio = model.calculateAvera(impuestos);
        resultadoLabel.setText(String.format("%.2f", promedio));
    }
}





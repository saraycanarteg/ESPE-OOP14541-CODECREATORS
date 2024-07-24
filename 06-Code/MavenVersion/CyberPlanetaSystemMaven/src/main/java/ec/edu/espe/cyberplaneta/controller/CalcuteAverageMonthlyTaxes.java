package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.CalcuteAverage;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcuteAverageMonthlyTaxes {
    private CalcuteAverage model;

    public CalcuteAverageMonthlyTaxes() {
        this.model = new CalcuteAverage(); // Inicializa el modelo
    }

    public void calcularPromedio(JTextField[] camposImpuesto, JLabel resultadoLabel) {
        if (camposImpuesto == null || camposImpuesto.length == 0) {
            resultadoLabel.setText("No hay datos para calcular.");
            return;
        }

        double[] impuestos = new double[camposImpuesto.length];
        boolean hayEntradaValida = false;

        for (int i = 0; i < camposImpuesto.length; i++) {
            try {
                impuestos[i] = Double.parseDouble(camposImpuesto[i].getText());
                hayEntradaValida = true; // Hay al menos una entrada válida
            } catch (NumberFormatException e) {
                impuestos[i] = 0; // Manejar entrada no válida
            }
        }

        if (hayEntradaValida) {
            double promedio = model.calcularPromedio(impuestos);
            resultadoLabel.setText(String.format("%.2f", promedio));
        } else {
            resultadoLabel.setText("No se ingresaron datos válidos.");
        }
    }
}






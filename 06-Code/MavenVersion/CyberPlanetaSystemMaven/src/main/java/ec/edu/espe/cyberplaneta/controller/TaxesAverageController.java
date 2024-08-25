package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JTextField;
import utils.Validation;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;
import utils.ChartAndTableUtils;

/**
 *
 * @author Nahomi Cedeño & Saray Cañarte, CODECREATORS, DCCO-ESPE
 */
public class TaxesAverageController {

    public double calculateAverage(List<JTextField> monthFields) {
        double sum = 0;
        int count = 0;

        for (JTextField field : monthFields) {
            if (Validation.validateMoneyFields(field)) {
                sum += Double.parseDouble(field.getText());
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    public String formatAverage(double average) {
        return new DecimalFormat("#.##").format(average);
    }

    public boolean isValidMonthSelection(int selectedMonth) {
        return selectedMonth >= 1 && selectedMonth <= 12;
    }

    public void validateFields(int selectedMonth, List<JTextField> activeMonthFields, JTextField txtAverage, JTextField[] monthFields, javax.swing.JPanel pnlGraph) {
        double average = calculateAverage(activeMonthFields);

        if (average > 0) {
            txtAverage.setText(formatAverage(average));
            generateTaxesChart(selectedMonth, monthFields, average, pnlGraph);
            clearFields(activeMonthFields);
        } else {
            Validation.showMessage(null, "Por favor, ingrese valores válidos en todos los campos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generateTaxesChart(int selectedMonth, JTextField[] monthFields, double average, javax.swing.JPanel pnlGraph) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i = 1; i <= selectedMonth; i++) {
            String label = "Impuesto " + i;
            double impuestoValue = Double.parseDouble(monthFields[i - 1].getText());
            data.setValue(impuestoValue, label, "Impuesto " + i);
        }
        data.setValue(average, "Promedio", "Promedio");

        ChartAndTableUtils.createAndDisplayChart(pnlGraph, data, "Promedio de Impuestos", "Impuestos", "Valor en dólares ($)");
    }

    private void clearFields(List<JTextField> activeMonthFields) {
        for (JTextField field : activeMonthFields) {
            field.setText("");
        }
    }
}








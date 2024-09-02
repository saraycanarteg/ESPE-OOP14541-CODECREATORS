
package ec.edu.espe.cyberplaneta.controller;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.data.category.DefaultCategoryDataset;
import utils.ChartAndTableUtils;
import utils.Validation;

/**
 *
 * @author Nahomi Cedeño & Saray Cañarte, CODECREATORS, DCCO-ESPE
 */
public class C_TaxesOperation implements I_TaxComparison {

    @Override
    public String compareMonths(double valueMonth1, double valueMonth2) {
        if (valueMonth1 > valueMonth2) {
            double difference = valueMonth1 - valueMonth2;
            return "Primer mes ingresado es mayor al segundo mes ingresado por: $ " + difference;
        } else if (valueMonth2 > valueMonth1) {
            double difference = valueMonth2 - valueMonth1;
            return "Segundo mes ingresado es mayor al primer mes ingresado: $ " + difference;
        } else {
            return "No existe diferencia";
        }
    }

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

    private void clearFields(List<JTextField> activeMonthFields) {
        for (JTextField field : activeMonthFields) {
            field.setText("");
        }
    }

    public void validateFields(int selectedMonth, List<JTextField> activeMonthFields, JTextField txtAverage, JTextField[] monthFields, JPanel pnlGraph) {
        double average = calculateAverage(activeMonthFields);
        if (average > 0) {
            txtAverage.setText(formatAverage(average));
            generateTaxesChart(selectedMonth, monthFields, average, pnlGraph);
            clearFields(activeMonthFields);
        } else {
            Validation.showMessage(null, "Por favor, ingrese valores v\u00e1lidos en todos los campos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isValidMonthSelection(int selectedMonth) {
        return selectedMonth >= 1 && selectedMonth <= 12;
    }

    public void generateTaxesChart(int selectedMonth, JTextField[] monthFields, double average, JPanel pnlGraph) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i = 1; i <= selectedMonth; i++) {
            String label = "Impuesto " + i;
            double impuestoValue = Double.parseDouble(monthFields[i - 1].getText());
            data.setValue(impuestoValue, label, "Impuesto " + i);
        }
        data.setValue(average, "Promedio", "Promedio");
        ChartAndTableUtils.createAndDisplayChart(pnlGraph, data, "Promedio de Impuestos", "Impuestos", "Valor en d\u00f3lares ($)");
    }

    public String formatAverage(double average) {
        return new DecimalFormat("#.##").format(average);
    }
}

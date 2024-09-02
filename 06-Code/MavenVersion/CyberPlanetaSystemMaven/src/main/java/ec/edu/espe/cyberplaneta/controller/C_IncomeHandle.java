package ec.edu.espe.cyberplaneta.controller;

import com.itextpdf.text.DocumentException;
import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.MongoDBUtil;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Saray Cañarte & Christian Bonifaz
 */
public class C_IncomeHandle implements I_Table, I_Income {

    public static void saveTaxProcessToDatabase(PriceList selectedProcess, float totalPrice, int numberOfDocumentation) {
        TaxProcess taxProcess = new TaxProcess(selectedProcess, totalPrice);
        MongoDBUtil.saveTaxProcess(taxProcess, numberOfDocumentation);
    }

    @Override
    public void loadDataToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<Document> documents = MongoDBUtil.getAllIncomes();
        float totalSum = 0;

        for (Document doc : documents) {
            int id = doc.getInteger("processId");
            String name = doc.getString("processName");
            int numberOfDocumentation = doc.getInteger("numberOfDocumentation");
            float priceBase = doc.getDouble("price").floatValue();
            float taxRate = doc.getDouble("taxRate").floatValue();
            float totalPrice = doc.getDouble("total").floatValue();

            model.addRow(new Object[]{
                id,
                name,
                numberOfDocumentation,
                String.format("%.2f", priceBase),
                String.format("%.2f", taxRate),
                String.format("%.2f", totalPrice)
            });

            totalSum += totalPrice;
        }

        model.addRow(new Object[]{"", "", "TOTAL:", "", "", String.format("%.2f", totalSum)});
    }

    @Override
    public void recalculateIncomeTotal(DefaultTableModel model) {
        float totalSum = 0;
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());

        for (int i = 0; i < model.getRowCount() - 1; i++) {
            try {
                Number number = format.parse(model.getValueAt(i, 5).toString());
                totalSum += number.floatValue();
            } catch (ParseException e) {
                System.err.println("Error al analizar el valor en la fila " + i + ": " + e.getMessage());
            }
        }
        model.setValueAt(format.format(totalSum), model.getRowCount() - 1, 5);
    }

    @Override
    public void deleteSelectedRow(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int processId = (int) table.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro de borrar este ingreso?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                MongoDBUtil.deleteIncome(processId);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);
                recalculateIncomeTotal(model);

                JOptionPane.showMessageDialog(null, "Ingreso eliminado exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para borrar.");
        }
    }

    @Override
    public void searchInIncomeTable(JTable table, String searchTerm) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Object[]> foundRows = new ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            String name = (String) model.getValueAt(i, 1);
            if (name.toLowerCase().contains(searchTerm.toLowerCase())) {
                foundRows.add(new Object[]{
                    model.getValueAt(i, 0),
                    model.getValueAt(i, 1),
                    model.getValueAt(i, 2),
                    model.getValueAt(i, 3),
                    model.getValueAt(i, 4),
                    model.getValueAt(i, 5)
                });
            }
        }

        model.setRowCount(0);
        for (Object[] row : foundRows) {
            model.addRow(row);
        }

        if (foundRows.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron resultados para: " + searchTerm);
        }
    }
}

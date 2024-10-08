package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saray Cañarte, Code Creators, DCCO-ESPE
 */
public class C_PricingSystem implements I_PricingSystem, I_Table {

    @Override
    public boolean validatePriceId(JTextField textField) {
        String input = textField.getText().trim();
        String regex = "^\\d+$";

        if (input.matches(regex)) {
            try {
                int id = Integer.parseInt(input);

                if (isProcessIdAvailable(id)) {
                    textField.setBackground(Color.WHITE);
                    return true;
                }
            } catch (NumberFormatException e) {
                highlightError(textField);

            }
        }
        highlightError(textField);
        return false;
    }

    @Override
    public float calculateTotalPrice(PriceList selectedProcess, float numDocumentation) {
        float basePrice = calculateBasePrice(selectedProcess, numDocumentation);
        float tax = calculateTax(basePrice, selectedProcess.getTaxRate());
        return basePrice + tax;
    }

    @Override
    public float calculateBasePrice(PriceList selectedProcess, float numDocumentation) {
        float additionalCost = ((numDocumentation / 10) * 0.50f);
        float basePrice = selectedProcess.getPrice();
        return basePrice + additionalCost;
    }

    @Override
    public float calculateTax(float basePrice, float taxRate) {
        return basePrice * (taxRate / 100);
    }

    @Override
    public void loadDataToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (PriceList price : C_PricingSystem.getPriceListArray()) {
            model.addRow(new Object[]{
                price.getProcessId(),
                price.getProcessName(),
                String.format("%.2f", price.getPrice()),
                String.format("%.2f", price.getTaxRate())
            });
        }
    }

    public static PriceList[] getPriceListArray() {
        return new PriceList[]{
            new PriceList(1, 1, "Declaración de IVA en 0", 5.0f, 15f),
            new PriceList(1, 2, "Declaración de IVA mensual", 20.0f, 15f),
            new PriceList(1, 3, "Declaración de IVA semestral", 50.0f, 15f),
            new PriceList(1, 4, "Devolución Impuesto a la Renta", 3.5f, 15f),
            new PriceList(1, 5, "Anexo de Accionista", 5.0f, 15f)
        };
    }

    private static boolean isProcessIdAvailable(int id) {
        PriceList[] priceList = getPriceListArray();
        for (PriceList item : priceList) {
            if (item.getProcessId() == id) {
                return true;
            }
        }
        return false;
    }

    private static void highlightError(JTextField textField) {
        textField.setBackground(Color.PINK);
    }

}


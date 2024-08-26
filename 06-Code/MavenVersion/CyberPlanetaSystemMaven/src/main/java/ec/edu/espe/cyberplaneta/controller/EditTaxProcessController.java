/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utils.MongoDBUtil;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public class EditTaxProcessController implements EditTaxProcessControllerInterface {

    @Override
    public void loadTaxProcess(String idTaxpayer, JTextField txtProcessIdCalc, JTextField txtId, JButton btnAdd) {
        if (idTaxpayer.length() != 13) {
            JOptionPane.showMessageDialog(null, "El ID debe tener 13 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!idTaxpayer.endsWith("001")) {
            JOptionPane.showMessageDialog(null, "El ID debe terminar en '001'", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (MongoDBUtil.verificationIdTaxpayer(idTaxpayer)) {
            JOptionPane.showMessageDialog(null, "El contribuyente no existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            txtProcessIdCalc.setEnabled(true);
            txtId.setEnabled(true);
            btnAdd.setEnabled(true);
        }
    }

    @Override
    public void updateTaxProcess(String idTaxpayer, String processIdText, String id, JFrame parentFrame) {
        String nameCollection = idTaxpayer.trim() + "_process";
        if (!processIdText.isEmpty()) {
            int processId = Integer.parseInt(processIdText);
            PriceList selectedProcess = null;
            for (PriceList process : PricingSystemController.getPriceListArray()) {
                if (process.getProcessId() == processId) {
                    selectedProcess = process;
                    break;
                }
            }

            if (selectedProcess != null) {
                if (!MongoDBUtil.generalIdExists(nameCollection, id)) {
                    JOptionPane.showMessageDialog(parentFrame, "El ID general no existe. No se puede editar el proceso.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String nameProcess = selectedProcess.getProcessName();
                float priceProcess = selectedProcess.getPrice();
                float rateTax = selectedProcess.getTaxRate();

                MongoDBUtil.updateCollection(nameCollection, id, processId, nameProcess, priceProcess, rateTax);
                JOptionPane.showMessageDialog(parentFrame, "Datos actualizados en la nube.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Proceso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(parentFrame, "Complete los campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class TaxpayerDeleteController implements TaxpayerDeleteInterface {

    @Override
    public void cleanRow(JButton btnDelete, DefaultTableModel modelo) {
        btnDelete.setEnabled(false);
        if (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    @Override
    public void handleSearch(JTextField txtId, JButton btnDelete, DefaultTableModel modelo) {
        String id = txtId.getText();
        if (!utils.Validation.isIdValid(id)) {
            utils.Validation.showMessage(null, "El ID debe tener 13 dígitos y terminar en '001'", "Error", JOptionPane.ERROR_MESSAGE);
            cleanRow(btnDelete, modelo);
        } else if (utils.Validation.isTaxpayerExist(id)) {
            utils.Validation.showMessage(null, "El contribuyente no existe", "Error", JOptionPane.ERROR_MESSAGE);
            cleanRow(btnDelete, modelo);
        } else {
            cleanRow(btnDelete, modelo);
            String[] data = utils.MongoDBUtil.DeleteTaxPayer(id);
            addDataToModel(data, modelo);
            btnDelete.setEnabled(true);
        }
    }

    @Override
    public void addDataToModel(String[] data, DefaultTableModel modelo) {
        String[] info = new String[5];
        for (int i = 0; i < data.length - 1; i++) {
            info[i] = data[i];
        }
        modelo.addRow(info);
    }

    @Override
    public void handleDelete(JTextField txtId, JButton btnDelete, DefaultTableModel modelo) {
        String idTaxPayer = txtId.getText().trim();
        utils.MongoDBUtil.deleteDocumentById(idTaxPayer);
        if (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        btnDelete.setEnabled(false);
        utils.Validation.showMessage(null, "Contribuyente eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

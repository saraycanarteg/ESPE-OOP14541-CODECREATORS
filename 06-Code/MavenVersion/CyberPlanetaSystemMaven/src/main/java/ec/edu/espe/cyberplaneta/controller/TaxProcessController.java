package ec.edu.espe.cyberplaneta.controller;

import java.awt.Component;
import javax.swing.JOptionPane;
import utils.MongoDBUtil;
import utils.Validation;

/**
 *
 * @author Saray Cañarte
 */

public class TaxProcessController {

    public void verifyProcessDeletion(String processId, String nameCollection, Component parent) {
        int response = JOptionPane.showConfirmDialog(parent, "¿Está seguro de que desea eliminar el proceso?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            MongoDBUtil.deleteDocumentById(processId, nameCollection);
            Validation.showMessage(parent, "Proceso eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } 
    }
    
    public void validateTaxpayerExistence(String id, Component parent) {
        if (!Validation.isIdValid(id)) {
            Validation.showMessage(parent, "El ID debe tener 13 dígitos y terminar en '001'", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (Validation.isTaxpayerExist(id)) {
            Validation.showMessage(parent, "El contribuyente no existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            enableDeleteButton(true);
        }    
    }

    private void enableDeleteButton(boolean enable) {
    }
}


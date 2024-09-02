package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * @author Andres Cedeno, Code Creators, DCCO-ESPE
 */
public interface I_TaxProcessEdition {
    void loadTaxProcess(String idTaxpayer, JTextField txtProcessIdCalc, JTextField txtId, JButton btnAdd);
    void updateTaxProcess(String idTaxpayer, String processIdText, String id, JFrame parentFrame);
}

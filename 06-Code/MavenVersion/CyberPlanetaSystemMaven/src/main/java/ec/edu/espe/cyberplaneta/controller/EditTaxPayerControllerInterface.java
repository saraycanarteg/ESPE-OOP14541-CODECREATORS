/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public interface EditTaxPayerControllerInterface {
    void cargarTaxPayer(String id, JTextField txtEmail, JTextField txtNombre, JTextField txtContrasenia, JCheckBox chkDocumentacion, JDateChooser dateChooserStart, JDateChooser dateChooserEnd, JTextField txtCelular1);
    void saveTaxPayerChanges(String id, String email, String name, String password, boolean documentation, Date startDate, Date deliveryDate, String cellNumber);
}

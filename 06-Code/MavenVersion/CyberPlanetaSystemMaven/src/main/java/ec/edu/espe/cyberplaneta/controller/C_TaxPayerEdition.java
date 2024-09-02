/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.bson.Document;
import utils.MongoDBUtil;
import utils.Validation;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public class C_TaxPayerEdition implements I_TaxPayerEdition {

    @Override
    public void loadTaxPayer(String id, JTextField txtEmail, JTextField txtNombre, JTextField txtContrasenia, JCheckBox chkDocumentacion, JDateChooser dateChooserStart, JDateChooser dateChooserEnd, JTextField txtCelular1) {
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID.");
            return;
        }

        Document taxPayer = MongoDBUtil.getTaxPayerById(id);
        if (taxPayer != null) {
            txtEmail.setText(taxPayer.getString("email"));
            txtNombre.setText(taxPayer.getString("name"));
            txtContrasenia.setText(utils.EncryptData.decryptData(taxPayer.getString("password")));
            chkDocumentacion.setSelected(taxPayer.getBoolean("accountingDocumentation"));
            dateChooserStart.setDate(parseDate(taxPayer.getString("startDate")));
            dateChooserEnd.setDate(parseDate(taxPayer.getString("deliveryDate")));
            txtCelular1.setText(taxPayer.getString("cellNumber"));
        } else {
            JOptionPane.showMessageDialog(null, "Contribuyente no encontrado.");
        }
    }

    @Override
    public void saveTaxPayerChanges(String id, String email, String name, String password, boolean documentation, Date startDate, Date deliveryDate, String cellNumber) {
        if (!Validation.isIdValid(id)) {
            JOptionPane.showMessageDialog(null, "ID (RUC) inválido. Debe contener 13 dígitos numéricos.");
            return;
        }

        if (!Validation.validateName(name)) {
            JOptionPane.showMessageDialog(null, "Nombre inválido. No debe contener números ni caracteres especiales.");
            return;
        }

        if (!Validation.validateEmail(email)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico inválido.");
            return;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.");
            return;
        }

        if (startDate == null || deliveryDate == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione las fechas de inicio y entrega.");
            return;
        }

        if (startDate.after(deliveryDate)) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser posterior a la fecha de entrega.");
            return;
        }

        if (cellNumber.isEmpty() || cellNumber.length() != 10 || !cellNumber.startsWith("09")) {
            JOptionPane.showMessageDialog(null, "Información de celular incorrecta.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDateString = sdf.format(startDate);
        String deliveryDateString = sdf.format(deliveryDate);

        Document updatedTaxPayer = new Document("id", id)
                .append("email", email)
                .append("name", name)
                .append("password", utils.EncryptData.encriptionData(password))
                .append("accountingDocumentation", documentation)
                .append("startDate", startDateString)
                .append("deliveryDate", deliveryDateString)
                .append("cellNumber", cellNumber);

        MongoDBUtil.updateTaxPayer(updatedTaxPayer);
        JOptionPane.showMessageDialog(null, "Contribuyente actualizado correctamente.");
    }

    private java.util.Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    private String formatDate(java.util.Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import static ec.edu.espe.cyberplaneta.controller.TaxPayerController.isRucExist;
import static ec.edu.espe.cyberplaneta.controller.TaxPayerController.saveTaxPayerToDatabase;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import utils.EncryptData;
import utils.Validation;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public class AddTaxPayerController implements AddTaxPayerControllerInterface {

    @Override
    public void saveTaxPayer(String id, String email, String name, String password, boolean documentation, String initDateStr, String finishDateStr, String cellNumber) {
        // Validaciones
        if (!Validation.isIdValid(id)) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un RUC válido (13 dígitos numéricos que terminen en 001).");
            return;
        }

        // Validar si el RUC ya existe en la base de datos
        if (isRucExist(id)) {
            JOptionPane.showMessageDialog(null, "El RUC ya existe en la base de datos.");
            return;
        }

        if (email.isEmpty() || !Validation.validateEmail(email)) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un correo electrónico válido.");
            return;
        }

        if (name.isEmpty() || !Validation.isValidName(name)) {
            JOptionPane.showMessageDialog(null, "El nombre no puede tener números ni caracteres especiales.");
            return;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Contraseña no puede estar vacío.");
            return;
        }

        if (!Validation.isValidCellNumber(cellNumber)) {
            JOptionPane.showMessageDialog(null, "Información de celular incorrecta.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date initDate, finishDate;
        try {
            initDate = sdf.parse(initDateStr);
            finishDate = sdf.parse(finishDateStr);

            LocalDate localDate = LocalDate.now();
            Date currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            if (initDate.before(currentDate)) {
                JOptionPane.showMessageDialog(null, "La fecha inicial no puede ser menor a la fecha de hoy.");
                return;
            }

            if (finishDate.before(initDate)) {
                JOptionPane.showMessageDialog(null, "La fecha final no puede ser anterior a la fecha inicial.");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione fechas válidas.");
            return;
        }

        // Crear el objeto TaxPayer y guardar en la base de datos
        TaxPayer taxpayer = new TaxPayer(id, email, name, EncryptData.encriptionData(password), documentation, initDateStr, finishDateStr, cellNumber);

        try {
            saveTaxPayerToDatabase(taxpayer);
            JOptionPane.showMessageDialog(null, "Contribuyente guardado exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el contribuyente: " + e.getMessage());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import utils.MongoDBUtil;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public class C_9thDigitSearchMotor implements I_9thDigitSearchMotor {

    @Override
    public void loadTaxPayersByNinthDigit(String ninthDigit, DefaultTableModel model) {
        model.setRowCount(0);  // Limpia el modelo de la tabla antes de agregar nuevos datos
        List<Document> documents = MongoDBUtil.getAllTaxPayers();

        for (Document doc : documents) {
            String id = doc.getString("id");
            if (id != null && id.length() >= 9 && id.charAt(8) == ninthDigit.charAt(0)) {
                String email = doc.getString("email");
                String name = doc.getString("name");
                String password = doc.getString("password");
                boolean documentation = doc.getBoolean("accountingDocumentation");
                String celNumber = doc.getString("cellNumber");

                model.addRow(new Object[]{
                    id,
                    email,
                    name,
                    utils.EncryptData.decryptData(password),
                    documentation ? "Sí" : "No",
                    celNumber
                });
            }
        }
    }
}

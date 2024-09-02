
package ec.edu.espe.cyberplaneta.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class C_NotificationHandle implements I_NotificationHandle{
   
    @Override
    public String displayNotification(String nameTaxpayer, String deliveryDate, long remainingDays) {
        String msm = null;
        if (remainingDays > 0) {
            msm = "Tienes " + remainingDays + " días para la entrega";
        } else if (remainingDays == 0) {
            msm = "El proceso se entrega hoy";
        } else {
            msm = "El proceso ha sido entregado o está retrasado en su entrega";
        }
        return msm;
    }

    @Override
    public long getDaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    @Override
    public void controlNotification(String id, JLabel txtNotification, DefaultTableModel modelo) {
        if (!utils.Validation.isIdValid(id)) {
            utils.Validation.showMessage(null, "El ID debe terminar en '001' y tener 13 digitos", "Error", JOptionPane.ERROR_MESSAGE);
            cleanRow(txtNotification, modelo);
        } else if (utils.MongoDBUtil.verificationIdTaxpayer(id)) {
            utils.Validation.showMessage(null, "El contribuyente no existe", "Error", JOptionPane.ERROR_MESSAGE);
            cleanRow(txtNotification, modelo);
        } else {
            processTaxpayerData(id, txtNotification, modelo);
        }
    }

    @Override
    public void cleanRow(JLabel txtNotification, DefaultTableModel modelo) {
        txtNotification.setText(null);
        if (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    @Override
    public void processTaxpayerData(String id, JLabel txtNotification, DefaultTableModel modelo) {
        cleanRow(txtNotification, modelo);
        String[] data = utils.MongoDBUtil.notificaionTaxPayer(id);
        String[] info = new String[6];
        System.arraycopy(data, 0, info, 0, data.length - 1);
        modelo.addRow(info);
        txtNotification.setText(data[6]);
    }

}

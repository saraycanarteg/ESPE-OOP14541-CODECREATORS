/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public interface I_NotificationHandle {
    String displayNotification(String nameTaxpayer, String deliveryDate, long remainingDays);
    long getDaysBetweenDates(LocalDate startDate, LocalDate endDate);
    void controlNotification(String id, JLabel txtNotification, DefaultTableModel modelo);
    void cleanRow(JLabel txtNotification, DefaultTableModel modelo);
    void processTaxpayerData(String id, JLabel txtNotification, DefaultTableModel modelo);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class NotificationControl {
    public static String displayNotification(String nameTaxpayer, String deliveryDate, long remainingDays) {
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
    public static long getDaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    
}

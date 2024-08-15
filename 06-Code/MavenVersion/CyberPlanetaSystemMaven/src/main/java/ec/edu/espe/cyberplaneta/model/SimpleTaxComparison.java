/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.model;

/**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE
 */
public class SimpleTaxComparison implements TaxComparison {
   @Override
    public String compare(double valueMonth1, double valueMonth2) {
        if (valueMonth1 > valueMonth2) {
            double difference = valueMonth1 - valueMonth2;
            return "Primer mes ingresado es mayor a segundo mes ingresado por: $ " + difference;
        } else if (valueMonth2 > valueMonth1) {
            double difference = valueMonth2 - valueMonth1;
            return "Segundo mes ingresado es mayor a primer mes ingresado: $ " + difference;
        } else {
            return "No existe diferencia";
        }
    } 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.model;

/**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE */
public class CompareTwoMonthsTax {

    private double primerMes;
    private double segundoMes;

    public CompareTwoMonthsTax(double primerMes, double segundoMes) {
        this.primerMes = primerMes;
        this.segundoMes = segundoMes;
    }

    public String comparar() {
        if (primerMes > segundoMes) {
            return "El primer mes es mayor.";
        } else if (primerMes < segundoMes) {
            return "El segundo mes es mayor.";
        } else {
            return "Ambos meses son iguales.";
        }
    }
}



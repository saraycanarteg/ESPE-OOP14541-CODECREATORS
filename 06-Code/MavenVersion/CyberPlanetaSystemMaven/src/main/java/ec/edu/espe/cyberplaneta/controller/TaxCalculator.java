/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.controller.TaxesAverageController.InvalidInputException;

/**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE
 */
public interface TaxCalculator {
    double calculateAverage(String[] values) throws 
TaxesAverageController.InvalidInputException;
}

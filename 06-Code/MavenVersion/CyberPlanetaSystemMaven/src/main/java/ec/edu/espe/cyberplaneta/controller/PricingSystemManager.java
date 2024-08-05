package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import utils.MongoDBUtil;

/**
 *
 * @author Saray Cañarte, Code Creators, DCCO-ESPE
 */
public class PricingSystemManager {
    //PRICING SYSTEM CONTROLLER
    public static PriceList[] getPriceListArray() {
        return new PriceList[]{
            new PriceList(1,1, "Declaración de IVA en 0", 5.0f, 15f),
            new PriceList(1,2, "Declaración de IVA mensual", 20.0f, 15f),
            new PriceList(1,3, "Declaración de IVA semestral", 50.0f, 15f),
            new PriceList(1,4, "Devolución Impuesto a la Renta", 3.5f, 15f),
            new PriceList(1,5, "Anexo de Accionista", 5.0f, 15f)
        };
    }
    public boolean isProcessIdAvailable(int id) {
        PriceList[] priceList = getPriceListArray();
        for (PriceList item : priceList) {
            if (item.getProcessId() == id) {
                return true;
            }
        }
        return false;
    }
    public static float calculateTotalPrice(PriceList selectedProcess, float numDocumentation) {
        float basePrice = calculateBasePrice(selectedProcess, numDocumentation);
        float tax = calculateTax(basePrice, selectedProcess.getTaxRate());
        return basePrice + tax;
    }

    public static float calculateBasePrice(PriceList selectedProcess, float numDocumentation) {
        float additionalCost = ((numDocumentation / 10) * 0.50f);
        float basePrice = selectedProcess.getPrice();
        return basePrice + additionalCost;
    }

    public static float calculateTax(float basePrice, float taxRate) {
        return basePrice * (taxRate / 100);
    }

    //INCOMES CONTROLLER
    public static void saveTaxProcessToDatabase(PriceList selectedProcess, float totalPrice, int numberOfDocumentation) {
        TaxProcess taxProcess = new TaxProcess(selectedProcess, totalPrice);
        MongoDBUtil.saveTaxProcess(taxProcess, numberOfDocumentation);
    }
    
    //CAGR CONTROLLER
    public static double calculateCAGR(double initialValue, double finalValue, int numYears) {
        double cagr = Math.pow((finalValue / initialValue), (1.0 / (numYears))) - 1;
        return cagr * 100;
    }
    public static boolean isValidValue(double value) {
        double epsilon = 0.01;
        return Math.abs(Math.round(value * 100) - value * 100) < epsilon;
    }
    public static double calculateFutureValue(double finalValue, double cagr, int numYears) {
        double futureValue = finalValue * Math.pow(1 + (cagr/100), numYears);
        return futureValue;
    }
}


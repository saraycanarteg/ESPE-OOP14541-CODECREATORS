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
            new PriceList(1, "Declaración de IVA en 0", 5.0f, 15f),
            new PriceList(2, "Declaración de IVA mensual", 20.0f, 15f),
            new PriceList(3, "Declaración de IVA semestral", 50.0f, 15f),
            new PriceList(4, "Devolución Impuesto a la Renta", 3.5f, 15f),
            new PriceList(5, "Anexo de Accionista", 5.0f, 15f)
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
        float additionalCost = ((numDocumentation / 10) * 0.50f);
        float basePrice = selectedProcess.getPrice();
        float totalPriceWithoutTax = basePrice + additionalCost;
        float tax = (totalPriceWithoutTax * (selectedProcess.getTaxRate() / 100));
        return totalPriceWithoutTax + tax;
    }
    
    //INCOMES CONTROLLER
    public static void saveTaxProcessToDatabase(PriceList selectedProcess, float totalPrice, int numberOfDocumentation) {
        TaxProcess taxProcess = new TaxProcess(selectedProcess, totalPrice);
        MongoDBUtil.saveTaxProcess(taxProcess, numberOfDocumentation);
    }
    
    //CAGR CONTROLLER
    public static double calculateCAGR(double initialValue, double finalValue, int numYears) {
        double cagr = Math.pow((finalValue / initialValue), (1.0 / (numYears-1))) - 1;
        return cagr * 100;
    }
    public static boolean isValidValue(double value) {
        double epsilon = 0.01;
        return Math.abs(Math.round(value * 100) - value * 100) < epsilon;
    }
    public static double calculateFutureValue(double initialValue, double cagr, int numYears) {
        double futureValue = initialValue * Math.pow(1 + (cagr/100), numYears);
        return futureValue;
    }
}


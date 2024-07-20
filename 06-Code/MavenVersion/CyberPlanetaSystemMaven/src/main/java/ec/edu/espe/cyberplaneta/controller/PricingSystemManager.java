package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import utils.MongoDBUtil;

/**
 *
 * @author Saray
 */
public class PricingSystemManager {
    
    public static PriceList[] getPriceListArray() {
        return new PriceList[]{
            new PriceList(1, "Declaracion de IVA en 0", 5.0f, 15f),
            new PriceList(2, "Declaracion de IVA mensual", 20.0f, 15f),
            new PriceList(3, "Declaracion de IVA semestral", 50.0f, 15f),
            new PriceList(4, "Devolucion Impuesto a la Renta", 3.5f, 15f),
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
    
    public static void saveTaxProcessToDatabase(PriceList selectedProcess, float totalPrice, int numberOfDocumentation) {
        TaxProcess taxProcess = new TaxProcess(selectedProcess, totalPrice);
        MongoDBUtil.saveTaxProcess(taxProcess, numberOfDocumentation);
    }
}


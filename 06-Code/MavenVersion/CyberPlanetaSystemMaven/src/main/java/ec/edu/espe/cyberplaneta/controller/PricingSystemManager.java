package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;

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
}


package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import utils.MongoDBUtil;

/**
 *
 * @author Saray Cañarte
 */
public class IncomeController {

    //INCOMES CONTROLLER
    public static void saveTaxProcessToDatabase(PriceList selectedProcess, float totalPrice, int numberOfDocumentation) {
        TaxProcess taxProcess = new TaxProcess(selectedProcess, totalPrice);
        MongoDBUtil.saveTaxProcess(taxProcess, numberOfDocumentation);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import utils.MongoDBUtil;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public class TaxPayerManager {
    public static void saveTaxPayerToDatabase(TaxPayer taxPayer) {
        MongoDBUtil.saveTaxPayer(taxPayer);
}
}


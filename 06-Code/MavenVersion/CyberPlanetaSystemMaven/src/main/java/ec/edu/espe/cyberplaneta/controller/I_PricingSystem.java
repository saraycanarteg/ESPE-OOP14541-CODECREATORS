package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import javax.swing.JTextField;

/**
 *
 * @author Saray Cañarte
 */
public interface I_PricingSystem {
    
     boolean validatePriceId(JTextField textField);
     float calculateTotalPrice(PriceList selectedProcess, float numDocumentation);
     float calculateBasePrice(PriceList selectedProcess, float numDocumentation);
     float calculateTax(float basePrice, float taxRate);
     
}

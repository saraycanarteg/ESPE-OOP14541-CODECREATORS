package utils;

import ec.edu.espe.cyberplaneta.model.PriceList;
import java.util.Scanner;

/**
 * 
 * @autor Code Creators, DCCO-ESPE
 */
public class CPPricingSystem {
    

    public static void CalculateTaxProcessCost() {
         
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%40s\n", "===============================================");
        System.out.printf("%40s\n", "Sistema de Precios Cyber Planeta");
        System.out.printf("%40s\n", "===============================================");

        PriceList.displayPriceArray();

        System.out.println("Ingrese ID del proceso a calcular precio: ");
        int id = scanner.nextInt();

       
        PriceList[] priceList = PriceList.getPriceListArray();

       
        PriceList selectedProcess = null;
        for (PriceList item : priceList) {
            if (item.getProcessId() == id) {
                selectedProcess = item;
                break;
            }
        }

        if (selectedProcess == null) {
            System.out.println("ID no encontrado. Por favor, intente de nuevo.");
            return;
        }

       
        System.out.println("Ingrese cantidad de documentacion: ");
        int numDocumentation = scanner.nextInt();

        float additionalCost = (numDocumentation / 50) * 0.50f;

      
        float basePrice = selectedProcess.getPrice();
        float totalPriceWithoutTax = basePrice + additionalCost;
        float tax = totalPriceWithoutTax * 0.15f;
        float totalPrice = totalPriceWithoutTax + tax;

       
        System.out.printf("El costo del proceso '%s' con ID %d es de $%.2f%n",
                selectedProcess.getProcessName(), id, totalPrice);
       
    }

  
}


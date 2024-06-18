package utils;

import ec.edu.espe.cyberplaneta.model.PriceList;
import java.util.Scanner;
import java.util.InputMismatchException;

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

        PriceList selectedProcess = null;
        int id = -1;

        while (selectedProcess == null) {
            while (id < 1) {
                try {
                    System.out.println("Ingrese ID del proceso a calcular precio: ");
                    id = scanner.nextInt();
                    if (id < 1) {
                        System.out.println("Opcion invalida, ingrese un numero del 1-5.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opcion invalida, ingrese un numero del 1-5.");
                    scanner.next(); // Clear invalid input
                }
            }

            PriceList[] priceList = PriceList.getPriceListArray();

            for (PriceList item : priceList) {
                if (item.getProcessId() == id) {
                    selectedProcess = item;
                    break;
                }
            }

            if (selectedProcess == null) {
                System.out.println("ID no encontrado. Por favor, intente de nuevo.");
                id = -1; 
            }
        }

        int numDocumentation = -1;
        while (numDocumentation < 0) {
            try {
                System.out.println("Ingrese cantidad de documentacion: ");
                numDocumentation = scanner.nextInt();
                if (numDocumentation < 0) {
                    System.out.println("Opcion invalida, la cantidad de documentacion debe ser un entero positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcion invalida, la cantidad de documentacion debe ser un entero positivo.");
                scanner.next(); 
            }
        }

        float additionalCost = (numDocumentation / 10) * 0.50f;

        float basePrice = selectedProcess.getPrice();
        float totalPriceWithoutTax = basePrice + additionalCost;
        float tax = totalPriceWithoutTax * 0.15f;
        float totalPrice = totalPriceWithoutTax + tax;

        System.out.printf("El costo del proceso '%s' con ID %d es de $%.2f%n",
                selectedProcess.getProcessName(), id, totalPrice);

    }

}


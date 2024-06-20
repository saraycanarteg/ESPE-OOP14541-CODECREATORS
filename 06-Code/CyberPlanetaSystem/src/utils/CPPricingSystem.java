package utils;

import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class CPPricingSystem {

    private static List<TaxProcess> processedItems = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String JSON_FILE = "Incomes";

    public static void printCPPricingSystemMenu() {

        loadProcessedItemsFromJson();
        int option = 0;
        while (true) {
            System.out.printf("%40s\n", "===============================================");
            System.out.printf("%40s\n", "Sistema de Precios Cyber Planeta");
            System.out.printf("%40s\n", "===============================================");
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Calcular costo de un proceso");
            System.out.println("2. Revisar ingresos totales");
            System.out.println("3. Salir");
            System.out.printf("%40s\n", "===============================================");
            System.out.print("Opcion: ");

            try {
                option = scanner.nextInt();

                if (option < 1 || option > 3) {
                    ClearScreen.clearScreen();
                    System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                ClearScreen.clearScreen();
                System.out.println("Entrada invalida. Por favor, ingrese un número del 1 al 3.");
                scanner.next();
                continue;
            }
            ClearScreen.clearScreen();
            switch (option) {
                case 1:
                    verifyProcess();
                    break;
                case 2:
                    printProcessedItems();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void verifyProcess() {
        ClearScreen.clearScreen();
        int option = 0;
        while (true) {
            System.out.printf("%40s\n", "===============================================");
            System.out.println("1. Continuar con el calculo");
            System.out.println("2. Salir");
            System.out.printf("%40s\n", "===============================================");
            System.out.print("Opcion: ");
            try {
                option = scanner.nextInt();

                if (option < 1 || option > 2) {
                    ClearScreen.clearScreen();
                    System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                ClearScreen.clearScreen();
                System.out.println("Entrada invalida. Por favor, ingrese un número del 1 al 2.");
                scanner.next();
                continue;
            }
            ClearScreen.clearScreen();
            switch (option) {
                case 1:
                    calculateMultipleProcesses();
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción invalida. Intente nuevamente.");
            }
        }

    }

    public static void calculateMultipleProcesses() {
        ClearScreen.clearScreen();
        boolean continuar = true;
        while (continuar) {
            CalculateTaxProcessCost();

            String respuesta;
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            do {
                System.out.print("¿Desea calcular otro proceso? [si/no]: ");
                respuesta = scanner.nextLine().toLowerCase();
            } while (!respuesta.equals("si") && !respuesta.equals("no"));

            if (respuesta.equals("no")) {
                continuar = false;
            }
        }
    }

    public static void CalculateTaxProcessCost() {
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
                    scanner.next();
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

        TaxProcess processedItem = new TaxProcess(selectedProcess.getProcessId(), selectedProcess.getProcessName(), basePrice, tax, totalPrice);
        processedItems.add(processedItem);

        System.out.printf("El costo del proceso '%s' con ID %d es de $%.2f%n",
                selectedProcess.getProcessName(), id, totalPrice);

        // Convertir a JSON y guardar en archivo
        Gson gson = new Gson();
        String jsonData = gson.toJson(processedItem);
        DataBaseManager.SaveData(jsonData, JSON_FILE);
    }

    public static void printProcessedItems() {
        System.out.println("\nTabla de Ingresos:");

        System.out.println("====================================================================================================================");
        System.out.printf("%-5s %-50s %-25s %-20s %-20s\n", "ID", "Nombre del Proceso", "Precio Base ($)", "Impuesto (%)", "Total($)");
        System.out.println("====================================================================================================================");

        float totalIncome = 0;

        for (TaxProcess item : processedItems) {
            System.out.printf("%-5s %-50s %-25.2f %-20.2f %-20.2f\n",
                    item.getId(), item.getName(), item.getBasePrice(), item.getTax(), item.getTotal());
            totalIncome += item.getTotal();
        }

        System.out.printf("\nLos ingresos totales son: $%.2f\n", totalIncome);
    }

    private static void loadProcessedItemsFromJson() {
        List<String> jsonData = DataBaseManager.ReadData("Incomes.json", "");

        Gson gson = new Gson();
        Type type = new TypeToken<List<TaxProcess>>() {
        }.getType();
        processedItems = gson.fromJson(jsonData.toString(), type);
    }
}

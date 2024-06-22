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
import consoleutils.*;

public class CPPricingSystem {

    private static List<TaxProcess> processedItems = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String JSON_FILE = "Incomes";

    public static void printCPPricingSystemMenu() {
        loadProcessedItemsFromJson();
        boolean continueRunning = true;
        while (continueRunning) {
            printCPPricingSystemMenuOptions(1);
            int option = ConsoleHelper.getValidIntegerInput(1, 3, "Entrada invalida. Por favor, ingrese un número del 1 al 3.", "Opcion: ");
            ConsoleHelper.clearScreen();
            continueRunning = getMenuOptionSelected(1, option);
        }
    }

    private static void printverifyProcessMenu() {
        ConsoleHelper.clearScreen();
        boolean continueRunning = true;
        while (continueRunning) {
            printCPPricingSystemMenuOptions(2);
            int option = ConsoleHelper.getValidIntegerInput(1, 2, "Entrada invalida. Por favor, ingrese un número del 1 al 2.", "Opcion: ");
            ConsoleHelper.clearScreen();
            continueRunning = getMenuOptionSelected(2, option);
        }
    }

    private static void printCPPricingSystemMenuOptions(int typeOfMenu) {
        if (typeOfMenu == 1) {
            System.out.printf("%40s\n", "===============================================");
            System.out.printf("%40s\n", "Sistema de Precios Cyber Planeta");
            System.out.printf("%40s\n", "===============================================");
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Calcular costo de un proceso");
            System.out.println("2. Revisar ingresos totales");
            System.out.println("3. Salir");
            System.out.printf("%40s\n", "===============================================");
            System.out.print("Opcion: ");
        }

        if (typeOfMenu == 2) {
            System.out.printf("%40s\n", "===============================================");
            System.out.println("1. Continuar con el calculo");
            System.out.println("2. Salir");
            System.out.printf("%40s\n", "===============================================");
            System.out.print("Opcion: ");
        }
    }

    private static boolean getMenuOptionSelected(int typeOfMenuOption, int option) {
        if (typeOfMenuOption == 1) {
            switch (option) {
                case 1 -> printverifyProcessMenu();
                case 2 -> printProcessedItems();
                case 3 -> {
                    System.out.println("Saliendo...");
                    return false;
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        if (typeOfMenuOption == 2) {
            switch (option) {
                case 1 -> calculateMultipleProcesses();
                case 2 -> {
                    System.out.println("Saliendo...");
                    return false;
                }
                default -> System.out.println("Opción invalida. Intente nuevamente.");
            }
        }

        return true;
    }

    private static void calculateMultipleProcesses() {
        ConsoleHelper.clearScreen();
        boolean continuar = true;
        while (continuar) {
            calculateTaxProcessCost();
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

    private static void calculateTaxProcessCost() {
        PriceList.displayPriceArray();
        PriceList selectedProcess = validateProcessId();

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

        float totalPrice = calculateTotalPrice(selectedProcess, numDocumentation);
        saveProcessedItem(selectedProcess, totalPrice);
    }

    private static PriceList validateProcessId() {
        PriceList selectedProcess = null;

        while (selectedProcess == null) {
            System.out.println("ID del proceso: ");
            int id = ConsoleHelper.getValidIntegerInput(1, 5, "Entrada invalida. Por favor, ingrese un número del 1 al 5.", "ID del proceso: ");

            PriceList[] priceList = PriceList.getPriceListArray();
            for (PriceList item : priceList) {
                if (item.getProcessId() == id) {
                    selectedProcess = item;
                    break;
                }
            }

            if (selectedProcess == null) {
                System.out.println("ID no encontrado. Por favor, intente de nuevo.");
            }
        }

        return selectedProcess;
    }

    private static float calculateTotalPrice(PriceList selectedProcess, int numDocumentation) {
        float additionalCost = (numDocumentation / 10) * 0.50f;
        float basePrice = selectedProcess.getPrice();
        float totalPriceWithoutTax = basePrice + additionalCost;
        float tax = totalPriceWithoutTax * 0.15f;
        return totalPriceWithoutTax + tax;
    }

    private static void saveProcessedItem(PriceList selectedProcess, float totalPrice) {
        TaxProcess processedItem = new TaxProcess(selectedProcess.getProcessId(), selectedProcess.getProcessName(), selectedProcess.getPrice(), totalPrice * 0.15f, totalPrice);
        processedItems.add(processedItem);

        System.out.printf("El costo del proceso '%s' con ID %d es de $%.2f%n",
                selectedProcess.getProcessName(), selectedProcess.getProcessId(), totalPrice);

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

package utils;

import consoleutils.ConsoleHelper;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ClassificationAgenda {

    private static Scanner scanner = new Scanner(System.in);

        public static void printSystemAgendaMenu() {
        while (true) {
            System.out.println("============================================================================");
            System.out.printf("%40s\n", "Menu de Administrador de Agenda:");
            System.out.println("============================================================================");
            System.out.println("1. Mostrar los contribuyentes por el noveno digito");
            System.out.println("2. Mostrar notificaciones pendientes");
            System.out.println("3. Comparar impuestos de dos meses");
            System.out.println("4. Calcular promedio de impuestos mensuales");
            System.out.println("5. Salir");
            System.out.println("============================================================================");
            System.out.print("Opcion a escoger: ");
            int menuOption = ConsoleHelper.getValidIntegerInput(1, 5, "Entrada invalida. Por favor, ingrese un número del 1 al 5.", "Opcion a escoger: ");
            ConsoleHelper.clearScreen();
            switch(menuOption) {
                case 1 -> searchNinthDigit();
                case 2 -> sendNotification();
                case 3 -> compareMonthlyTaxes();
                case 4 -> calculateAverageMonthlyTaxes();
                case 5 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
            }
        }
    }

    public static void searchNinthDigit() {
        int ninthDigit = getValidNinthDigit();
        List<String> taxPayers = DataBaseManager.readData("TaxPayerData.json", ",");
        List<String> results = filterTaxPayersByNinthDigit(taxPayers, ninthDigit);
        displaySearchResults(results, ninthDigit);
    }

    private static int getValidNinthDigit() {
        while (true) {
            System.out.print("Ingrese el noveno digito para la busqueda: ");
            String input = scanner.nextLine();
            if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Entrada incorrecta. Por favor, ingrese un solo digito.");
            }
        }
    }

    private static List<String> filterTaxPayersByNinthDigit(List<String> taxPayers, int ninthDigit) {
        List<String> results = new ArrayList();
        for (String taxPayer : taxPayers) {
            try {
                String idPart = extractIdPart(taxPayer);
                if (isValidNinthDigit(idPart, ninthDigit)) {
                    results.add(taxPayer);
                }
            } catch (Exception e) {
                System.out.println("Error al procesar la linea: " + taxPayer);
                e.printStackTrace();
            }
        }
        return results;
    }

    private static String extractIdPart(String taxPayer) {
        return taxPayer.split(",")[0].split(":")[1].replace("\"", "").trim();
    }

    private static boolean isValidNinthDigit(String idPart, int ninthDigit) {
        return idPart.length() >= 9 && Character.getNumericValue(idPart.charAt(8)) == ninthDigit;
    }

    private static void displaySearchResults(List<String> results, int ninthDigit) {
        if (results.isEmpty()) {
            System.out.println("No se encontraron contribuyentes con el noveno digito " + ninthDigit);
        } else {
            System.out.println("Contribuyentes encontrados con el noveno digito " + ninthDigit + ":");
            printTable(results);
        }
    }

    private static void printTable(List<String> taxPayers) {
        String format = "| %-15s | %-20s | %-20s | %-15s | %-10s |%n";
        System.out.format("+-----------------+----------------------+----------------------+-----------------+------------+%n");
        System.out.format("| ID              | Email                | Nombre               | Contrasenia      | Documentos |%n");
        System.out.format("+-----------------+----------------------+----------------------+-----------------+------------+%n");
        for (String taxPayer : taxPayers) {
            try {
                String[] fields = taxPayer.split(",");
                String id = fields[0].split(":")[1].replace("\"", "").trim();
                String email = fields[1].split(":")[1].replace("\"", "").trim();
                String name = fields[2].split(":")[1].replace("\"", "").trim();
                String password = fields[3].split(":")[1].replace("\"", "").trim();
                String documentation = fields[4].split(":")[1].replace("\"", "").trim();
                System.out.format(format, id, email, name, password, documentation);
            } catch (Exception e) {
                System.out.println("Error al procesar la linea para la tabla: " + taxPayer);
                e.printStackTrace();
            }
        }
        System.out.format("+-----------------+----------------------+----------------------+-----------------+------------+%n");
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static void sendNotification() {
        String taxPayerId = getValidTaxpayerId();
        TaxPayer taxPayer = DataBaseManager.findTaxPayerById("TaxPayerData", taxPayerId);
        if (taxPayer == null) {
            System.out.println("\nEl contribuyente no existe\n");
            return;
        }
        Calendar calendar = DataBaseManager.findCalendarById("TaxPayerData", taxPayerId);
        LocalDate deliveryDate = LocalDate.parse(calendar.getDeliveryDate(), DATE_FORMATTER);
        long remainingDays = getDaysBetweenDates(LocalDate.now(), deliveryDate);
        displayNotification(taxPayer, calendar.getDeliveryDate(), remainingDays);
    }

    private static String getValidTaxpayerId() {
        String taxPayerId;
        do {
            System.out.print("Ingrese el ID del contribuyente a buscar: ");
            taxPayerId = scanner.next();
        } while (!isValidTaxPayerId(taxPayerId));
        return taxPayerId;
    }

    private static boolean isValidTaxPayerId(String taxPayerId) {
        return taxPayerId.length() == 13 && taxPayerId.matches("\\d+");
    }

    private static long getDaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    private static void displayNotification(TaxPayer taxPayer, String deliveryDate, long remainingDays) {
        if (remainingDays > 0) {
            System.out.println("\nLa fecha de entrega del proceso del contribuyente " + taxPayer.getName() + " es " + deliveryDate + ", tienes " + remainingDays + " días para la entrega\n");
        } else if (remainingDays == 0) {
            System.out.println("\nEl proceso se entrega hoy\n");
        } else {
            System.out.println("\nEl proceso ha sido entregado o está retrasado en su entrega\n");
        }
    }

    public static void compareMonthlyTaxes() {
        System.out.print("Ingrese el impuesto cobrado en el primer mes: ");
        double firstMonthTax = getValidDoubleInput();

        System.out.print("Ingrese el impuesto cobrado en el segundo mes: ");
        double secondMonthTax = getValidDoubleInput();

        double difference = calculateTaxDifference(firstMonthTax, secondMonthTax);
        System.out.printf("La diferencia de impuestos entre los dos meses es: $%.2f\n", difference);
    }

    private static double getValidDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida. Por favor, ingrese un numero valido: ");
            }
        }
    }

    private static double calculateTaxDifference(double firstMonthTax, double secondMonthTax) {
        return Math.abs(firstMonthTax - secondMonthTax);
    }
    
    public static void calculateAverageMonthlyTaxes() {
        System.out.print("Ingrese la cantidad de meses: ");
        int numberOfMonths = getValidIntegerInput();

        double totalTaxes = 0;
        for (int i = 1; i <= numberOfMonths; i++) {
            System.out.printf("Ingrese el impuesto cobrado en el mes %d: ", i);
            totalTaxes += getValidDoubleInput();
        }

        double average = calculateAverage(totalTaxes, numberOfMonths);
        System.out.printf("El promedio de impuestos pagados en %d meses es: $%.2f\n", numberOfMonths, average);
    }

    private static int getValidIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida. Por favor, ingrese un numero entero valido: ");
            }
        }
    }

    private static double calculateAverage(double total, int count) {
        return total / count;
    }

    
}

package utils;

import consoleutils.ConsoleHelper;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ClassificationAgenda {

    private static Scanner scanner = new Scanner(System.in);

    public static void printSystemAgendaMenu() {
        int menuOption = 0;
        while (true) {
            System.out.println("============================================================================");
            System.out.printf("%40s\n", "Menu de Administrador de Agenda:");
            System.out.println("============================================================================");
            System.out.println("1. Mostrar los contribuyentes por el noveno digito");
            System.out.println("2. Mostrar notificaciones pendientes");
            System.out.println("3. Salir");
            System.out.println("============================================================================");
            System.out.print("Opcion a escoger: ");
            try {
                menuOption = scanner.nextInt();
                scanner.nextLine();
                if (menuOption < 1 || menuOption > 3) {
                    ConsoleHelper.clearScreen();
                    System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                ConsoleHelper.clearScreen();
                System.out.println("Entrada invalida. Por favor, ingrese un número del 1 al 3.");
                scanner.next();
                continue;
            }
            ConsoleHelper.clearScreen();
            switch(menuOption) {
                case 1:
                    searchNinthDigit();
                    break;
                case 2:
                    sendNotification();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
            }
        }
    }

    public static void searchNinthDigit() {
        int ninthDigit = getValidNinthDigit();
        List<String> taxpayers = DataBaseManager.ReadData("TaxPayerData.json", ",");
        List<String> results = filterTaxpayersByNinthDigit(taxpayers, ninthDigit);
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

    private static List<String> filterTaxpayersByNinthDigit(List<String> taxpayers, int ninthDigit) {
        List<String> results = new ArrayList();
        for (String taxpayer : taxpayers) {
            try {
                String idPart = extractIdPart(taxpayer);
                if (isValidNinthDigit(idPart, ninthDigit)) {
                    results.add(taxpayer);
                }
            } catch (Exception e) {
                System.out.println("Error al procesar la linea: " + taxpayer);
                e.printStackTrace();
            }
        }
        return results;
    }

    private static String extractIdPart(String taxpayer) {
        return taxpayer.split(",")[0].split(":")[1].replace("\"", "").trim();
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

    private static void printTable(List<String> taxpayers) {
        String format = "| %-15s | %-20s | %-20s | %-15s | %-10s |%n";
        System.out.format("+-----------------+----------------------+----------------------+-----------------+------------+%n");
        System.out.format("| ID              | Email                | Nombre               | Contrasenia      | Documentos |%n");
        System.out.format("+-----------------+----------------------+----------------------+-----------------+------------+%n");
        for (String taxpayer : taxpayers) {
            try {
                String[] fields = taxpayer.split(",");
                String id = fields[0].split(":")[1].replace("\"", "").trim();
                String email = fields[1].split(":")[1].replace("\"", "").trim();
                String name = fields[2].split(":")[1].replace("\"", "").trim();
                String password = fields[3].split(":")[1].replace("\"", "").trim();
                String documentation = fields[4].split(":")[1].replace("\"", "").trim();
                System.out.format(format, id, email, name, password, documentation);
            } catch (Exception e) {
                System.out.println("Error al procesar la linea para la tabla: " + taxpayer);
                e.printStackTrace();
            }
        }
        System.out.format("+-----------------+----------------------+----------------------+-----------------+------------+%n");
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static void sendNotification() {
        String taxpayerId = getValidTaxpayerId();
        TaxPayer taxpayer = DataBaseManager.findTaxPayerById("TaxPayerData", taxpayerId);
        if (taxpayer == null) {
            System.out.println("\nEl contribuyente no existe\n");
            return;
        }
        Calendar calendar = DataBaseManager.findCalendarById("TaxPayerData", taxpayerId);
        LocalDate deliveryDate = LocalDate.parse(calendar.getDeliveryDate(), DATE_FORMATTER);
        long remainingDays = getDaysBetweenDates(LocalDate.now(), deliveryDate);
        displayNotification(taxpayer, calendar.getDeliveryDate(), remainingDays);
    }

    private static String getValidTaxpayerId() {
        String taxpayerId;
        do {
            System.out.print("Ingrese el ID del contribuyente a buscar: ");
            taxpayerId = scanner.next();
        } while (!isValidTaxpayerId(taxpayerId));
        return taxpayerId;
    }

    private static boolean isValidTaxpayerId(String taxpayerId) {
        return taxpayerId.length() == 13 && taxpayerId.matches("\\d+");
    }

    private static long getDaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    private static void displayNotification(TaxPayer taxpayer, String deliveryDate, long remainingDays) {
        if (remainingDays > 0) {
            System.out.println("\nLa fecha de entrega del proceso del contribuyente " + taxpayer.getName() + " es " + deliveryDate + ", tienes " + remainingDays + " días para la entrega\n");
        } else if (remainingDays == 0) {
            System.out.println("\nEl proceso se entrega hoy\n");
        } else {
            System.out.println("\nEl proceso ha sido entregado o está retrasado en su entrega\n");
        }
    }

    public static void searchNinethDigit() {
    }

    private static void searchByNinthDigit(String fileName, int ninthDigit) {
    }
}

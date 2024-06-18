package utils;

import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class ClassificationAgenda {

    public static void printSystemAgendaMenu() {
        Scanner scanner = new Scanner(System.in);
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

                if (menuOption < 1 || menuOption > 3) {
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
            switch (menuOption) {
                case 1:
                    searchNinethDigit();
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

    public static void searchNinethDigit() {
        Scanner scanner = new Scanner(System.in);
        int ninthDigit = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Ingrese el noveno digito para la busqueda: ");
            String input = scanner.nextLine(); 

            if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
                ninthDigit = Integer.parseInt(input); 
                validInput = true;
            } else {
                System.out.println("Entrada incorrecta. Por favor, ingrese un solo digito.");
            }
        }

        searchByNinthDigit("TaxPayerData", ninthDigit);
    }

    private static void searchByNinthDigit(String fileName, int ninthDigit) {
        String separator = ",";
        List<String> taxpayers = DataBaseManager.ReadData(fileName + ".json", separator);

        List<String> resultados = new ArrayList<>();
        for (String taxpayer : taxpayers) {
            try {

                String idPart = taxpayer.split(",")[0].split(":")[1].replace("\"", "").trim();

                if (idPart.length() >= 9 && Character.getNumericValue(idPart.charAt(8)) == ninthDigit) {
                    resultados.add(taxpayer);
                }
            } catch (Exception e) {
                System.out.println("Error no se encontro el archivo");
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron contribuyentes con el noveno digito " + ninthDigit);
        } else {
            System.out.println("Contribuyentes encontrados con el noveno digito " + ninthDigit + ":");
            for (String resultado : resultados) {
                System.out.println(resultado);
            }
        }
    }

    private static void sendNotification() {
        Scanner scanner = new Scanner(System.in);
        String idTaxPayer = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.now();

        do {
            System.out.print("Ingrese el ID del contribuyente a buscar: ");
            idTaxPayer = scanner.next();
        } while (idTaxPayer.length() != 13);

        TaxPayer taxPayer = DataBaseManager.findTaxPayerById("TaxPayerData", idTaxPayer);
        if (taxPayer == null) {
            System.out.println("\nEl contribuyente no existe\n");
            return;
        }
        Calendar calendar = DataBaseManager.findCalendarById("TaxPayerData", idTaxPayer);

        LocalDate userDate = LocalDate.parse(calendar.getDeliveryDate(), formatter);
        long remainingDays = ChronoUnit.DAYS.between(currentDate, userDate);

        if (remainingDays > 0) {
            System.out.println("\nLa fecha de entrega del proceso del contibuyente " + taxPayer.getName() + " es " + calendar.getDeliveryDate()
                    + ", tienes " + remainingDays + " dias para la entrega\n");
        } else {
            if (remainingDays == 0) {
                System.out.println("\nEl proceso se entrega hoy\n");
            } else {
                System.out.println("\nEl proceso ha sido entregado o esta retrasado en su entrega\n");
            }
        }
    }
}

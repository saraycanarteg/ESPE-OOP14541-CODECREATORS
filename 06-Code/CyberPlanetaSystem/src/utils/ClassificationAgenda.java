
package utils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class ClassificationAgenda {

    public static void printSystemAgendaMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("============================================================================");
            System.out.printf("%40s\n", "Menu de Administrador de Agenda:");
            System.out.println("============================================================================");
            System.out.println("1. Mostrar los contribuyentes por el noveno digito");
            System.out.println("2. Mostrar notificaciones pendientes");
            System.out.println("3. salir de Menu de Administrador de Agenda");
            System.out.println("============================================================================");
            System.out.print("Opcion a escoger: ");
            int menuOption = scanner.nextInt();
            ClearScreen.clearScreen();

            switch (menuOption) {
                case 1:
                    searchNinethDigit();
                    break;
                case 2:
                    // editTaxPayer();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");

            }

        }
    }

    public static void searchNinethDigit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el noveno digito para la busqueda: ");
        int novenoDigito = scanner.nextInt();

        searchByNinthDigit("TaxPayerData", novenoDigito);
    }

    private static void searchByNinthDigit(String fileName, int novenoDigito) {
        String separator = ",";
        List<String> taxpayers = DataBaseManager.ReadData(fileName + ".json", separator);

        List<String> resultados = new ArrayList<>();
        for (String taxpayer : taxpayers) {
            try {

                String idPart = taxpayer.split(",")[0].split(":")[1].replace("\"", "").trim();

                if (idPart.length() >= 9 && Character.getNumericValue(idPart.charAt(8)) == novenoDigito) {
                    resultados.add(taxpayer);
                }
            } catch (Exception e) {
                System.out.println("Error al procesar la línea: " + taxpayer);
                e.printStackTrace();
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron contribuyentes con el noveno digito " + novenoDigito);
        } else {
            System.out.println("Contribuyentes encontrados con el noveno digito " + novenoDigito + ":");
            for (String resultado : resultados) {
                System.out.println(resultado);
            }
        }
    }
}

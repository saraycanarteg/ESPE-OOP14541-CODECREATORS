
package utils;

import java.util.Scanner;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class ClassificationAgenda {

    public static void printSystemAgendaMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================================");
        System.out.printf("%40s\n", "Menu de Administrador de Agenda:");
        System.out.println("============================================================================");
        System.out.println("1. Mostrar todos los contribuyentes por el noveno digito");
        System.out.println("2. Mostrar notificaciones pendientes");
        System.out.println("============================================================================");
        System.out.print("Opcion a escoger: ");
        int menuOption = scanner.nextInt();

        switch (menuOption) {
            case 1:
                searchNinethDigit();
                break;
            case 2:
                //editTaxPayer();
                break;
            default:
                System.out.println("Invalid option. Please try again.");

        }

    }

    public static void searchNinethDigit() {

    }
}

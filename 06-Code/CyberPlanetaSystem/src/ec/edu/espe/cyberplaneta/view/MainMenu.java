package ec.edu.espe.cyberplaneta.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import utils.SystemAdministrator;
import utils.CPPricingSystem;
import utils.ClassificationAgenda;
import utils.ClearScreen;

/**
 *
 * @author Code Creators
 */
public class MainMenu {

    public static void main(String[] args) {
        ClearScreen.clearScreen();
        showMainMenu();
    }

    private static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int menuOption = 0;
        while (true) {
            System.out.printf("%40s\n", "===============================================");
            System.out.printf("%40s\n", "Cyber Planeta System v.0.2.3");
            System.out.printf("%40s\n", "===============================================");
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Contribuyente");
            System.out.println("2. Agenda de clasificacion");
            System.out.println("3. Sistema de precios");
            System.out.println("4. Salir");
            System.out.printf("%40s\n", "===============================================");
            System.out.println("Opcion:  ");

            try {
                menuOption = scanner.nextInt();

                if (menuOption < 1 || menuOption > 4) {
                    ClearScreen.clearScreen();
                    System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                ClearScreen.clearScreen();
                System.out.println("Entrada invalida. Por favor, ingrese un número del 1 al 4.");
                scanner.next();
                continue;
            }
                ClearScreen.clearScreen();
                switch (menuOption) {
                    case 1:
                        SystemAdministrator.printSystemAdminMenu();
                        break;

                    case 2:
                        ClassificationAgenda.printSystemAgendaMenu();
                        break;

                    case 3:
                        CPPricingSystem.printCPPricingSystemMenu();
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                        break;
                }

        }
    }
}

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
        while (!authenticateUser()) {
            ClearScreen.clearScreen();
            System.out.println("Usuario o contrasenia incorrectos. Por favor, intente de nuevo.");
        }
        showMainMenu();
    }
    
    private static boolean authenticateUser() {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        
        do {
                System.out.println("Ingrese su nombre de usuario (sin numeros):");
                username = scanner.nextLine();
            } while (!username.matches("[a-zA-Z\\s]+"));
        System.out.println("Ingrese su contrasenia:");
        password = scanner.nextLine();

        String correctUsername = "Guillermo Canarte";
        String correctPassword = "1214";

        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    private static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int menuOption = 0;
        ClearScreen.clearScreen();
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
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                        break;
                }

        }
    }
}

package ec.edu.espe.cyberplaneta.view;

import java.util.Scanner;
import utils.SystemAdministrator;
import utils.CPPricingSystem;
import utils.ClassificationAgenda;
import consoleutils.*;

public class MainMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleHelper.clearScreen();
        while (!authenticateUser()) {
            ConsoleHelper.clearScreen();
            System.out.println("Usuario o contrasenia incorrectos. Por favor, intente de nuevo.");
        }
        showMainMenu();
    }

    private static boolean authenticateUser() {
        String username;
        String password;
        do {
            System.out.println("Ingrese su nombre de usuario (sin numeros):");
            username = scanner.nextLine();
        } while (!username.matches("[a-zA-Z\\s]+"));
        System.out.println("Ingrese su contrasenia:");
        password = scanner.nextLine();
        String correctUsername = "scurpin";
        String correctPassword = "1214";
        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    private static void showMainMenu() {
        ConsoleHelper.clearScreen();
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
            int menuOption = ConsoleHelper.getValidIntegerInput(1, 4, "Entrada invalida. Por favor, ingrese un número del 1 al 4.", "Opcion: ");
            ConsoleHelper.clearScreen();
            switch(menuOption) {
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

package ec.edu.espe.cyberplaneta.view;

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
        int menuOption;
        while (true) {
            System.out.printf("%40s\n", "===============================================");
            System.out.printf("%40s\n", "Cyber Planeta System v.0.0.15");
            System.out.printf("%40s\n", "===============================================");
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Contribuyente");
            System.out.println("2. Agenda de clasificacion");
            System.out.println("3. Sistema de precios");
            System.out.println("4. Exit");
            System.out.printf("%40s\n", "===============================================");
            System.out.println("Opcion:  ");
            menuOption = scanner.nextInt();

<<<<<<< HEAD
        switch (menuOption) {
            case 1:
            SystemAdministrator.AddNewTaxPayer();
            break;
            case 2: 
            SystemAdministrator.AddNewTaxPayer();
            System.out.println("Contribuyente Agregado");
            break;
            case 3: 
            SystemAdministrator.AddNewTaxPayer();
            System.out.println("Agendado");
            break; 
        default:
            System.out.println("Precios");
            break;
}
=======
            ClearScreen.clearScreen();

            switch (menuOption) {
                case 1:
                    SystemAdministrator.printSystemAdminMenu();
                    break;

                case 2:
                    ClassificationAgenda.printSystemAgendaMenu();
                    break;

                case 3:
                    CPPricingSystem.CalculateTaxProcessCost();
                    break;

                case 4:
                   return;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
>>>>>>> cf6ace5c4604649156f23029559dee786a4e5e90
    }

}

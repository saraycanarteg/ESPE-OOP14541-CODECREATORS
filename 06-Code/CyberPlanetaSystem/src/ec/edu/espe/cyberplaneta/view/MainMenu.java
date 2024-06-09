
package ec.edu.espe.cyberplaneta.view;

import java.util.Scanner;
import utils.SystemAdministrator;

/**
 *
 * @author Nahomi Cedeno
 */
public class MainMenu {
    public static void main(String[]args){
        showMainMenu(); 
    }
        private static void showMainMenu (){
            Scanner scanner = new Scanner(System.in);

        int menuOption;
        System.out.println("MENU DE OPCIONES");
        System.out.println("1. Contribuyente");
        System.out.println("2. Agenda de clasificacion");
        System.out.println("3. Sistema de precios");
        System.out.println("Opcion:  ");
        menuOption = scanner.nextInt();

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
    }
    
}

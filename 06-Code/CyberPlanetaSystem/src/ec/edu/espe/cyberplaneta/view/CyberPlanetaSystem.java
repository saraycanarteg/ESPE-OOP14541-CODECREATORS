
package ec.edu.espe.cyberplaneta.view;

import java.util.Scanner;
import utils.SystemAdministrator;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class CyberPlanetaSystem {
    
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cyber Planeta System V 0.0.5");
        
        
        int menuOption;
        System.out.println("MENU DE OPCIONES");
        System.out.println("1. Anadir nuevo contribuyente");
        System.out.println("2. Calendario y agenda de clasificacion");
        System.out.println("3. Sistema de precios");
        System.out.println("Option:  ");
        menuOption = scanner.nextInt();
        
        
        if (menuOption == 1){
          SystemAdministrator.AddNewTaxPayer();
        }else{
            System.out.println(" ");
        }
    }
        

}

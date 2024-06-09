
package utils;

import com.google.gson.Gson;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class SystemAdministrator {

    public static void AddNewTaxPayer() {

        String idTaxPayer = "";
        String addAnotherTaxPayer;
        String deliveryDate = "";
        Scanner scanner = new Scanner(System.in);
        Date startDate = new Date();
        Calendar calendar = new Calendar(startDate, startDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        do {

            do {
                System.out.print("\nIngrese el ID del contribuyente: ");
                idTaxPayer = scanner.nextLine();
            } while (idTaxPayer.length() != 12);

            System.out.print("Email: ");
            String emailTaxPayer = scanner.nextLine();

            System.out.print("Nombre: ");
            String nameTaxPayer = scanner.nextLine();

            System.out.print("Contrasena: ");
            String passwordTaxPayer = scanner.nextLine();

            System.out.print("El contribuyente tiene informacion adicional? [true/false]: ");
            boolean accountingDocumentation = scanner.nextBoolean();

            System.out.print("El contribuyente inicia su proceso al: ");
            System.out.println(startDate);

            do {
                System.out.print("El contribuyente inicia su proceso al: [dd/MM/yyyy]: ");
                deliveryDate = scanner.next();

                try {
                    calendar = new Calendar(formatter.parse(deliveryDate), startDate);
                } catch (ParseException e) {
                    deliveryDate = "error";
                    System.out.println("Formato invalido, usa dd/MM/yyyy.");
                }
            } while (deliveryDate == "error");

            TaxPayer taxPayer = new TaxPayer(idTaxPayer, emailTaxPayer, nameTaxPayer, passwordTaxPayer, accountingDocumentation);
            String taxPayerData = taxPayer.toString()+calendar.toString();
            Gson gson = new Gson();
            RegisterTaxPayer(gson.toJson(taxPayerData));
            System.out.print("Agregar un nuevo contribuyente? (yes/no): ");
            addAnotherTaxPayer = scanner.next();

        } while (addAnotherTaxPayer.equalsIgnoreCase("y"));
    }

    public static void RegisterTaxPayer(String taxpayer) {
        DataBaseManager.SaveData(taxpayer, "TaxPayerData");
    }

    public static void SearchTaxPayer(int taxPayerId) {

    }

    public static void DeleteTaxPayer(int taxPayerId) {

    }

}

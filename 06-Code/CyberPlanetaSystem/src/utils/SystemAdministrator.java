package utils;

import com.google.gson.Gson;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        do {

            do {
                System.out.print("\nEnter the taxpayer Id: ");
                idTaxPayer = scanner.nextLine();
            } while (idTaxPayer.length() != 12);

            System.out.print("Enter the taxpayer's e-mail: ");
            String emailTaxPayer = scanner.nextLine();

            System.out.print("Enter taxpayer name: ");
            String nameTaxPayer = scanner.nextLine();

            System.out.print("Enter taxpayer password: ");
            String passwordTaxPayer = scanner.nextLine();

            System.out.print("The taxpayer provided documentation? [true/false]: ");
            boolean accountingDocumentation = scanner.nextBoolean();

            System.out.print("The start date of the tax process: ");
            LocalDate startDate = LocalDate.now();
            System.out.println(startDate);

            System.out.print("Enter the start date of the tax process [dd/MM/yyyy]: ");
            deliveryDate = scanner.next();

            Calendar calendar = new Calendar(deliveryDate, startDate.toString());

            TaxPayer taxPayer = new TaxPayer(idTaxPayer, emailTaxPayer, nameTaxPayer, passwordTaxPayer, accountingDocumentation);

            String taxPayerData = taxPayer.toString() + calendar.toString();

            RegisterTaxPayer(taxPayerData);
            System.out.print("Do you want to add another Tax Payer? (y/n): ");
            addAnotherTaxPayer = scanner.next();

        } while (addAnotherTaxPayer.equalsIgnoreCase("y"));
    }

    public static void RegisterTaxPayer(String taxpayer) {
        DataBaseManager.SaveData(taxpayer, "TaxPayerData");
    }

    public static void SearchTaxPayer(int taxPayerId) {

    }

    public static void DeleteTaxPayer(int taxPayerId) {
        DataBaseManager.RemoveData("TaxPayerData", taxPayerId);
    }

}

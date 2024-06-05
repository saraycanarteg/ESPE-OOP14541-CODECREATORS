
package utils;

import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        System.out.println("Cyber Planeta System V0.0.05");

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
            System.out.println(startDate);

            do {
                System.out.print("Enter the start date of the tax process [dd/MM/yyyy]: ");
                deliveryDate = scanner.next();

                try {
                    calendar = new Calendar(formatter.parse(deliveryDate), startDate);
                } catch (ParseException e) {
                    deliveryDate = "error";
                    System.out.println("Invalid date format, use dd/MM/yyyy.");
                }
            } while (deliveryDate == "error");

            TaxPayer taxPayer = new TaxPayer(idTaxPayer, emailTaxPayer, nameTaxPayer, passwordTaxPayer, accountingDocumentation);
            String taxPayerData = taxPayer.toString() + "," + calendar.toString();
            RegisterTaxPayer(taxPayerData);
            System.out.print("Do you want to add another Tax Payer? (y/n): ");
            addAnotherTaxPayer = scanner.next();

        } while (addAnotherTaxPayer.equalsIgnoreCase("y"));
    }

    public static void RegisterTaxPayer(String taxpayer) {

        String fileName = "TaxPayerData.csv";

        try (FileWriter fileWriter = new FileWriter(fileName, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(taxpayer);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Error to the file: " + e.getMessage());
        }
    }

    public static void SearchTaxPayer(int taxPayerId) {

    }

    public static void DeleteTaxPayer(int taxPayerId) {

    }

}

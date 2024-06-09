package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class SystemAdministrator {

    public static void printSystemAdminMenu() {
        ClearScreen.clearScreen();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============================================================================");
            System.out.printf("%40s\n", "Menu de Administrador de Sistema:");
            System.out.println("============================================================================");
            System.out.println("1. Agregar nuevo contribuyente");
            System.out.println("2. Editar contribuyente");
            System.out.println("3. Eliminar contribuyente");
            System.out.println("4. Agregar nuevo proceso del contribuyente");
            System.out.println("5. Salir");
            System.out.println("============================================================================");
            System.out.print("Opcion a escoger: ");
            int menuOption = scanner.nextInt();
            ClearScreen.clearScreen();

            switch (menuOption) {
                case 1:
                    addNewTaxPayer();
                    break;
                case 2:
                    editTaxPayer();
                    break;
                case 3:
                    deleteTaxPayer();
                    break;
                case 4:
                    addNewTaxProcess();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

   private static void addNewTaxPayer() {

        String idTaxPayer = "";
        String addAnotherTaxPayer;
        String deliveryDate = "";
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        do {

            do {
<<<<<<< HEAD
                System.out.print("\nIngrese el ID del contribuyente: ");
=======
                System.out.print("\nID: ");
>>>>>>> cf6ace5c4604649156f23029559dee786a4e5e90
                idTaxPayer = scanner.nextLine();
            } while (idTaxPayer.length() != 12);

            System.out.print("Email: ");
            String emailTaxPayer = scanner.nextLine();

            System.out.print("Nombre: ");
            String nameTaxPayer = scanner.nextLine();

            System.out.print("Contrasena: ");
            String passwordTaxPayer = scanner.nextLine();

<<<<<<< HEAD
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
=======
            System.out.print("El contribuyente proporciono documentacion? [true/false]: ");
            boolean accountingDocumentation = scanner.nextBoolean();

            System.out.print("Fecha de inicio del proceso: ");
            LocalDate startDate = LocalDate.now();
            System.out.println(startDate);

            System.out.print("Fecha de fin del proceso [dd/MM/yyyy]: ");
            deliveryDate = scanner.next();

            Calendar calendar = new Calendar(deliveryDate, startDate.toString());

            TaxPayer taxPayer = new TaxPayer(idTaxPayer, emailTaxPayer, nameTaxPayer, passwordTaxPayer, accountingDocumentation, calendar);

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(TaxPayer.class, new TaxPayerSerializer())
                    .create();
            String taxPayerData = gson.toJson(taxPayer);

            registerTaxPayer(taxPayerData);
            System.out.print("Desea anadir otro contribuyente? (y/n): ");
>>>>>>> cf6ace5c4604649156f23029559dee786a4e5e90
            addAnotherTaxPayer = scanner.next();

        } while (addAnotherTaxPayer.equalsIgnoreCase("y"));
    }

    private static void registerTaxPayer(String taxpayer) {
        DataBaseManager.SaveData(taxpayer, "TaxPayerData");
    }

    private static void editTaxPayer() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the ID of the TaxPayer to edit: ");
    String idTaxPayer = scanner.nextLine();

    TaxPayer taxPayer = DataBaseManager.findTaxPayerById("TaxPayerData", idTaxPayer);

    if (taxPayer == null) {
        System.out.println("TaxPayer not found.");
        return;
    }

    System.out.println("1. Editar Email");
    System.out.println("2. Editar Nombre");
    System.out.println("3. Editar Contrasena");
    System.out.println("4. Editar Documentacion");
    System.out.print("Opcion: ");
    int option = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    switch (option) {
        case 1:
            System.out.print("Ingrese nuevo email: ");
            String newEmail = scanner.nextLine();
            taxPayer.setEmail(newEmail);
            break;
        case 2:
            System.out.print("Ingrese nuevo nombre: ");
            String newName = scanner.nextLine();
            taxPayer.setName(newName);
            break;
        case 3:
            System.out.print("Ingrese nueva contraseña: ");
            String newPassword = scanner.nextLine();
            taxPayer.setPassword(newPassword);
            break;
        case 4:
            System.out.print("Ingrese nueva documentacion [true/false]: ");
            boolean newAccountingDocumentation = scanner.nextBoolean();
            taxPayer.setAccountingDocumentation(newAccountingDocumentation);
            break;
        default:
            System.out.println("Invalid option.");
            return;
    }

    DataBaseManager.updateTaxPayer(taxPayer, "TaxPayerData");
    System.out.println("TaxPayer information updated successfully.");
}


    private static void deleteTaxPayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID del contribuyente que va a eliminar: ");
        String id = scanner.nextLine();

        DataBaseManager.RemoveData("TaxPayerData", id);
    }
    private static void addNewTaxProcess() {
        Scanner scanner = new Scanner(System.in);
        ClearScreen.clearScreen();
        System.out.printf("%40s\n", "===============================================");
        System.out.printf("%40s\n", "Asignacion proceso -> contribuyente");
        System.out.printf("%40s\n", "===============================================");
        System.out.print("Ingrese el ID del contribuyente para agregar un nuevo proceso: ");
        String idTaxPayer = scanner.nextLine();

  
        PriceList.displayPriceArray();
        System.out.println();

        boolean addAnotherProcess;
        do {
            System.out.print("Ingrese el ID del proceso a agregar: ");
            int processId = scanner.nextInt();
            scanner.nextLine(); 
            
            PriceList[] priceList = PriceList.getPriceListArray();
            PriceList selectedProcess = null;
            for (PriceList process : priceList) {
                if (process.getProcessId() == processId) {
                    selectedProcess = process;
                    break;
                }
            }

            if (selectedProcess != null) {
                String processInfo = String.format("{\"processId\": %d, \"processName\": \"%s\", \"price\": %.2f, \"taxRate\": %.2f}",
                        selectedProcess.getProcessId(), selectedProcess.getProcessName(), selectedProcess.getPrice(), selectedProcess.getTaxRate());

                DataBaseManager.saveTaxProcess(idTaxPayer, processInfo);

                System.out.println("Proceso de impuestos agregado exitosamente.");

                System.out.print("Desea agregar otro proceso? (s/n): ");
                String response = scanner.nextLine();
                addAnotherProcess = response.equalsIgnoreCase("s");
            } else {
                System.out.println("ID de proceso invalido. Por favor, intente de nuevo.");
                addAnotherProcess = true; 
            }
            ClearScreen.clearScreen();
        } while (addAnotherProcess);
    }


}

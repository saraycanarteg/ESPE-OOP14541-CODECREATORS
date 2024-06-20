package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class SystemAdministrator {

    public static void printSystemAdminMenu() {
        ClearScreen.clearScreen();
        int menuOption = 0;
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

            try {
                menuOption = scanner.nextInt();

                if (menuOption < 1 || menuOption > 5) {
                    ClearScreen.clearScreen();
                    System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                ClearScreen.clearScreen();
                System.out.println("Entrada invalida. Por favor, ingrese un número del 1 al 5.");
                scanner.next();
                continue;
            }

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
                    System.out.println("Opcion Invalida. Intente otra vez.");

            }
        }
    }

 private static void addNewTaxPayer() {

        String idTaxPayer = "";
        String addAnotherTaxPayer;
        String emailTaxPayer = "";
        String nameTaxPayer = "";
        boolean dataValidation = false;
        boolean accountingDocumentation = false;
        Scanner scanner = new Scanner(System.in);

        do {

            do {
                System.out.print("\nID: ");
                idTaxPayer = scanner.nextLine();

            } while ((idTaxPayer.length() != 13) || (DataBaseManager.findCalendarById("TaxPayerData", idTaxPayer) != null));

            do {
                System.out.print("Email: ");
                emailTaxPayer = scanner.nextLine();
            } while (!emailTaxPayer.contains("@"));

            do {
                System.out.print("Nombre: ");
                nameTaxPayer = scanner.nextLine();
            } while (!nameTaxPayer.matches("[a-zA-Z\\s]+"));

            System.out.print("Contrasena: ");
            String passwordTaxPayer = scanner.nextLine();

            do {
                System.out.print("El contribuyente proporciono documentacion? [si/no]: ");
                String accDocumentation = scanner.nextLine().trim().toLowerCase();
                if (accDocumentation.equals("si")) {
                    accountingDocumentation = true;
                    dataValidation = true;
                } else if (accDocumentation.equals("no")) {
                    accountingDocumentation = false;
                    dataValidation = true;
                }
            } while (!dataValidation);

           LocalDate startDate = LocalDate.now();
           System.out.println("Fecha de inicio del proceso: " + startDate);

           LocalDate deliveryDate = null;
            do {
                System.out.print("Fecha de fin del proceso [dd/MM/yyyy]: ");
                String deliveryDateString = scanner.next();
                try {
                    deliveryDate = LocalDate.parse(deliveryDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    if (deliveryDate.isBefore(startDate)) {
                        System.out.println("La fecha de fin del proceso debe ser igual o posterior a la fecha de inicio.");
                        dataValidation = false;
                    } else {
                        dataValidation = true;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Fecha invalida. Por favor, ingrese una fecha con el formato dd/MM/yyyy.");
                    dataValidation = false;
                }
            } while (!dataValidation);

            Calendar calendar = new Calendar(deliveryDate.toString(), startDate.toString());

            TaxPayer taxPayer = new TaxPayer(idTaxPayer, emailTaxPayer, nameTaxPayer, passwordTaxPayer, accountingDocumentation, calendar);

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(TaxPayer.class, new TaxPayerSerializer())
                    .create();
            String taxPayerData = gson.toJson(taxPayer);

            registerTaxPayer(taxPayerData);
            System.out.print("Desea anadir otro contribuyente? (y/n): ");
            addAnotherTaxPayer = scanner.next();

        } while (addAnotherTaxPayer.equalsIgnoreCase("y"));
    }

    private static void registerTaxPayer(String taxpayer) {
        DataBaseManager.SaveData(taxpayer, "TaxPayerData");
    }

    private static void editTaxPayer() {
    Scanner scanner = new Scanner(System.in);
    int option = 0;
    String idTaxPayer = "";

    do {
        System.out.print("Ingrese el ID del Contribuyente a editar: ");
        idTaxPayer = scanner.nextLine();
    } while (idTaxPayer.length() != 13);

    TaxPayer taxPayer = DataBaseManager.findTaxPayerById("TaxPayerData", idTaxPayer);

    if (taxPayer == null) {
        System.out.println("\nEl contribuyente no existe\n");
        return;
    }

    while (true) {
        System.out.println("1. Editar Email");
        System.out.println("2. Editar Nombre");
        System.out.println("3. Editar Contrasena");
        System.out.println("4. Editar Documentacion");
        System.out.println("5. Salir");
        System.out.print("Opcion: ");

        try {
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (option < 1 || option > 5) {
                ClearScreen.clearScreen();
                System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
                continue;
            }
        } catch (InputMismatchException e) {
            ClearScreen.clearScreen();
            System.out.println("Entrada invalida. Por favor, ingrese un numero del 1 al 5.");
            scanner.next();
            continue;
        }

        ClearScreen.clearScreen();
        switch (option) {
            case 1:
                String newEmail;
                do {
                    System.out.print("Ingrese nuevo email: ");
                    newEmail = scanner.nextLine();
                    if (!newEmail.contains("@")) {
                        System.out.println("Email invalido. Debe contener '@'.");
                    }
                } while (!newEmail.contains("@"));
                taxPayer.setEmail(newEmail);
                break;
            case 2:
                String newName;
                do {
                    System.out.print("Ingrese nuevo nombre: ");
                    newName = scanner.nextLine();
                    if (!newName.matches("[a-zA-Z\\s]+")) {
                        System.out.println("Nombre invalido. Solo debe contener letras y espacios.");
                    }
                } while (!newName.matches("[a-zA-Z\\s]+"));
                taxPayer.setName(newName);
                break;
            case 3:
                System.out.print("Ingrese nueva contraseña: ");
                String newPassword = scanner.nextLine();
                taxPayer.setPassword(newPassword);
                break;
            case 4:
                boolean newAccountingDocumentation = false;
                boolean validInput = false;
                do {
                    System.out.print("Ingrese nueva documentacion [true/false]: ");
                    String documentationInput = scanner.nextLine().trim().toLowerCase();
                    if (documentationInput.equals("true") || documentationInput.equals("false")) {
                        newAccountingDocumentation = Boolean.parseBoolean(documentationInput);
                        validInput = true;
                    } else {
                        System.out.println("Entrada invalida. Por favor, ingrese 'true' o 'false'.");
                    }
                } while (!validInput);
                taxPayer.setAccountingDocumentation(newAccountingDocumentation);
                break;
            case 5:
                return;
            default:
                System.out.println("Opcion Invalida. Intente otra vez.");
        }

        DataBaseManager.updateTaxPayer(taxPayer, "TaxPayerData");
        System.out.println("Informacion del Contribuyente actualizada exitosamente.");
    }
}

    private static void deleteTaxPayer() {
    Scanner scanner = new Scanner(System.in);
    String id;
    do {
        System.out.print("ID del contribuyente que va a eliminar (13 digitos): ");
        id = scanner.nextLine();
        if (id.length() != 13) {
            System.out.println("ID invalido. Debe contener exactamente 13 digitos.");
        }
    } while (id.length() != 13);

    DataBaseManager.RemoveData("TaxPayerData", id);
}

    private static void addNewTaxProcess() {
     Scanner scanner = new Scanner(System.in);
    ClearScreen.clearScreen();
    System.out.printf("%40s\n", "===============================================");
    System.out.printf("%40s\n", "Asignacion proceso -> contribuyente");
    System.out.printf("%40s\n", "===============================================");
    
    String idTaxPayer;
    do {
        System.out.print("Ingrese el ID del contribuyente para agregar un nuevo proceso (13 digitos): ");
        idTaxPayer = scanner.nextLine();
        if (idTaxPayer.length() != 13) {
            System.out.println("ID invalido. Debe contener exactamente 13 digitos.");
        }
    } while (idTaxPayer.length() != 13);

    PriceList.displayPriceArray();
    System.out.println();

    boolean addAnotherProcess = true;
    while (addAnotherProcess) {
        try {
            System.out.println("1. Agregar proceso");
            System.out.println("2. Salir");
            System.out.print("Opcion: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
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
                        String processInfo = String.format(Locale.US, "{\"processId\": %d, \"processName\": \"%s\", \"price\": %.2f, \"taxRate\": %.2f}",
                                selectedProcess.getProcessId(), selectedProcess.getProcessName(), selectedProcess.getPrice(), selectedProcess.getTaxRate());

                        DataBaseManager.SaveData(processInfo, idTaxPayer + "_process");

                        System.out.println("Proceso de impuestos agregado exitosamente.");

                        boolean validResponse = false;
                        do {
                            System.out.print("Desea agregar otro proceso? [si/no]: ");
                            String response = scanner.nextLine().trim().toLowerCase();
                            if (response.equals("si")) {
                                addAnotherProcess = true;
                                validResponse = true;
                            } else if (response.equals("no")) {
                                addAnotherProcess = false;
                                validResponse = true;
                            } else {
                                System.out.println("Entrada invalida. Por favor, ingrese 'si' o 'no'.");
                            }
                        } while (!validResponse);
                    } else {
                        System.out.println("ID de proceso invalido. Por favor, intente de nuevo.");
                        addAnotherProcess = true;
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del proceso de agregar nuevos procesos...");
                    return;
                default:
                    System.out.println("Opcion Invalida. Intente otra vez.");
                    addAnotherProcess = true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Por favor, ingrese un número.");
            scanner.nextLine(); 
            addAnotherProcess = true;
        }
        ClearScreen.clearScreen();
    }
}
}



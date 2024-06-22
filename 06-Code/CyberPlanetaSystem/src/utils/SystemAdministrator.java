package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void printSystemAdminMenu() {
        ClearScreen.clearScreen();
        while (true) {
            showAdminMenu();
            int menuOption = getMenuOption(5);
            ClearScreen.clearScreen();
            executeMenuOption(menuOption);
            if (menuOption == 5) {
                System.out.println("Saliendo...");
                break;
            }
        }
    }

    private static void showAdminMenu() {
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
    }

    private static int getMenuOption(int optionNumber) {
        int menuOption = 0;
        try {
            menuOption = scanner.nextInt();
            if (menuOption < 1 || menuOption > optionNumber) {
                ClearScreen.clearScreen();
                System.out.println("Opcion invalida. Por favor, intentelo de nuevo.");
            }
        } catch (InputMismatchException e) {
            ClearScreen.clearScreen();
            System.out.println("Entrada invalida. Por favor, ingrese un número del 1 al " + optionNumber);
            scanner.next();
        }
        return menuOption;
    }

    private static void executeMenuOption(int menuOption) {
        switch (menuOption) {
            case 1 ->
                addNewTaxPayer();
            case 2 ->
                editTaxPayer();
            case 3 ->
                deleteTaxPayer();
            case 4 ->
                addNewTaxProcess();
            case 5 ->
                System.out.println("Saliendo...");
            default ->
                System.out.println("Opcion Invalida. Intente otra vez.");
        }
    }

    private static void addNewTaxPayer() {
        boolean addTaxpayer = true;

        while (addTaxpayer) {
            String idTaxPayer = getIdTaxPayer(1);
            String emailTaxPayer = getEmailTaxPayer(1);
            String nameTaxPayer = getNameTaxPayer(1);
            String passwordTaxPayer = getPasswordTaxPayer(1);
            boolean accountingDocumentation = getAccountingDocumentation(1);
            LocalDate startDate = LocalDate.now();
            System.out.println("Fecha de inicio del proceso: " + startDate);
            LocalDate deliveryDate = getDeliveryDate(startDate);

            Calendar calendar = new Calendar(deliveryDate.toString(), startDate.toString());
            TaxPayer taxPayer = new TaxPayer(idTaxPayer, emailTaxPayer, nameTaxPayer, passwordTaxPayer, accountingDocumentation, calendar);

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(TaxPayer.class, new TaxPayerSerializer())
                    .create();
            String taxPayerData = gson.toJson(taxPayer);

            registerTaxPayer(taxPayerData);

            addTaxpayer = askToAddAnotherTaxPayer();
        }
    }

    private static String getIdTaxPayer(int typeMenu) {
        String idTaxPayer;
        Boolean dataValidate = false;
        do {
            executeIdOption(typeMenu);
            idTaxPayer = scanner.next();
            dataValidate = true;

            if (typeMenu == 1 && DataBaseManager.findCalendarById("TaxPayerData", idTaxPayer) != null) {
                System.out.println("El ID ya existe en la base de datos.");
                dataValidate = false;
            }

        } while (idTaxPayer.length() != 13 || !idTaxPayer.matches("\\d+") || !dataValidate);

        return idTaxPayer;
    }

    private static void executeIdOption(int idOption) {
        switch (idOption) {
            case 1:
                System.out.print("\nID: ");
                break;
            case 2:
                System.out.print("Ingrese el ID del Contribuyente a editar: ");
                break;
            case 3:
                System.out.print("ID del contribuyente que va a eliminar (13 digitos): ");
                break;
            case 4:
                System.out.print("Ingrese el ID del contribuyente para agregar un nuevo proceso: ");
            default:
                break;
        }
    }

    private static String getEmailTaxPayer(int type) {
        String emailTaxPayer;
        do {
            if (type == 1) {
                System.out.print("Email: ");
            } else if (type == 2) {
                System.out.print("Ingrese nuevo Email: ");
            }
            emailTaxPayer = scanner.next();
        } while (!emailTaxPayer.contains("@"));
        return emailTaxPayer;
    }

    private static String getNameTaxPayer(int type) {
        String nameTaxPayer;
        scanner.nextLine();
        do {
            if (type == 1) {
                System.out.print("Nombre: ");
            } else if (type == 2) {
                System.out.print("Ingrese nuevo Nombre: ");
            }
            nameTaxPayer = scanner.nextLine();
        } while (!nameTaxPayer.matches("[a-zA-Z\\s]+"));
        return nameTaxPayer;
    }

    private static String getPasswordTaxPayer(int type) {
        if (type == 1) {
            System.out.print("Contrasena: ");
        } else if (type == 2) {
            System.out.print("Ingrese nueva Contrasena: ");
        }
        return scanner.next();
    }

    private static boolean getAccountingDocumentation(int type) {
        String accDocumentation;
        scanner.nextLine();
        do {
            if (type == 1) {
                System.out.print("El contribuyente proporciono documentacion?[si/no]: ");
            } else if (type == 2) {
                System.out.print("Ingresa nueva documentacion? [si/no]: ");
            }
            accDocumentation = scanner.nextLine().toLowerCase();
        } while (!accDocumentation.equals("si") && !accDocumentation.equals("no"));

        return accDocumentation.equals("si");
    }

    private static LocalDate getDeliveryDate(LocalDate startDate) {
        LocalDate deliveryDate = null;
        boolean dataValidation;
        do {
            System.out.print("Fecha de fin del proceso [dd/MM/yyyy]: ");
            String deliveryDateString = scanner.next();
            try {
                deliveryDate = LocalDate.parse(deliveryDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                dataValidation = !deliveryDate.isBefore(startDate);
                if (!dataValidation) {
                    System.out.println("La fecha de fin del proceso debe ser igual o posterior a la fecha de inicio.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Fecha invalida. Por favor, ingrese una fecha con el formato dd/MM/yyyy.");
                dataValidation = false;
            }
        } while (!dataValidation);
        return deliveryDate;
    }

    private static boolean askToAddAnotherTaxPayer() {
        String response;
        scanner.nextLine();
        do {
            System.out.print("Desea anadir otro contribuyente? [si/no]: ");
            response = scanner.nextLine().toLowerCase();
        } while (!response.equals("si") && !response.equals("no"));
        return response.equals("si");
    }

    private static void registerTaxPayer(String taxpayerData) {
        DataBaseManager.SaveData(taxpayerData, "TaxPayerData");
    }

    private static void editTaxPayer() {
        String idTaxPayer = getIdTaxPayer(2);
        TaxPayer taxPayer = DataBaseManager.findTaxPayerById("TaxPayerData", idTaxPayer);
        if (taxPayer == null) {
            System.out.println("\nEl contribuyente no existe\n");
            return;
        }

        while (true) {
            showEditMenu();
            int option = getMenuOption(5);
            ClearScreen.clearScreen();
            executeEditOption(option, taxPayer);
            if (option == 5) {
                break;
            }
            DataBaseManager.updateTaxPayer(taxPayer, "TaxPayerData");
            if (option < 5 && option > 0) {
                System.out.println("Informacion del Contribuyente actualizada exitosamente.");
            }
        }
    }

    private static void showEditMenu() {
        System.out.println("============================================================================");
        System.out.printf("%40s\n", "Menu de Administrador de Sistema:");
        System.out.println("============================================================================");
        System.out.println("1. Editar Email");
        System.out.println("2. Editar Nombre");
        System.out.println("3. Editar Contrasena");
        System.out.println("4. Editar Documentacion");
        System.out.println("5. Salir");
        System.out.println("============================================================================");
        System.out.print("Opcion: ");
    }

    private static void executeEditOption(int option, TaxPayer taxPayer) {
        switch (option) {
            case 1 ->
                taxPayer.setEmail(getEmailTaxPayer(2));
            case 2 ->
                taxPayer.setName(getNameTaxPayer(2));
            case 3 ->
                taxPayer.setPassword(getPasswordTaxPayer(2));
            case 4 ->
                taxPayer.setAccountingDocumentation(getAccountingDocumentation(2));
            case 5 ->
                System.out.println("Saliendo...");
            default ->
                System.out.println("Opcion Invalida. Intente otra vez.");
        }
    }

    private static void deleteTaxPayer() {
        String idTaxPayer = getIdTaxPayer(3);

        TaxPayer taxPayer = DataBaseManager.findTaxPayerById("TaxPayerData", idTaxPayer);

        if (taxPayer == null) {
            System.out.println("\nEl contribuyente no existe, no se puede eliminar\n");
        } else {
            DataBaseManager.RemoveData("TaxPayerData", idTaxPayer);
        }
    }

    private static void addNewTaxProcess() {
        ClearScreen.clearScreen();
        while (true) {
            showAddProcessMenu();
            int option = getMenuOption(2);
            if (option == 2) {
                ClearScreen.clearScreen();
                System.out.println("Saliendo...");
                break;
            }
            if (option == 1) {

                String idTaxPayer = getIdTaxPayer(4);
                TaxPayer taxPayer = DataBaseManager.findTaxPayerById("TaxPayerData", idTaxPayer);
                if (taxPayer == null) {
                    System.out.println("\nEl contribuyente no existe\n");
                    break;
                }

                boolean addAnotherProcess;
                do {
                    addAnotherProcess = addProcessToTaxPayer(idTaxPayer);
                } while (addAnotherProcess);
            }
        }
    }

    private static void showAddProcessMenu() {
        System.out.printf("%40s\n", "===============================================");
        System.out.printf("%40s\n", "Asignacion proceso -> contribuyente");
        System.out.printf("%40s\n", "===============================================");
        System.out.println("1. Desea continuar la asignacion del proceso al contribuyente: ");
        System.out.println("2. Salir.");
        System.out.print("Ingrese una opcion: ");
    }

    private static boolean addProcessToTaxPayer(String idTaxPayer) {
        PriceList.displayPriceArray();
        System.out.println("6.    Salir");
        System.out.println("=======================================================================================================");

        int processId = getProcessId();

        if (processId == 6) {
            ClearScreen.clearScreen();
            return false;
        }

        PriceList[] priceList = PriceList.getPriceListArray();
        PriceList selectedProcess = null;
        for (PriceList process : priceList) {
            if (process.getProcessId() == processId) {
                selectedProcess = process;
                break;
            }
        }

        if (selectedProcess != null) {
            String processInfo = createProcessInfo(selectedProcess);
            DataBaseManager.SaveData(processInfo, idTaxPayer + "_process");
            System.out.println("Proceso de impuestos agregado exitosamente.");
            return askToAddAnotherProcess();
        } else {
            System.out.println("ID de proceso inválido. Por favor, intente de nuevo.");
            return true;
        }
    }

    private static int getProcessId() {
        int processId = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Ingrese el ID del proceso a agregar: ");
            if (scanner.hasNextInt()) {
                processId = scanner.nextInt();
                validInput = processId >= 1 && processId <= 6;
                if (!validInput) {
                    System.out.println("El ID debe estar en el rango de 1 a 6.");
                }
            } else {
                System.out.println("El ID debe ser un número entero.");
                scanner.next();
            }
        }
        return processId;
    }

    private static String createProcessInfo(PriceList selectedProcess) {
        return String.format(Locale.US, "{\"processId\": %d, \"processName\": \"%s\", \"price\": %.2f, \"taxRate\": %.2f}",
                selectedProcess.getProcessId(), selectedProcess.getProcessName(), selectedProcess.getPrice(), selectedProcess.getTaxRate());
    }

    private static boolean askToAddAnotherProcess() {
        String response;
        scanner.nextLine();
        do {
            System.out.print("Desea agregar otro proceso [si/no]: ");
            response = scanner.nextLine().trim().toLowerCase();
        } while (!response.equals("si") && !response.equals("no"));
        return response.equals("si");
    }
}
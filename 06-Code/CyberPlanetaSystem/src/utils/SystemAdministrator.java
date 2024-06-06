package utils;

import com.google.gson.Gson;
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
                System.out.print("\nID: ");
                idTaxPayer = scanner.nextLine();
            } while (idTaxPayer.length() != 12);

            

            System.out.print("Email: ");
            String emailTaxPayer = scanner.nextLine();

            System.out.print("Nombre: ");
            String nameTaxPayer = scanner.nextLine();

            System.out.print("Contrasena: ");
            String passwordTaxPayer = scanner.nextLine();

            System.out.print("El contribuyente proporciono documentacion? [true/false]: ");
            boolean accountingDocumentation = scanner.nextBoolean();

            System.out.print("Fecha de inicio del proceso: ");
            LocalDate startDate = LocalDate.now();
            System.out.println(startDate);

            System.out.print("Fecha de fin del proceso [dd/MM/yyyy]: ");
            deliveryDate = scanner.next();

            Calendar calendar = new Calendar(deliveryDate, startDate.toString());

            TaxPayer taxPayer = new TaxPayer(idTaxPayer, emailTaxPayer, nameTaxPayer, passwordTaxPayer, accountingDocumentation);

            String taxPayerData = taxPayer.toString() + calendar.toString();

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
        Gson gson = new Gson();

        // 1. Solicitar ID del contribuyente
        System.out.print("Ingrese el ID del contribuyente a editar: ");
        String idTaxPayer = scanner.nextLine();

        // 2. Buscar contribuyente
        String taxpayerData = DataBaseManager.findData("TaxPayerData", idTaxPayer);
        if (taxpayerData.isEmpty()) {
            System.out.println("No se encontró el contribuyente con el ID: " + idTaxPayer);
            return;
        }

        // 3. Presentar menú de edición
        System.out.println("\n¿Qué desea editar?");
        System.out.println("1. ID");
        System.out.println("2. Email");
        System.out.println("3. Nombre");
        System.out.println("4. Contraseña");
        System.out.print("Opción: ");
        int editOption = scanner.nextInt();

        // 4. Modificar dato seleccionado
        TaxPayer taxPayer = gson.fromJson(taxpayerData, TaxPayer.class);
        switch (editOption) {
            case 1:
                System.out.print("Nuevo ID: ");
                taxPayer.setId(scanner.nextLine());
                break;
            case 2:
                System.out.print("Nuevo email: ");
                taxPayer.setEmail(scanner.nextLine());
                break;
            case 3:
                System.out.print("Nuevo nombre: ");
                taxPayer.setName(scanner.nextLine());
                break;
            case 4:
                System.out.print("Nueva contraseña: ");
                taxPayer.setPassword(scanner.nextLine());
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        // 5. Actualizar archivo JSON
        String updatedTaxpayerData = taxPayer.toString();
        DataBaseManager.UpdateData("TaxPayerData", idTaxPayer, updatedTaxpayerData);

        // 6. Mensaje de confirmación
        System.out.println("Información del contribuyente actualizada correctamente.");
    }

    private static boolean isValidJson(String json) {
        try {
            new Gson().fromJson(json, Object.class);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

    private static void editTaxpayerDetails(String taxpayerData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Qué desea editar?");
        System.out.println("1. Email");
        System.out.println("2. Nombre");
        System.out.println("3. Contraseña");
        System.out.print("Ingrese la opción: ");
        int editOption = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea sobrante

        String updatedData = taxpayerData;
        Gson gson = new Gson();

        try {
            JsonReader reader = new JsonReader(new StringReader(taxpayerData));
            reader.setLenient(true);
            TaxPayer taxpayer = gson.fromJson(reader, TaxPayer.class);

            switch (editOption) {
                case 1:
                    System.out.print("Ingrese el nuevo email: ");
                    String newEmail = scanner.nextLine();
                    taxpayer.setEmail(newEmail);
                    updatedData = gson.toJson(taxpayer);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = scanner.nextLine();
                    taxpayer.setName(newName);
                    updatedData = gson.toJson(taxpayer);
                    break;
                case 3:
                    System.out.print("Ingrese la nueva contraseña: ");
                    String newPassword = scanner.nextLine();
                    taxpayer.setPassword(newPassword);
                    updatedData = gson.toJson(taxpayer);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } catch (JsonSyntaxException e) {
            System.out.println("Error al analizar los datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }

        if (!updatedData.equals(taxpayerData)) {
            DataBaseManager.UpdateData("TaxPayerData", taxpayerData, updatedData);
            System.out.println("Contribuyente editado exitosamente.");
        }
    }

    private static void deleteTaxPayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID del contribuyente que va a eliminar: ");
        long id = scanner.nextLong();

        DataBaseManager.RemoveData("TaxPayerData", id);
    }
    private static void addNewTaxProcess() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el ID del contribuyente para agregar un nuevo proceso: ");
        String idTaxPayer = scanner.nextLine();

       
        System.out.println("Arreglo de PriceList:");
        PriceList.displayPriceArray();

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
        } while (addAnotherProcess);
    }

    //private static void deleteTaxPayer(int taxPayerId) {
    //    DataBaseManager.RemoveData("TaxPayerData", taxPayerId);
    //}
}

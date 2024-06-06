package utils;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;


/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class SystemAdministrator {
    
       
    public static void printSystemAdminMenu (){
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
                    //deleteTaxPayer();
                    break;
                case 4:
                    //addNewTaxProcess();
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
        System.out.print("ID del contribuyente que va a editar: ");
        String id = scanner.nextLine();

        String taxpayerData = DataBaseManager.findData("TaxPayerData", String.valueOf(id) + ":"); 

        System.out.println("Información actual del contribuyente:");
        System.out.println(taxpayerData); 

        editTaxpayerDetails(taxpayerData);
    }


        private static void editTaxpayerDetails(String taxpayerData) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("\nQue desea editar?");
          System.out.println("1. Email");
          System.out.println("2. Nombre");
          System.out.println("3. Contrasena");
          System.out.print("Ingrese la opcion: ");
          int editOption = scanner.nextInt();

          String updatedData = taxpayerData; 
          Gson gson = new Gson();

          try {
            TaxPayer taxpayer = gson.fromJson(taxpayerData, TaxPayer.class);

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
                System.out.print("Ingrese la nueva contrasena: ");
                String newPassword = scanner.nextLine();
                taxpayer.setPassword(newPassword);
                updatedData = gson.toJson(taxpayer);
                break;
              case 4: 
                System.out.println("Error: ID cannot be edited.");
                break;
              default:
                System.out.println("Opción inválida.");
            }
          } catch (JsonSyntaxException e) {
            System.out.println("Error parsing data: " + e.getMessage());
          } catch (Exception e) { 
            System.out.println("Error updating data: " + e.getMessage());
          }

          if (!updatedData.equals(taxpayerData)) {
            DataBaseManager.UpdateData("TaxPayerData", taxpayerData, updatedData);
            System.out.println("Contribuyente editado exitosamente.");
          }
        }


   //private static void deleteTaxPayer(int taxPayerId) {
    //    DataBaseManager.RemoveData("TaxPayerData", taxPayerId);
    //}

}

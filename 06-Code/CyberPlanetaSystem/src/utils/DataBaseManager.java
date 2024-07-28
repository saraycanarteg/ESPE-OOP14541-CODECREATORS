
package utils;

import consoleutils.TaxPayerSerializer;
import consoleutils.TaxPayerDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class DataBaseManager {

    public static void saveData(String data, String fileName) {
        fileName = fileName + ".json";
        try (FileWriter fileWriter = new FileWriter(fileName, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static List<String> readData(String fileName, String separator) {
        List<String> lineas = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        return lineas;
    }

    public static void removeData(String fileName, String idEdit) {
        fileName = fileName + ".json";
        List<String> lineas = readData(fileName, "");

        if (lineas.isEmpty()) {
            System.out.println("El archivo está vacío.");
            return;
        }

        List<String> newLineas = new ArrayList<>();
        for (String linea : lineas) {
            Gson gson = new Gson();
            TaxPayer taxPayer;
            try {
                taxPayer = gson.fromJson(linea, TaxPayer.class);
            } catch (JsonSyntaxException e) {
                System.out.println("Error JSON: " + e.getMessage());
                continue;
            }

            if (!taxPayer.getId().equals(idEdit)) {
                newLineas.add(linea);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String l : newLineas) {
                writer.write(l);
                writer.newLine();
            }
            System.out.println("Datos eliminados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static String findData(String fileName, String wordSearch) {
        fileName = fileName + ".json";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(wordSearch)) {

                    return line;
                }
            }
        } catch (IOException e) {
        }
        return "";
    }

    public static TaxPayer findTaxPayerById(String fileName, String idTaxPayer) {
        String taxpayerData = DataBaseManager.findData(fileName, idTaxPayer);
        if (!taxpayerData.isEmpty()) {
            Gson gson = new Gson();
            return gson.fromJson(taxpayerData, TaxPayer.class);
        }
        return null;
    }

    public static Calendar findCalendarById(String fileName, String idTaxPayer) {
        String taxpayerData = DataBaseManager.findData(fileName, idTaxPayer);
        if (!taxpayerData.isEmpty()) {
            Gson gson = new Gson();
            return gson.fromJson(taxpayerData, Calendar.class);
        }
        return null;
    }

    public static void updateTaxPayer(TaxPayer taxPayer, String fileName) {
        List<String> lines = readData(fileName + ".json", "");

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(taxPayer.getId())) {
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(TaxPayer.class, new TaxPayerSerializer())
                        .registerTypeAdapter(TaxPayer.class, new TaxPayerDeserializer())
                        .create();
                TaxPayer existingTaxPayer = gson.fromJson(lines.get(i), TaxPayer.class);

                existingTaxPayer.setEmail(taxPayer.getEmail());
                existingTaxPayer.setName(taxPayer.getName());
                existingTaxPayer.setPassword(taxPayer.getPassword());
                existingTaxPayer.setAccountingDocumentation(taxPayer.isAccountingDocumentation());

                String taxpayerData = gson.toJson(existingTaxPayer);
                lines.set(i, taxpayerData);
                break;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".json"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

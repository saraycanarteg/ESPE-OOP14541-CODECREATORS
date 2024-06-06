
package utils;

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

    public static void SaveData(String data, String fileName) {
        fileName = fileName + ".json";
        try (FileWriter fileWriter = new FileWriter(fileName, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    
     public static List<String> ReadData(String fileName, String separator) {
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

    public static void RemoveData(String fileName, int idEdit) {
        fileName = fileName + ".json";
        String separator = ",";
        List<String> lineas = ReadData(fileName, separator);

        if (lineas.isEmpty()) {
            System.out.println("El archivo está vacío.");
            return;
        }

        int numero;
        List<String> newLineas = new ArrayList<>();
        for (String linea : lineas) {
            String[] values = linea.split(separator);
            numero = Integer.parseInt(values[0].split(":")[1]);
            if (numero != idEdit) {
                newLineas.add(linea);
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (String l : newLineas) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();
            System.out.println("Datos eliminados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }


    public static void UpdateData(String fileName, String wordSearch, String newData) {
        fileName = fileName + ".json";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(wordSearch)) {
                    line = line.replace(wordSearch, newData);
                }
                SaveData(line, fileName);
            }
        } catch (IOException e) {
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

 
}

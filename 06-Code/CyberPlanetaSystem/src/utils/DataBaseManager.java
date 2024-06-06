
package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public static void RemoveData() {

    }

    public static void UpdateData() {

    }

    public static void findData() {

    }

    public static void ReadData() {

    }

}

package utils;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
import java.util.Scanner;

public class CPAnnualGrowthSystem {

    public static void calculateCAGR() {
        Scanner scanner = new Scanner(System.in);

        int numYears = getNumberOfYears(scanner);
        double[] values = new double[numYears];
        for (int i = 0; i < numYears; i++) {
            double value = getValueForYear(scanner, i + 1);
            values[i] = value;
        }

        double initialValue = values[0];
        double finalValue = values[numYears - 1];
        double cagr = calculateCAGR(initialValue, finalValue, numYears);
        System.out.printf("La tasa de crecimiento anual promedio (CAGR) es: %.2f%%\n", cagr);
    }

    public static int getNumberOfYears(Scanner scanner) {
        int numYears = 0;
        while (true) {
            System.out.print("Ingrese el numero de anios para calcular CAGR : ");
            String input = scanner.nextLine();
            try {
                numYears = Integer.parseInt(input);
                if (numYears > 0) {
                    break;
                } else {
                }
            } catch (NumberFormatException e) {
            }
        }
        return numYears;
    }

    public static double getValueForYear(Scanner scanner, int yearNumber) {
        double value = 0.0;
        while (true) {
            System.out.print("Ingrese el valor para el anio " + yearNumber + " : ");
            String input = scanner.nextLine();
            try {
                value = Double.parseDouble(input);
                if (isValidValue(value) && value > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        }
        return value;
    }

    public static boolean isValidValue(double value) {
        double epsilon = 0.01;
        return Math.abs(Math.round(value * 100) - value * 100) < epsilon;
    }

    public static double calculateCAGR(double initialValue, double finalValue, int numYears) {
        double cagr = Math.pow(finalValue / initialValue, 1.0 / numYears) - 1;
        return cagr * 100;
    }
}

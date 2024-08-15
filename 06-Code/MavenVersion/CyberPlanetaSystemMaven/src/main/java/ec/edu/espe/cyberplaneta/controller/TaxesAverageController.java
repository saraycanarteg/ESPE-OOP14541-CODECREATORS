package ec.edu.espe.cyberplaneta.controller;

 /**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE
 */

public class TaxesAverageController {
    private final TaxesAverageController calculator;
    
    public TaxesAverageController() {
        this.calculator = new TaxesAverageController();
    }
    
    public double calculateAverage(String[] values) throws InvalidInputException {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < values.length; i++) {
            try {
                sum += validateAndParseValue(values[i], i);
                count++;
            } catch (InvalidInputException e) {
                throw e;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    private double validateAndParseValue(String text, int index) throws InvalidInputException {
        if (text.isEmpty()) {
            return 0;
        }
        if (!text.matches("\\d+(\\.\\d+)?")) {
            throw new InvalidInputException("Por favor, ingrese solo números con decimales separados por punto (.)", index);
        }
        return Double.parseDouble(text);
    }

    public class InvalidInputException extends Exception {

        private int errorIndex;

        public InvalidInputException(String message, int errorIndex) {
            super(message);
            this.errorIndex = errorIndex;
        }

        public int getErrorIndex() {
            return errorIndex;
        }
    }

    public static double calculateAverageMonthlyTaxes(int numberOfMonths, double[] monthlyTaxes) {
        if (numberOfMonths <= 0 || monthlyTaxes == null || monthlyTaxes.length != numberOfMonths) {
            throw new IllegalArgumentException("Número de meses inválido o arreglo de impuestos no coincide.");
        }

        double totalTaxes = 0;
        for (double tax : monthlyTaxes) {
            totalTaxes += tax;
        }

        return calculateAverage(totalTaxes, numberOfMonths);
    }

    private static double calculateAverage(double totalTaxes, int numberOfMonths) {
        return totalTaxes / numberOfMonths;
    }
}













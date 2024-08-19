package ec.edu.espe.cyberplaneta.controller;

/**
 *
 * @author Saray Cañarte
 */
public interface CAGRInterface {
    double calculateFutureValue(double finalValue, double cagr, int numYears);
    double calculateCAGR(double initialValue, double finalValue, int numYears);
    boolean isValidValue(double value);
}

package ec.edu.espe.cyberplaneta.controller;

/**
 *
 * @author Saray Cañarte
 */
public class C_CompoundAnualGrowth implements I_CompoundAnualGrowth {
    @Override
    public double calculateFutureValue(double finalValue, double cagr, int numYears) {
        double futureValue = finalValue * Math.pow(1 + (cagr / 100), numYears);
        return futureValue;
    }

    @Override
    public double calculateCAGR(double initialValue, double finalValue, int numYears) {
        double cagr = Math.pow(finalValue / initialValue, 1.0 / (numYears)) - 1;
        return cagr * 100;
    }

    @Override
    public boolean isValidValue(double value) {
        double epsilon = 0.01;
        return Math.abs(Math.round(value * 100) - value * 100) < epsilon;
    }
}

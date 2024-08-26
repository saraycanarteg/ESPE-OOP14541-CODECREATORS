
package ec.edu.espe.cyberplaneta.controller;

/**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE
 */
public class CompareTwoMonthsTax implements CompareTwoMonthsTaxInterface {

    @Override
    public String compareMonths(double valueMonth1, double valueMonth2) {
        if (valueMonth1 > valueMonth2) {
            double difference = valueMonth1 - valueMonth2;
            return "Primer mes ingresado es mayor al segundo mes ingresado por: $ " + difference;
        } else if (valueMonth2 > valueMonth1) {
            double difference = valueMonth2 - valueMonth1;
            return "Segundo mes ingresado es mayor al primer mes ingresado: $ " + difference;
        } else {
            return "No existe diferencia";
        }
    }
}

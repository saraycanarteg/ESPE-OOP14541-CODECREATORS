
package ec.edu.espe.cyberplaneta.model;

/**
 *
 * @author lilit
 */
public class CalcuteAverage {

    public double calculateAverge(double[] impuestos) {
        double suma = 0;
        int contador = 0;

        for (double impuesto : impuestos) {
            if (impuesto > 0) {
                suma += impuesto;
                contador++;
            }
        }

        return contador > 0 ? suma / contador : 0;
    }

    public double calculateAverage(double[] impuestos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double calculateAvera(double[] impuestos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


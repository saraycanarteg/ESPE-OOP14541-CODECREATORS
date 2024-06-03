
package ec.edu.espe.cyberplaneta.model;

import java.util.Date;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class TaxProcess {

    private float price;
    private String typeOfProcess;
    private int numberOfDocumentation;

    public TaxProcess(float price, String typeOfProcess, int numberOfDocumentation) {
        this.price = price;
        this.typeOfProcess = typeOfProcess;
        this.numberOfDocumentation = numberOfDocumentation;
    }

    public static void AddDateCalendar(Date calendar) {

    }

    @Override
    public String toString() {
        return "TaxProcess{" + "price=" + price + ", typeOfProcess=" + typeOfProcess + ", numberOfDocumentation=" + numberOfDocumentation + '}';
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the typeOfProcess
     */
    public String getTypeOfProcess() {
        return typeOfProcess;
    }

    /**
     * @param typeOfProcess the typeOfProcess to set
     */
    public void setTypeOfProcess(String typeOfProcess) {
        this.typeOfProcess = typeOfProcess;
    }

    /**
     * @return the numberOfDocumentation
     */
    public int getNumberOfDocumentation() {
        return numberOfDocumentation;
    }

    /**
     * @param numberOfDocumentation the numberOfDocumentation to set
     */
    public void setNumberOfDocumentation(int numberOfDocumentation) {
        this.numberOfDocumentation = numberOfDocumentation;
    }

}


package ec.edu.espe.cyberplaneta.model;

import java.util.Locale;

/**
 * Represents a price list item with process ID, name, price, and tax rate.
 *
 * @autor Code Creators, DCCO-ESPE
 */
public class PriceList {

    private int processId;
    private String processName;
    private float price;
    private float taxRate;

    public PriceList(int processId, String processName, float price, float taxRate) {
        this.processId = processId;
        this.price = price;
        this.processName = processName;
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,"PriceList{processId=%d, processName=%s, price=%.2f, taxRate=%.2f}",
                processId, processName, price, taxRate); 
    }

    private static void printPriceList(PriceList[] priceList) {
        System.out.println("=======================================================================================================");
        System.out.printf("%-5s %-50s %-25s %-20s\n", "ID", "Nombre del Proceso", "Precio Base ($)", "Impuesto(%)");
        System.out.println("=======================================================================================================");
        for (PriceList item : priceList) {
            System.out.printf("%-5d %-50s %-25s %-20.2f%%\n", item.getProcessId(), item.getProcessName(),
                    item.getPrice(), item.getTaxRate());
        }
        System.out.println("=======================================================================================================");
    }

    public static void displayPriceArray() {

        PriceList[] priceList = getPriceListArray();

        PriceList.printPriceList(priceList);
    }

    public static PriceList[] getPriceListArray() {
        return new PriceList[]{
            new PriceList(1, "Declaracion de IVA en 0", 5.0f, 15f),
            new PriceList(2, "Declaracion de IVA mensual", 20.0f, 15f),
            new PriceList(3, "Declaracion de IVA semestral", 50.0f, 15f),
            new PriceList(4, "Devolucion Impuesto a la Renta", 3.5f, 15f),
            new PriceList(5, "Anexo de Accionista", 5.0f, 15f)
        };
    }

    /**
     * @return the processId
     */
    public int getProcessId() {
        return processId;
    }

    /**
     * @param processId the processId to set
     */
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    /**
     * @return the processName
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * @param processName the processName to set
     */
    public void setProcessName(String processName) {
        this.processName = processName;
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
     * @return the taxRate
     */
    public float getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

}

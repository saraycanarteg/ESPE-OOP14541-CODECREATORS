package ec.edu.espe.cyberplaneta.model;

public class PriceList {

    public static PriceList[] getPriceListArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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

    public int getProcessId() {
        return processId;
    }

    public String getProcessName() {
        return processName;
    }

    public float getPrice() {
        return price;
    }

    public float getTaxRate() {
        return taxRate;
    }
}


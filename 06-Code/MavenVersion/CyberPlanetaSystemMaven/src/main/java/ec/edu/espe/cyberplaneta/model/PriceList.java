package ec.edu.espe.cyberplaneta.model;

/**
 *
 * @author Saray Cañarte, Code Creators, DCCO-ESPE
 */
public class PriceList {

    public static PriceList[] getPriceListArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private final int id;
    private final int processId;
    private final String processName;
    private final float price;
    private final float taxRate;

    public PriceList(int id, int processId, String processName, float price, float taxRate) {
        this.id = id;
        this.processId = processId;
        this.processName = processName;
        this.price = price;
        this.taxRate = taxRate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    

    /**
     * @return the processId
     */
    public int getProcessId() {
        return processId;
    }

   

    /**
     * @return the processName
     */
    public String getProcessName() {
        return processName;
    }

   

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    

    /**
     * @return the taxRate
     */
    public float getTaxRate() {
        return taxRate;
    }

 
}
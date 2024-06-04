
package ec.edu.espe.cyberplaneta.model;

/**
 *
 * @author Code Creators,DCCO-ESPE
 */
public class PriceList {
    private int processId;
    private String processName;
    private float price;
    private float taxRate;
    
    public PriceList(int processId,String processName,float price,float taxRate) {
        this.processId = processId;
        this.price = price;
        this.processName = processName;
        this.taxRate = taxRate;     
    }

    @Override
    public String toString() {
        return "PriceList{" + "processId=" + getProcessId() + ", processName=" + getProcessName() + ", price=" + getPrice() + ", taxRate=" + getTaxRate() + '}';
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


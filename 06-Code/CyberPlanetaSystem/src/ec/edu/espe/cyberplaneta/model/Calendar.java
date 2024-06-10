
package ec.edu.espe.cyberplaneta.model;

/**
 *
 * @author Code Creators, DCCO-ESPE
 */
public class Calendar {

    private String deliveryDate;
    private String startDate;

    public Calendar(String deliveryDate, String startDate) {
        this.deliveryDate = deliveryDate;
        this.startDate = startDate;
    }

    public static void SendNotification() {

    }

    @Override
    public String toString() {
        return "{\"deliveryDate\":\"" + deliveryDate + "\",\"startDate\":\"" + startDate + "\"}";
    }

    /**
     * @return the deliveryDate
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}

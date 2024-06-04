
package ec.edu.espe.cyberplaneta.model;

import java.util.Date;

/**
 *
 * @author  Code Creators, DCCO-ESPE
 */
public class Calendar {
    private Date deliveryDate;
    private Date startDate;

    public Calendar(Date deliveryDate, Date startDate) {
        this.deliveryDate = deliveryDate;
        this.startDate = startDate;
    }
    
     public static void SendNotification(){
        
    }

    @Override
    public String toString() {
        return startDate + "," + deliveryDate;
    }
    

    /**
     * @return the deliveryDate
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    
}

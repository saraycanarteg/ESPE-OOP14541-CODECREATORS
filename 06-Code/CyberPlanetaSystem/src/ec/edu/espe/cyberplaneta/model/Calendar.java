
package ec.edu.espe.cyberplaneta.model;

import com.google.gson.Gson;
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
        return  deliveryDate +","+ startDate;
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

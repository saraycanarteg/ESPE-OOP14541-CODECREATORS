package ec.edu.espe.cyberplaneta.model;

public class Calendar {

    private String deliveryDate;

    private String startDate;

    public Calendar(String deliveryDate, String startDate) {
        this.deliveryDate = deliveryDate;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "{\"deliveryDate\":\"" + deliveryDate + "\",\"startDate\":\"" + startDate + "\"}";
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}

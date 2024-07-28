package ec.edu.espe.cyberplaneta.model;

public class TaxProcess {

    private PriceList priceList;
    private float total;

    public TaxProcess(PriceList priceList, float total) {
        this.priceList = priceList;
        this.total = total;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}


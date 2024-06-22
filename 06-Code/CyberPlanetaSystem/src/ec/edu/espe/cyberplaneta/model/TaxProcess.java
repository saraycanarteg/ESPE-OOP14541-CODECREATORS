package ec.edu.espe.cyberplaneta.model;

public class TaxProcess {

    public int id;

    public String name;

    public float basePrice;

    public float tax;

    public float total;

    public TaxProcess(int id, String name, float basePrice, float tax, float total) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.tax = tax;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}

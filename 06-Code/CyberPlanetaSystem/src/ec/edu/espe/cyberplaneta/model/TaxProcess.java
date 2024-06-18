package ec.edu.espe.cyberplaneta.model;


/**
 *
 * @author Code Creators, DCCO-ESPE
 */
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

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the basePrice
         */
        public float getBasePrice() {
            return basePrice;
        }

        /**
         * @param basePrice the basePrice to set
         */
        public void setBasePrice(float basePrice) {
            this.basePrice = basePrice;
        }

        /**
         * @return the tax
         */
        public float getTax() {
            return tax;
        }

        /**
         * @param tax the tax to set
         */
        public void setTax(float tax) {
            this.tax = tax;
        }

        /**
         * @return the total
         */
        public float getTotal() {
            return total;
        }

        /**
         * @param total the total to set
         */
        public void setTotal(float total) {
            this.total = total;
        }
 
}

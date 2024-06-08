package ec.edu.espe.cyberplaneta.model;

import com.google.gson.Gson;


/**
 *
 * @author Code Creators,DCCO-ESPE
 */
public class TaxPayer {

    private String id;
    private String email;
    private String name;
    private String password;
    private boolean accountingDocumentation;
    private Calendar calendar;

    public TaxPayer(String id, String email, String name, String password, boolean accountingDocumentation, Calendar calendar) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.accountingDocumentation = accountingDocumentation;
        this.calendar = calendar;
    }
    
    public String getDeliveryDate() {
        return getCalendar().getDeliveryDate();
    }

    public String getStartDate() {
        return getCalendar().getStartDate();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return  gson.toJson(TaxPayer.this);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the accountingDocumentation
     */
    public boolean isAccountingDocumentation() {
        return accountingDocumentation;
    }

    /**
     * @param accountingDocumentation the accountingDocumentation to set
     */
    public void setAccountingDocumentation(boolean accountingDocumentation) {
        this.accountingDocumentation = accountingDocumentation;
    }

    /**
     * @return the calendar
     */
    public Calendar getCalendar() {
        return calendar;
    }

    /**
     * @param calendar the calendar to set
     */
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
   
}

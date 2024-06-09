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
        this.calendar = (calendar != null) ? calendar : new Calendar("", "");
    }
    
    public String getDeliveryDate() {
        return (calendar != null && calendar.getDeliveryDate() != null) ? calendar.getDeliveryDate() : "No date";
    }

    public String getStartDate() {
        return (calendar != null && calendar.getStartDate() != null) ? calendar.getStartDate() : "No date";
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountingDocumentation() {
        return accountingDocumentation;
    }

    public void setAccountingDocumentation(boolean accountingDocumentation) {
        this.accountingDocumentation = accountingDocumentation;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}

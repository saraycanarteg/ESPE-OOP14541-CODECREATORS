package ec.edu.espe.cyberplaneta.model;

import java.util.Date;

public class TaxPayer {

    private String id;
    private String email;
    private String name;
    private String password;
    private boolean accountingDocumentation;
    private String startDate; // Campo para la fecha de inicio
    private String deliveryDate
;   // Campo para la fecha de finalización

    public TaxPayer(String id, String email, String name, String password, boolean accountingDocumentation, String startDate, String deliveryDate
) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.accountingDocumentation = accountingDocumentation;
        this.startDate = startDate;
        this.deliveryDate = deliveryDate;
    }

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getdeliveryDate() {
        return deliveryDate;
    }

    public void setdeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}



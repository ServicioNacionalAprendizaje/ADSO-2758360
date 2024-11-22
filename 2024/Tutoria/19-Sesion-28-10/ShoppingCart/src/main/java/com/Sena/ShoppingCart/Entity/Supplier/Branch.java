package com.Sena.ShoppingCart.Entity.Supplier;

import com.Sena.ShoppingCart.Entity.ABaseEntity;
import com.Sena.ShoppingCart.Entity.Security.Person;
import jakarta.persistence.*;

@Entity
@Table(name = "branch")
public class Branch extends ABaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 15)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "responsible_id", nullable = false)
    private Person responsibleId;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company companyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(Person responsibleId) {
        this.responsibleId = responsibleId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }
}
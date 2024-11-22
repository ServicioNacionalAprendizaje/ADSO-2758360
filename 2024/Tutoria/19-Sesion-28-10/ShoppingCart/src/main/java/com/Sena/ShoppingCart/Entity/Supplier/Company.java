package com.Sena.ShoppingCart.Entity.Supplier;

import com.Sena.ShoppingCart.Entity.ABaseEntity;
import com.Sena.ShoppingCart.Entity.Security.Person;
import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company extends ABaseEntity {

    @Column(name = "nit", nullable = false, unique = true, length = 20)
    private String nit;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 15)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Person managerId;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

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

    public Person getManagerId() {
        return managerId;
    }

    public void setManagerId(Person managerId) {
        this.managerId = managerId;
    }
}
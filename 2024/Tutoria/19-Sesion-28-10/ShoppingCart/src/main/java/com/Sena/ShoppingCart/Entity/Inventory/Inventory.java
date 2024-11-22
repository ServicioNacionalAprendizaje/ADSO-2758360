package com.Sena.ShoppingCart.Entity.Inventory;

import com.Sena.ShoppingCart.Entity.ABaseEntity;
import com.Sena.ShoppingCart.Entity.Supplier.Branch;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "inventory")
public class Inventory extends ABaseEntity {

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "purchase_value", nullable = false)
    private Double purchaseValue;

    @Column(name = "sale_value", nullable = false)
    private Double saleValue;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branchId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(Double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public Double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Double saleValue) {
        this.saleValue = saleValue;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
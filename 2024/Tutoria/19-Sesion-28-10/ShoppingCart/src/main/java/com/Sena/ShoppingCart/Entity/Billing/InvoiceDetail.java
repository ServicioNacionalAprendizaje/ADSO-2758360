package com.Sena.ShoppingCart.Entity.Billing;

import com.Sena.ShoppingCart.Entity.ABaseEntity;
import com.Sena.ShoppingCart.Entity.Inventory.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail extends ABaseEntity {

    @Column(name = "gross_value", nullable = false)
    private Double grossValue;

    @Column(name = "net_value", nullable = false)
    private Double netValue;

    @Column(name = "discount_percentage", nullable = false)
    private Double discountPercentage;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    public Double getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(Double grossValue) {
        this.grossValue = grossValue;
    }

    public Double getNetValue() {
        return netValue;
    }

    public void setNetValue(Double netValue) {
        this.netValue = netValue;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}
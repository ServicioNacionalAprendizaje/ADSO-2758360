package com.Sena.ShoppingCart.Entity.Billing;

import com.Sena.ShoppingCart.Entity.ABaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "invoice")
public class Invoice extends ABaseEntity {

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "gross_value", nullable = false)
    private Double grossValue;

    @Column(name = "net_value", nullable = false)
    private Double netValue;

    @Column(name = "discount_value", nullable = false)
    private Double discountValue;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethodId;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

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

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public PaymentMethod getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethod paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
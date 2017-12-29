package com.epam.travelagency.entity;

import javax.persistence.*;

@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Integer amount;

    public Discount() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountID=" + id +
                ", discountType='" + type + '\'' +
                ", discountAmount=" + amount +
                '}';
    }
}

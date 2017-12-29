package com.epam.travelagency.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Date payment;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPayment() {
        return payment;
    }

    public void setPayment(Date payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return this.status.name();
    }

    public void setStatus(String status) {
        this.status = OrderStatus.valueOf(status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + id +
                ", orderDate=" + date +
                ", orderPayment=" + payment +
                ", orderStatus=" + status +
                '}';
    }
}

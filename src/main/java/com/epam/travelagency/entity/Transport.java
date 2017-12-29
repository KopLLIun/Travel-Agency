package com.epam.travelagency.entity;

import javax.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransportType type;

    public Transport() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type.name();
    }

    public void setType(String type) {
        this.type = TransportType.valueOf(type);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "transportID=" + id +
                "transportType" + type +
                '}';
    }
}

package com.epam.travelagency.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransportType type;

    @OneToMany(mappedBy = "transport", fetch = FetchType.EAGER)
    private List<Tour> tours;

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

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "transportID=" + id +
                "transportType" + type +
                '}';
    }
}

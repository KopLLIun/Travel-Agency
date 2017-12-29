package com.epam.travelagency.entity;

import javax.persistence.*;

@Entity
@Table(name = "stay_place")
public class StayPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public StayPlace() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StayPlace{" +
                "stayPlaceID=" + id +
                ", namePlace='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.epam.travelagency.entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String meals;

    @Column(name = "star_numbers")
    private int starNumbers;

    public Hotel() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public int getStarNumbers() {
        return starNumbers;
    }

    public void setStarNumbers(int starNumbers) {
        this.starNumbers = starNumbers;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelID=" + id +
                ", hotelName='" + name + '\'' +
                ", hotelAddress='" + address + '\'' +
                ", meals='" + meals + '\'' +
                ", starNumbers=" + starNumbers +
                '}';
    }
}

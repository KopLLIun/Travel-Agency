package com.epam.travelagency.entity;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "hotel")
    private List<Tour> tours;

/*    @ManyToMany
    @JoinTable(name = "tour_hotel", joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_id"))
    private List<Tour> tours;*/

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
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

package com.epam.travelagency.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TourType type;

    private String name;
    private Date date;
    private Integer duration;
    private Integer cost;
    private String description;

    @OneToMany(mappedBy = "tour")
    private List<Contract> orders;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

/*    @ManyToMany(mappedBy = "tours")
    private List<Hotel> hotels;*/

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Tour() {

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTourType() {
        return this.type.name();
    }

    public void setTourType(String tourType) {
        this.type = TourType.valueOf(tourType);
    }

    public List<Contract> getOrders() {
        return orders;
    }

    public void setOrders(List<Contract> orders) {
        this.orders = orders;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /*    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }*/

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourID=" + id +
                ", tourName='" + name + '\'' +
                ", date=" + date +
                ", tourDuration=" + duration +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", toutType=" + type +
                '}';
    }
}

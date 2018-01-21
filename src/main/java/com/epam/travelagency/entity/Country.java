package com.epam.travelagency.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<City> cities;

    @OneToMany(mappedBy = "country")
    private List<Tour> tours;

    public Country() {

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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        String city = "";
        if ((cities != null) && (cities.size() > 0)) {
            for (int i = 0; i < cities.size(); i++) {
                if (i > 0)
                    city += ",";
                city += cities.get(i).toString();
            }
        }
        return "Country{" +
                "countryID=" + id +
                ", countryName='" + name + '\'' +
                ", cities =[" + city + "]" +
                '}';
    }
}

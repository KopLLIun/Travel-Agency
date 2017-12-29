package com.epam.travelagency.entity;

import javax.persistence.*;
import java.util.Date;

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

    @Override
    public String toString() {
        return "Tour{" +
                "tourID=" + id +
                ", tourName='" + name + '\'' +
                ", date=" + date +
                ", tourDuration=" + duration +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", toutType" + type +
                '}';
    }
}

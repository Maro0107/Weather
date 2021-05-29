package com.sda.weather;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String location;
    @JsonIgnore
    private Instant createdLocation;

    public Entry() {
    }

    public Entry(String location) {

        this.location = location;
    }

    public Entry(String location, Instant createdLocation) {

        this.location = location;
        this.createdLocation = createdLocation;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public void setCreatedLocation(Instant createdLocation) {
        this.createdLocation = createdLocation;
    }

    public String getLocation() {
        return location;
    }

    public Instant getCreatedLocation() {
        return createdLocation;
    }
}

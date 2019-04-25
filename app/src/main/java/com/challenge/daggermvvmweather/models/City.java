
package com.challenge.daggermvvmweather.models;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class City {

    @Expose
    private Coord coord;
    @Expose
    private String country;
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private Long population;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

}

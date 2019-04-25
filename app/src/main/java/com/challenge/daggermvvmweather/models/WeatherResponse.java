
package com.challenge.daggermvvmweather.models;

import com.google.gson.annotations.Expose;

import java.util.List;

@SuppressWarnings("unused")
public class WeatherResponse {

    @Expose
    private City city;
    @Expose
    private Long cnt;
    @Expose
    private String cod;
    @Expose
    private List<WeatherResult> list;
    @Expose
    private Double message;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public java.util.List<WeatherResult> getList() {
        return list;
    }

    public void setList(List<WeatherResult> list) {
        this.list = list;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

}

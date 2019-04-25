
package com.challenge.daggermvvmweather.models;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class WeatherResult {

    @Expose
    private Long clouds;
    @Expose
    private Long deg;
    @Expose
    private Long dt;
    @Expose
    private Long humidity;
    @Expose
    private Double pressure;
    @Expose
    private Double speed;
    @Expose
    private Temp temp;
    @Expose
    private java.util.List<Weather> weather;

    public Long getClouds() {
        return clouds;
    }

    public void setClouds(Long clouds) {
        this.clouds = clouds;
    }

    public Long getDeg() {
        return deg;
    }

    public void setDeg(Long deg) {
        this.deg = deg;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

}

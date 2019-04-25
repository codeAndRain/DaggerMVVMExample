
package com.challenge.daggermvvmweather.models;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Temp {

    @Expose
    private Double day;
    @Expose
    private Double eve;
    @Expose
    private Double max;
    @Expose
    private Double min;
    @Expose
    private Double morn;
    @Expose
    private Double night;

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public Double getEve() {
        return eve;
    }

    public void setEve(Double eve) {
        this.eve = eve;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMorn() {
        return morn;
    }

    public void setMorn(Double morn) {
        this.morn = morn;
    }

    public Double getNight() {
        return night;
    }

    public void setNight(Double night) {
        this.night = night;
    }

}

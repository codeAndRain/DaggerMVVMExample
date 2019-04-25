package com.challenge.daggermvvmweather.data;

import com.challenge.daggermvvmweather.common.Constants;
import com.challenge.daggermvvmweather.models.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteDataSource {

    private final WeatherService weatherService;

    @Inject
    public RemoteDataSource(WeatherService weatherService) {
        this.weatherService = weatherService;

    }

    Single<WeatherResponse> getWeather() {
        return weatherService.getWeather(Constants.APPID, Constants.ZIP,
                Constants.MODE, Constants.UNIT, Constants.CNT);
    }
}

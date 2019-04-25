package com.challenge.daggermvvmweather.data;

import com.challenge.daggermvvmweather.models.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class Repository {

    private final RemoteDataSource remoteDataSource;

    @Inject
    public Repository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public Single<WeatherResponse> getWeather() {
        return remoteDataSource.getWeather();
    }
}

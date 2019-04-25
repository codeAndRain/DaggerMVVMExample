package com.challenge.daggermvvmweather.data;

import com.challenge.daggermvvmweather.common.Constants;
import com.challenge.daggermvvmweather.models.WeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET(Constants.RELATIVE_URL)
    Single<WeatherResponse> getWeather(@Query("APPID") String appId,
                                       @Query("zip") String zip,
                                       @Query("mode") String mode,
                                       @Query("units") String unit,
                                       @Query("cnt") int count);
}

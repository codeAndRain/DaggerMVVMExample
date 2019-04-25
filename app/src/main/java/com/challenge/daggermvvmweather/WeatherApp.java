package com.challenge.daggermvvmweather;

import android.app.Application;
import android.content.Context;

import com.challenge.daggermvvmweather.di.components.DaggerWeatherAppComponent;
import com.challenge.daggermvvmweather.di.components.WeatherAppComponent;
import com.challenge.daggermvvmweather.di.modules.WeatherAppModule;

public class WeatherApp extends Application {

    private WeatherAppComponent appcomponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appcomponent = DaggerWeatherAppComponent.builder()
                .weatherAppModule(new WeatherAppModule(this))
                .build();
    }

    public static WeatherApp getInstance(Context context) {
        return (WeatherApp) context.getApplicationContext();
    }

    public WeatherAppComponent getAppcomponent() {
        return appcomponent;
    }
}

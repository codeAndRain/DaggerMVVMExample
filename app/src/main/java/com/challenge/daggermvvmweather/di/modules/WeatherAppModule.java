package com.challenge.daggermvvmweather.di.modules;

import android.content.Context;

import com.challenge.daggermvvmweather.WeatherApp;
import com.challenge.daggermvvmweather.di.scopes.AppScope;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class WeatherAppModule {

    private final WeatherApp appContext;

    public WeatherAppModule(WeatherApp appContext) {
        this.appContext = appContext;
    }

    @Provides
    @AppScope
    Context provideContext() {
        return appContext;
    }

    @Provides
    @AppScope
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}

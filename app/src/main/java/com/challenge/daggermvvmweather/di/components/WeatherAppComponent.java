package com.challenge.daggermvvmweather.di.components;

import android.content.Context;

import com.challenge.daggermvvmweather.data.RemoteDataSource;
import com.challenge.daggermvvmweather.data.Repository;
import com.challenge.daggermvvmweather.data.WeatherService;
import com.challenge.daggermvvmweather.di.modules.NetworkModule;
import com.challenge.daggermvvmweather.di.modules.WeatherAppModule;
import com.challenge.daggermvvmweather.di.scopes.AppScope;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

@AppScope
@Component(modules = {WeatherAppModule.class, NetworkModule.class})
public interface WeatherAppComponent {

    Context context();
    CompositeDisposable compositeDisposable();
    Repository repository();
    RemoteDataSource remoteDataSource();
    WeatherService weatherService();
}

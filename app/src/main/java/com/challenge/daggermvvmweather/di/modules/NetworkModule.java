package com.challenge.daggermvvmweather.di.modules;

import com.challenge.daggermvvmweather.common.Constants;
import com.challenge.daggermvvmweather.data.RemoteDataSource;
import com.challenge.daggermvvmweather.data.Repository;
import com.challenge.daggermvvmweather.data.WeatherService;
import com.challenge.daggermvvmweather.di.scopes.AppScope;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @AppScope
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    @Provides
    @AppScope
    WeatherService provideWeatherService(Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }

    @Provides
    @AppScope
    RemoteDataSource provideRemoteDataSource(WeatherService weatherService) {
        return new RemoteDataSource(weatherService);
    }

    @Provides
    @AppScope
    Repository provideRepository(RemoteDataSource remoteDataSource) {
        return new Repository(remoteDataSource);
    }
}

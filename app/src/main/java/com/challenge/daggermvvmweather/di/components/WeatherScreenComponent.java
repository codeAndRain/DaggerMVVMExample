package com.challenge.daggermvvmweather.di.components;

import com.challenge.daggermvvmweather.di.modules.ViewModelModule;
import com.challenge.daggermvvmweather.di.modules.WeatherScreenModule;
import com.challenge.daggermvvmweather.di.scopes.ActivityScope;
import com.challenge.daggermvvmweather.ui.WeatherScreenActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = WeatherAppComponent.class, modules = {WeatherScreenModule.class, ViewModelModule.class})
public interface WeatherScreenComponent {

    void inject(WeatherScreenActivity activity);
}

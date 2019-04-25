package com.challenge.daggermvvmweather.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.challenge.daggermvvmweather.di.viewmodel.ViewModelFactory;
import com.challenge.daggermvvmweather.di.viewmodel.ViewModelKey;
import com.challenge.daggermvvmweather.ui.WeatherScreenViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(WeatherScreenViewModel.class)
    abstract ViewModel bindWeatherScreenViewModel(WeatherScreenViewModel weatherScreenViewModel);

    // other viewModel in the application should go here.
}

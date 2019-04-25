package com.challenge.daggermvvmweather.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.challenge.daggermvvmweather.R;
import com.challenge.daggermvvmweather.WeatherApp;
import com.challenge.daggermvvmweather.di.components.DaggerWeatherScreenComponent;
import com.challenge.daggermvvmweather.di.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherScreenActivity extends AppCompatActivity {

    private WeatherScreenViewModel viewModel;
    private WeatherAdapter adapter;

    @Inject
    ViewModelFactory viewModelFactory;
    @BindView(R.id.circular_progress)
    ProgressBar circularProgressBar;
    @BindView(R.id.weather_recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInjection();
        initView();

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WeatherScreenViewModel.class);
        viewModel.getWeather();

        showState();

    }

    private void initInjection() {
        DaggerWeatherScreenComponent.builder()
                .weatherAppComponent(WeatherApp.getInstance(this).getAppcomponent())
                .build().inject(this);
    }

    private void initView() {
        ButterKnife.bind(this);
        adapter = new WeatherAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    private void showState() {
        // handle errors
        viewModel.getErrorMessageLiveData().observe(this, message -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());

        // loading state
        viewModel.getLoadingStateLiveData().observe(this, isLoading -> circularProgressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE));

        // show data
        viewModel.getWeatherResultsLiveData().observe(this, weatherResults -> adapter.setWeatherResultList(weatherResults));
    }
}

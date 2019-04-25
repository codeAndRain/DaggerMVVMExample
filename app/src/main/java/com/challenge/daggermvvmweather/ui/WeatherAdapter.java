package com.challenge.daggermvvmweather.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.challenge.daggermvvmweather.R;
import com.challenge.daggermvvmweather.models.WeatherResult;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    private List<WeatherResult> weatherResultList = new ArrayList<>();

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.weather_recycler_item, parent,false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherResult weatherResult = weatherResultList.get(position);
        holder.bind(weatherResult);
    }

    @Override
    public int getItemCount() {
        return weatherResultList.size();
    }

    public void setWeatherResultList(List<WeatherResult> items) {
        if (!weatherResultList.isEmpty()) {
            weatherResultList.clear();
        }
        weatherResultList.addAll(items);
        notifyDataSetChanged();
    }
}

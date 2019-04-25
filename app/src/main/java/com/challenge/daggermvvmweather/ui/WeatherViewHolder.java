package com.challenge.daggermvvmweather.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.challenge.daggermvvmweather.R;
import com.challenge.daggermvvmweather.models.WeatherResult;

import butterknife.BindView;
import butterknife.ButterKnife;

class WeatherViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.description_text)
    TextView descriptionText;
    @BindView(R.id.min_temp)
    TextView minTempText;
    @BindView(R.id.max_temp)
    TextView maxTempText;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(WeatherResult weatherResult) {
        descriptionText.setText(weatherResult.getWeather().get(0).getDescription());
        minTempText.setText(String.valueOf(weatherResult.getTemp().getMin()));
        maxTempText.setText(String.valueOf(weatherResult.getTemp().getMax()));
    }
}

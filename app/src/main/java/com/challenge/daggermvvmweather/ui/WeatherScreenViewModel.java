package com.challenge.daggermvvmweather.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.challenge.daggermvvmweather.data.Repository;
import com.challenge.daggermvvmweather.models.WeatherResponse;
import com.challenge.daggermvvmweather.models.WeatherResult;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeatherScreenViewModel extends ViewModel {

    private final Repository repository;
    private final CompositeDisposable compositeDisposable;

    private MutableLiveData<List<WeatherResult>> weatherResultsLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorMessageLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingStateLiveData = new MutableLiveData<>();


    @Inject
    public WeatherScreenViewModel(Repository repository, CompositeDisposable compositeDisposable) {
        this.repository = repository;
        this.compositeDisposable = compositeDisposable;
    }

    public void getWeather() {
        addDisposable(repository.getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> loadingStateLiveData.setValue(true))
                .doFinally(() -> loadingStateLiveData.setValue(false))
                .map(WeatherResponse::getList)
                .subscribe(weatherResults -> weatherResultsLiveData.setValue(weatherResults),
                        throwable -> errorMessageLiveData.setValue(throwable.getLocalizedMessage())));
    }

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public MutableLiveData<List<WeatherResult>> getWeatherResultsLiveData() {
        return weatherResultsLiveData;
    }

    public MutableLiveData<String> getErrorMessageLiveData() {
        return errorMessageLiveData;
    }

    public MutableLiveData<Boolean> getLoadingStateLiveData() {
        return loadingStateLiveData;
    }
}

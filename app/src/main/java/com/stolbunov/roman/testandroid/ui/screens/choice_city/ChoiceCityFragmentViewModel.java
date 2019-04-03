package com.stolbunov.roman.testandroid.ui.screens.choice_city;

import com.stolbunov.roman.domain.entity.City;
import com.stolbunov.roman.domain.entity.Country;
import com.stolbunov.roman.domain.use_case.ILovecityUseCase;
import com.stolbunov.roman.testandroid.logger.Logger;
import com.stolbunov.roman.testandroid.utils.Rx.RxLiveData;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ChoiceCityFragmentViewModel extends ViewModel {
    private static final int SPINNER_HINT_POSITION = 0;

    private final ILovecityUseCase iLovecityUseCase;
    private final CompositeDisposable composite = new CompositeDisposable();

    private final MutableLiveData<List<Country>> countriesLD = new MutableLiveData<>();
    private final MutableLiveData<List<City>> citiesBySelectedCountryLD = new MutableLiveData<>();

    private final MutableLiveData<Integer> positionSelectedCountryLD = new MutableLiveData<>();
    private final MutableLiveData<Integer> positionSelectedCityLD = new MutableLiveData<>();

    private final MutableLiveData<Integer> positionSelectedCityResultLD = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isCorrectSelectedData = new MutableLiveData<>();

    @Inject
    public ChoiceCityFragmentViewModel(ILovecityUseCase iLovecityUseCase) {
        this.iLovecityUseCase = iLovecityUseCase;

        fillingLiveDataDefaultValues();
        requestCountry();
        observeChangesPositionSelectedCountry();
        observeCorrectSelectedData();
    }

    private void fillingLiveDataDefaultValues() {
        positionSelectedCountryLD.setValue(-1);
        positionSelectedCityLD.setValue(-1);
        isCorrectSelectedData.setValue(false);
    }

    private void observeChangesPositionSelectedCountry() {
        positionSelectedCountryLD.observeForever(this::getCitiesByPositionSelectedCountry);
    }

    private void requestCountry() {
        composite.add(iLovecityUseCase
                .getCitiesList()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        countriesLD::postValue,
                        this::errorHandling));
    }

    private void observeCorrectSelectedData() {
        composite.add(Observable.combineLatest(
                RxLiveData.liveDateToRx(positionSelectedCountryLD)
                        .observeOn(Schedulers.computation()),
                RxLiveData.liveDateToRx(positionSelectedCityLD)
                        .observeOn(Schedulers.computation()),
                (positionCountry, positionCity) -> (positionCountry >= 0) && (positionCity >= 0))
                .subscribe(
                        isCorrectSelectedData::postValue,
                        this::errorHandling));
    }

    private void getCitiesByPositionSelectedCountry(Integer position) {
        List<Country> countries = countriesLD.getValue();
        if (countries != null && position >= 0) {
            citiesBySelectedCountryLD.setValue(countries.get(position).getCities());
        }
    }

    private void errorHandling(Throwable throwable) {
        Logger.e(getClass().getSimpleName(), throwable);
    }

    public void createResult() {
        List<City> cities = citiesBySelectedCountryLD.getValue();
        Integer selectedPosition = positionSelectedCityLD.getValue();
        if (cities != null && selectedPosition != null) {
            positionSelectedCityResultLD.setValue(cities.get(selectedPosition).getId());
        }
    }

    public void setPositionOfSelectedCountry(int position) {
        if (position == SPINNER_HINT_POSITION) {
            positionSelectedCountryLD.setValue(-1);
            citiesBySelectedCountryLD.setValue(Collections.emptyList());
        } else {
            positionSelectedCountryLD.setValue(position - 1);
        }
    }

    public void setPositionOfSelectedCity(int position) {
        if (position == SPINNER_HINT_POSITION) {
            positionSelectedCityLD.setValue(-1);
        } else {
            positionSelectedCityLD.setValue(position - 1);
        }
    }

    public int getPositionSelectedCountry() {
        Integer position = positionSelectedCountryLD.getValue();
        return (position >= 0) ? (position + 1) : 0;
    }

    public int getPositionSelectedCity() {
        Integer position = positionSelectedCityLD.getValue();
        return (position >= 0) ? (position + 1) : 0;
    }

    public LiveData<List<Country>> getCountriesLD() {
        return countriesLD;
    }

    public LiveData<List<City>> getCitiesBySelectedCountryLD() {
        return citiesBySelectedCountryLD;
    }

    public LiveData<Boolean> getIsCorrectSelectedData() {
        return isCorrectSelectedData;
    }

    public LiveData<Integer> getPositionSelectedCityResultLD() {
        return positionSelectedCityResultLD;
    }
}
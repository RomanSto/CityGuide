package com.stolbunov.roman.testandroid.ui.screens.choice_organization;

import com.google.android.gms.maps.model.MarkerOptions;
import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;
import com.stolbunov.roman.domain.use_case.ILovecityUseCase;
import com.stolbunov.roman.testandroid.logger.Logger;
import com.stolbunov.roman.testandroid.utils.Rx.RxLiveData;
import com.stolbunov.roman.testandroid.utils.mapper.Mapper;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ChoiceOrganizationViewModel extends ViewModel {
    private final ILovecityUseCase useCase;
    private final CompositeDisposable composite = new CompositeDisposable();

    private final MutableLiveData<Integer> idSelectedCityLD = new MutableLiveData<>();
    private final MutableLiveData<Integer> idSelectedCategoryLD = new MutableLiveData<>();
    private final MutableLiveData<List<OrganizationMinInfo>> organizationsLD = new MutableLiveData<>();
    private final MutableLiveData<List<MarkerOptions>> mapMarkers = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        super.onCleared();
        composite.dispose();
    }

    @Inject
    public ChoiceOrganizationViewModel(ILovecityUseCase useCase) {
        this.useCase = useCase;

        createMapMarkers();
    }

    public void setSelectedId(int idCity, int idCategory) {
        idSelectedCityLD.setValue(idCity);
        idSelectedCategoryLD.setValue(idCategory);
        requestOrganizationByCategoryId(idCity, idCategory);
    }

    private void requestOrganizationByCategoryId(int idCity, int idCategory) {
        composite.add(useCase.getOrganizations(idCity, idCategory)
                .subscribeOn(Schedulers.io())
                .subscribe(organizationsLD::postValue, this::errorHandling));
    }

    private void createMapMarkers() {
        composite.add(RxLiveData
                .liveDateToRx(organizationsLD)
                .observeOn(Schedulers.computation())
                .map(Mapper::transformToMapMarkers)
                .subscribe(
                        mapMarkers::postValue,
                        this::errorHandling));
    }

    private void errorHandling(Throwable throwable) {
        Logger.e(getClass().getSimpleName(), throwable);
    }

    public LiveData<List<OrganizationMinInfo>> getOrganizationsLD() {
        return organizationsLD;
    }

    public LiveData<List<MarkerOptions>> getMapMarkers() {
        return mapMarkers;
    }
}

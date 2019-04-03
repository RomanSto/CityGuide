package com.stolbunov.roman.testandroid.ui.screens.choice_category;

import com.stolbunov.roman.domain.entity.Category;
import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;
import com.stolbunov.roman.domain.use_case.ILovecityUseCase;
import com.stolbunov.roman.testandroid.entity.CategoryForAdapter;
import com.stolbunov.roman.testandroid.logger.Logger;
import com.stolbunov.roman.testandroid.utils.Rx.RxLiveData;
import com.stolbunov.roman.testandroid.utils.mapper.Mapper;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ChoiceCategoryViewModel extends ViewModel {
    private final ILovecityUseCase useCase;
    private final CompositeDisposable composite = new CompositeDisposable();

    private final MutableLiveData<Integer> selectedCityIdLD = new MutableLiveData<>();
    private final MutableLiveData<List<Category>> categoriesLD = new MutableLiveData<>();
    private final MutableLiveData<List<OrganizationMinInfo>> organizationLD = new MutableLiveData<>();
    private final MutableLiveData<List<CategoryForAdapter>> categoriesForAdapterLD = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        super.onCleared();
        composite.dispose();
    }

    @Inject
    public ChoiceCategoryViewModel(ILovecityUseCase useCase) {
        this.useCase = useCase;

        requestCategories();
        observeChangesIdSelectedCity();
        observeCorrectAdapterData();
    }

    public void setSelectedCityId(int idCity) {
        selectedCityIdLD.setValue(idCity);
    }

    private void observeChangesIdSelectedCity() {
        selectedCityIdLD.observeForever(this::requestOrganizationByCityId);
    }

    private void requestCategories() {
        composite.add(useCase.getCategories()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        categoriesLD::postValue,
                        this::errorHandling));
    }

    private void requestOrganizationByCityId(int idCity) {
        composite.add(useCase.getOrganizationsByCity(idCity)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        organizationLD::postValue,
                        this::errorHandling));
    }

    private void observeCorrectAdapterData() {
        composite.add(Observable.combineLatest(
                RxLiveData.liveDateToRx(categoriesLD)
                        .observeOn(Schedulers.computation()),
                RxLiveData.liveDateToRx(organizationLD)
                        .observeOn(Schedulers.computation()),
                Mapper::transformToCategoryForAdapterList)
                .subscribe(
                        categoriesForAdapterLD::postValue,
                        this::errorHandling));
    }

    private void errorHandling(Throwable throwable) {
        Logger.e(getClass().getSimpleName(), throwable);
    }

    public LiveData<List<CategoryForAdapter>> getCategoriesForAdapterLD() {
        return categoriesForAdapterLD;
    }

    public Integer getSelectedCityId() {
        return selectedCityIdLD.getValue();
    }
}

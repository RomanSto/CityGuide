package com.stolbunov.roman.testandroid.ui.screens.choice_city;

import android.net.Uri;

import com.stolbunov.roman.domain.use_case.IAppPreferencesUseCase;
import com.stolbunov.roman.testandroid.logger.Logger;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NavigationViewModel extends ViewModel {
    private final IAppPreferencesUseCase iAppPreferencesUseCase;
    private final CompositeDisposable composite = new CompositeDisposable();

    private final MutableLiveData<Uri> userImageUriLD = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        super.onCleared();
        composite.dispose();
    }

    @Inject
    public NavigationViewModel(IAppPreferencesUseCase iAppPreferencesUseCase) {
        this.iAppPreferencesUseCase = iAppPreferencesUseCase;

        getUserImage();
    }

    void setUserImagePath(Uri uri) {
        saveUserImagePath(uri);
    }

    private void saveUserImagePath(Uri uri) {
        composite.add(iAppPreferencesUseCase
                .saveUserIconPath(uri)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        () -> userImageUriLD.postValue(uri),
                        this::errorHandling));
    }

    private void getUserImage() {
        composite.add(iAppPreferencesUseCase
                .getUserIconPath()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        userImageUriLD::postValue,
                        this::errorHandling));
    }

    private void errorHandling(Throwable throwable) {
        Logger.e(getClass().getSimpleName(), throwable);
    }

    public LiveData<Uri> getUserImageUriLD() {
        return userImageUriLD;
    }
}
package com.stolbunov.roman.testandroid.ui.screens.choice_city;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NavigationViewModelFactory implements ViewModelProvider.Factory {
    private final Provider<NavigationViewModel> provider;

    @Inject
    public NavigationViewModelFactory(Provider<NavigationViewModel> provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel viewModel;
        if (modelClass == NavigationViewModel.class) {
            viewModel = provider.get();
        } else {
            throw new RuntimeException("Unsupported view model class: " + modelClass);
        }
        //noinspection unchecked
        return (T) viewModel;
    }
}

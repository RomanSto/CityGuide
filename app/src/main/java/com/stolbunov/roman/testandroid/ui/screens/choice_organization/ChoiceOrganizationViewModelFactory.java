package com.stolbunov.roman.testandroid.ui.screens.choice_organization;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ChoiceOrganizationViewModelFactory implements ViewModelProvider.Factory {
    private Provider<ChoiceOrganizationViewModel> provider;

    @Inject
    public ChoiceOrganizationViewModelFactory(Provider<ChoiceOrganizationViewModel> provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel viewModel;
        if (modelClass == ChoiceOrganizationViewModel.class) {
            viewModel = provider.get();
        } else {
            throw new RuntimeException("Unsupported view model class: " + modelClass);
        }
        //noinspection unchecked
        return (T) viewModel;
    }
}

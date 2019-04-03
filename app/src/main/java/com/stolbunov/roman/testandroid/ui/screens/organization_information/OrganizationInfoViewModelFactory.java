package com.stolbunov.roman.testandroid.ui.screens.organization_information;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class OrganizationInfoViewModelFactory implements ViewModelProvider.Factory {
    private Provider<OrganizationInfoViewModel> provider;

    @Inject
    public OrganizationInfoViewModelFactory(Provider<OrganizationInfoViewModel> provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel viewModel;
        if (modelClass == OrganizationInfoViewModel.class) {
            viewModel = provider.get();
        } else {
            throw new RuntimeException("Unsupported view model class: " + modelClass);
        }
        //noinspection unchecked
        return (T) viewModel;
    }
}

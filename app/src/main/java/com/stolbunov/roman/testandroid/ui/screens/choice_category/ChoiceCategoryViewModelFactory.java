package com.stolbunov.roman.testandroid.ui.screens.choice_category;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ChoiceCategoryViewModelFactory implements ViewModelProvider.Factory {
    private Provider<ChoiceCategoryViewModel> provider;

    @Inject
    public ChoiceCategoryViewModelFactory(Provider<ChoiceCategoryViewModel> provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel viewModel;
        if (modelClass == ChoiceCategoryViewModel.class) {
            viewModel = provider.get();
        } else {
            throw new RuntimeException("Unsupported view model class: " + modelClass);
        }
        //noinspection unchecked
        return (T) viewModel;
    }
}

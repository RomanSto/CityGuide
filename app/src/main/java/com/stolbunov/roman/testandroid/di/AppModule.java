package com.stolbunov.roman.testandroid.di;

import com.stolbunov.roman.data.repository.lovecity_api.NetworkService;
import com.stolbunov.roman.testandroid.di.scope.AppScope;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.ChoiceOrganizationViewModel;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.ChoiceOrganizationViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @AppScope
    @Provides
    NetworkService provideNetworkService() {
        return new NetworkService();
    }
}

package com.stolbunov.roman.testandroid.di;

import com.stolbunov.roman.data.repository.AppPreferences;
import com.stolbunov.roman.data.repository.RepositoryManager;
import com.stolbunov.roman.domain.repository.IAppPreferencesRepository;
import com.stolbunov.roman.domain.repository.ILovecityRepository;
import com.stolbunov.roman.domain.use_case.IAppPreferencesUseCase;
import com.stolbunov.roman.domain.use_case.ILovecityUseCase;
import com.stolbunov.roman.domain.use_case.LovecityInteraptor;

import dagger.Binds;
import dagger.Module;

@Module
public interface DomainModule {

    @Binds
    ILovecityUseCase provideLovecityUseCase(LovecityInteraptor interaptor);

    @Binds
    ILovecityRepository provideLovecityRepository(RepositoryManager manager);

    @Binds
    IAppPreferencesUseCase provideAppPreferencesUseCase(LovecityInteraptor interaptor);

    @Binds
    IAppPreferencesRepository provideAppPreferencesRepository(AppPreferences preferences);
}

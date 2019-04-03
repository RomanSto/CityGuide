package com.stolbunov.roman.testandroid.ui.screens.base;

import com.stolbunov.roman.testandroid.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().context(this).build();
    }
}

package com.stolbunov.roman.testandroid.di;

import android.content.Context;

import com.stolbunov.roman.testandroid.di.scope.AppScope;
import com.stolbunov.roman.testandroid.ui.screens.base.App;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

@AppScope
@Component(modules = {DaggerAndroidModule.class, DomainModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AndroidInjector<? extends DaggerApplication> build();
    }

}

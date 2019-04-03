package com.stolbunov.roman.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import com.stolbunov.roman.domain.repository.IAppPreferencesRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class AppPreferences implements IAppPreferencesRepository {
    private static final String APP_PREFERENCES_NAME = "LoveCity";
    private static final String USER_ICON_PATH = "UserIconURI";

    private static SharedPreferences sharedPreferences;

    @Inject
    public AppPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Completable saveUserIconPath(Uri uri) {
        return Completable.fromAction(() -> saveIconPath(uri.toString()));
    }

    @Override
    public Single<Uri> getUserIconPath() {
        return Single.fromCallable(this::getIconPath)
                .map(Uri::parse);
    }

    private void saveIconPath(String userIconPath) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(USER_ICON_PATH, userIconPath);
        edit.apply();
    }

    private String getIconPath() {
        return sharedPreferences.getString(USER_ICON_PATH, "");
    }
}

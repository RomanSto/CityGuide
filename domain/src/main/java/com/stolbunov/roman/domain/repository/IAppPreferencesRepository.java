package com.stolbunov.roman.domain.repository;

import android.net.Uri;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IAppPreferencesRepository {

    Completable saveUserIconPath(Uri uri);

    Single<Uri> getUserIconPath();
}

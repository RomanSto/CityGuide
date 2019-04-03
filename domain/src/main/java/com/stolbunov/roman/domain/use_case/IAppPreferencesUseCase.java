package com.stolbunov.roman.domain.use_case;

import android.net.Uri;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IAppPreferencesUseCase {

    Completable saveUserIconPath(Uri uri);

    Single<Uri> getUserIconPath();
}

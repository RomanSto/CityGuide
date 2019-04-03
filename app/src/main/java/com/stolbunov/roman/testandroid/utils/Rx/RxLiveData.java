package com.stolbunov.roman.testandroid.utils.Rx;

import androidx.lifecycle.LiveData;
import io.reactivex.Observable;

public final class RxLiveData {
    private RxLiveData() {
    }

    public static <T> Observable<T> liveDateToRx(LiveData<T> liveData) {
        return Observable.create(emitter -> liveData.observeForever(emitter::onNext));
    }
}

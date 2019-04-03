package com.stolbunov.roman.data.utils;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class RxRetrofit {
    private RxRetrofit() {
    }

    public static <T> Single<T> enqueue(Call<T> call) {
        return Single.create(emitter -> call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    emitter.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                emitter.onError(t);
            }
        }));
    }
}

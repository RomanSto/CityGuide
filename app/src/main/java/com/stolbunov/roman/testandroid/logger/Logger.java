package com.stolbunov.roman.testandroid.logger;

import android.util.Log;

public class Logger {

    public static void e(String className, Throwable throwable) {
        Log.e("CityLove", className, throwable);
    }
}

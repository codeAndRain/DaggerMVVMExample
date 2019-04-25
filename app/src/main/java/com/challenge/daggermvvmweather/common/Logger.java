package com.challenge.daggermvvmweather.common;

import android.util.Log;

public class Logger {

    public static final String TAG = "LOG_TAG";

    public static void logD(String message) {
        Log.d(TAG, message);
    }
}


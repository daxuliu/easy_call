package com.example.easy_call;

import android.app.Application;

public class App  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Crasher.getInstance().init();
    }
}

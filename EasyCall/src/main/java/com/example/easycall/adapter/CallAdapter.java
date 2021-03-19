package com.example.easycall.adapter;

import android.view.View;

public class CallAdapter<T extends View> {
    private final T instance;

    public CallAdapter(T instance) {
        this.instance = instance;
    }

    public boolean call() {
        if (instance == null) {
            return false;
        }
        return this.instance.callOnClick();
    }
}

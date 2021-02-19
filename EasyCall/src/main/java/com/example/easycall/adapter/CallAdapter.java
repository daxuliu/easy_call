package com.example.easycall.adapter;

import android.view.View;

public class CallAdapter<T extends View> {
    private View instance;

    public CallAdapter(View instance) {
        this.instance = instance;
    }

    public boolean call() {
        if (instance == null) {
            return false;
        }
        return this.instance.callOnClick();
    }
}

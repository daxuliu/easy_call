package com.example.easy_call;

import android.util.Log;

import androidx.annotation.NonNull;

public class Crasher implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        Log.d("crash",e.getMessage());
    }
    private static final class CrashHolder{
        private static final Crasher instance=new Crasher();
    }
    public void init(){
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    private  Crasher(){}
    public static   Crasher getInstance(){
        return  CrashHolder.instance;
    }

}

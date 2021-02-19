package com.example.easycall.adapter.builder;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.easycall.adapter.CallAdapter;
import com.example.easycall.adapter.at.Call;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;

public class Builder {
    private ArrayList<CallAdapter> list = new ArrayList<>();
    private Hashtable<String, Hashtable<String, CallAdapter>> page = new Hashtable();

    public Builder() {
    }

    public void addPage(AppCompatActivity activity, String name) {
        Class c = activity.getClass();
        if (page.get(name) == null) {
            Hashtable<String, CallAdapter> temp = new Hashtable<>();
            Field fields[] = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].isAnnotationPresent(Call.class)) {
                    Call call = fields[i].getAnnotation(Call.class);
                    String k = call.name();
                    int id = call.id();
                    View view = activity.findViewById(id);
                    view.callOnClick();
                    CallAdapter adapter = new CallAdapter(view);
                    temp.put(k, adapter);
                }
            }
            page.put(name, temp);
        }
    }

    public CallAdapter getCall(String pageName, String name) {
        return page.get(pageName).get(name);
    }
}

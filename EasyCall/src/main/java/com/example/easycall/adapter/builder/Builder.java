package com.example.easycall.adapter.builder;

import android.app.Activity;
import android.view.View;

import com.example.easycall.adapter.CallAdapter;
import com.example.easycall.adapter.at.Call;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class Builder<T extends Activity> {
    private final Hashtable<String, Hashtable<String, CallAdapter>> page = new Hashtable();
    private Builder() {
    }

    public static Builder getBuilder() {
        return BuilderHolder.builder;
    }

    public void addPage(T activity, String name) {
        Class c = activity.getClass();
        if (page.get(name) == null) {
            Hashtable<String, CallAdapter> temp = new Hashtable<>();
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].isAnnotationPresent(Call.class)) {
                    Call call = fields[i].getAnnotation(Call.class);
                    String k = call.name();
                    int id = call.id();
                    View view = activity.findViewById(id);
                    CallAdapter adapter = new CallAdapter(view);
                    temp.put(k, adapter);
                }
            }
            page.put(name, temp);
        }
    }

    public CallAdapter getCall(String pageName, String name) {
        return Objects.requireNonNull(page.get(pageName)).get(name);
    }

    static final class BuilderHolder {
        private static final Builder builder = new Builder();
    }
}

package com.wg.map_demo.util;

import android.annotation.SuppressLint;
import android.app.Application;

import java.lang.reflect.InvocationTargetException;

public class ContextUtil {

    public static Application getApp() {
        Application app = getApplicationByReflect();
        return app;
    }

    private static Application getApplicationByReflect() {
        try {
            @SuppressLint("PrivateApi")
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            Object thread = activityThread.getMethod("currentActivityThread").invoke(null);
            Object app = activityThread.getMethod("getApplication").invoke(thread);
            if (app == null) {
                throw new NullPointerException("u should init first");
            }
            return (Application) app;
        } catch (NoSuchMethodException | IllegalAccessException | ClassNotFoundException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("u should init first");
    }
}

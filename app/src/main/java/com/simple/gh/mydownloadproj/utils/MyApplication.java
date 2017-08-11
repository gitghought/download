package com.simple.gh.mydownloadproj.utils;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by gh on 2017-08-11.
 */

public class MyApplication extends Application{
    public static RefWatcher watcher;

    @Override
    public void onCreate() {
        super.onCreate();
        watcher = LeakCanary.install(this);
    }

    public static RefWatcher getWatcher() {
        return watcher;
    }
}

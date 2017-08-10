package com.simple.gh.mydownloadproj.utils;

import android.util.Log;

/**
 * Created by gh on 2017-08-09.
 */

public class MyLog {
    public static final String TAG = "MyLog";
    public static StackTraceElement[] eles /*= new Throwable().getStackTrace()*/;

    public static void d(String TAG, String msg) {
        eles = new Throwable().getStackTrace();
        Log.d(TAG, "in " + eles[1].getFileName() + ":" + eles[1].getMethodName() + "@" +  eles[1].getLineNumber() + msg);
    }

}

package com.simple.gh.mydownloadproj.thread;

import android.os.AsyncTask;

import com.simple.gh.mydownloadproj.utils.MyLog;

/**
 * Created by gh on 2017-08-09.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer> {
    public static final String TAG = "SHOWS_TRING";


    @Override
    protected Integer doInBackground(String... params) {
        String downUrl = params[0];
        MyLog.d(TAG, "downUrl = " + downUrl);

        return null;
    }
}

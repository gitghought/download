package com.simple.gh.mydownloadproj.thread;

import android.os.AsyncTask;

import com.simple.gh.mydownloadproj.http.MyHttp;
import com.simple.gh.mydownloadproj.mycallback.DownloadListener;
import com.simple.gh.mydownloadproj.mycallback.MyHttpURLListener;
import com.simple.gh.mydownloadproj.utils.MyLog;

/**
 * Created by gh on 2017-08-09.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer> {
//    public static final String TAG = "SHOWS_TRING";
    public DownloadListener listener;

    public DownloadTask(DownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        String downUrl = params[0];
        MyLog.d(MyLog.TAG, "downUrl = " + downUrl);
        MyHttp.sendRequest(downUrl, new MyHttpURLListener() {
            @Override
            public void onFinished(String val) {
                MyLog.d(MyLog.TAG, "val = " + val);
            }
        });
//        listener.onSuccessed();

        return null;
    }
}

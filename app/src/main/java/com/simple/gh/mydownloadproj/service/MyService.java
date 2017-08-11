package com.simple.gh.mydownloadproj.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.simple.gh.mydownloadproj.mycallback.DownloadListener;
import com.simple.gh.mydownloadproj.thread.DownloadTask;
import com.simple.gh.mydownloadproj.utils.MyLog;

public class MyService extends Service {
    public MyBinder bind = new MyBinder();
    public DownloadTask download;

    public class MyBinder extends Binder {
        public void startDownload (String url) {
            MyLog.d(MyLog.TAG, "url = " + url);
            if (download == null) {
                download = new DownloadTask(new DownloadListener() {
                    @Override
                    public void onSuccessed() {
                        MyLog.d(MyLog.TAG, "download onSuccessed");
                    }
                });
                download.execute(url);
            }
        }
        public void cancleDownload() {
            if (download != null) {
                download.cancleTask();
            }
        }
    }

    public MyService() {
        MyLog.d(MyLog.TAG, "MyService constructor");
    }

    @Override
    public IBinder onBind(Intent intent) {
        MyLog.d(MyLog.TAG, "onBind");
        return bind;
    }
}

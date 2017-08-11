package com.simple.gh.mydownloadproj.thread;

import android.os.AsyncTask;

import com.simple.gh.mydownloadproj.http.MyHttp;
import com.simple.gh.mydownloadproj.mycallback.DownloadListener;
import com.simple.gh.mydownloadproj.mycallback.MyHttpURLListener;
import com.simple.gh.mydownloadproj.utils.MyLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by gh on 2017-08-09.
 */

public class DownloadTask extends AsyncTask<String, Integer, Integer> {
//    public static final String TAG = "SHOWS_TRING";
    public DownloadListener listener;
    private InputStream is;

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

            @Override
            public void onFinished(InputStream is) {
                DownloadTask.this.is = is;

                try {
                    String str = getString(is);
                    MyLog.d(MyLog.TAG, "str = " + " " + str);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });



        return null;
    }
    private String getString(InputStream pIS) throws IOException {
        InputStreamReader reader = new InputStreamReader(pIS);
        BufferedReader br = new BufferedReader(reader);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            MyLog.d(MyLog.TAG, "in task while");
            if (isCancelTask == true) {
                break;
            }
            sb.append(line);
        }

        return sb.toString();
    }

    private boolean isCancelTask = false;
    public void cancleTask() {
        this.isCancelTask = true;
    }
}

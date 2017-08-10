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
            }
        });

        try {
            String str = this.getString(this.is);
            MyLog.d(MyLog.TAG, "str = " + " " + str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (this.is != null) {
                try {
                    this.is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    private String getString(InputStream pIS) throws IOException {
//        byte[] bys = new byte[64];
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//        int len;
//        while ((len = pIS.read(bys)) != -1) {
//            baos.write(bys);
//        }
//        return new String(baos.toByteArray());



        InputStreamReader reader = new InputStreamReader(pIS);
        BufferedReader br = new BufferedReader(reader);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }
}

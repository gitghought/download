package com.simple.gh.mydownloadproj.http;

import android.support.annotation.NonNull;

import com.simple.gh.mydownloadproj.mycallback.MyHttpURLListener;
import com.simple.gh.mydownloadproj.utils.MyLog;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gh on 2017-08-10.
 */

public class MyHttp {
    public static HttpURLConnection conn = null;
//    private static BufferedReader br;
    private static InputStream is;

    public static void sendRequest(String url, MyHttpURLListener listener) {
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);

            //
            is = conn.getInputStream();

            listener.onFinished(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private static String getString(InputStream pIS) throws IOException {
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

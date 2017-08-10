package com.simple.gh.mydownloadproj.http;

import com.simple.gh.mydownloadproj.mycallback.MyHttpURLListener;
import com.simple.gh.mydownloadproj.utils.MyLog;

import java.io.BufferedReader;
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
    private static BufferedReader br;

    public static void sendRequest(String url, MyHttpURLListener listener) {
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);

            //
            InputStream is = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            br = new BufferedReader(reader);

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            listener.onFinished(sb.toString() + "back");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}

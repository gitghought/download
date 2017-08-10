package com.simple.gh.mydownloadproj.mycallback;

import java.io.InputStream;

/**
 * Created by gh on 2017-08-10.
 */
public interface MyHttpURLListener {
    void onFinished(String val);
    void onFinished(InputStream is);
}

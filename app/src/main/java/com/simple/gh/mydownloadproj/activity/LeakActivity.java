package com.simple.gh.mydownloadproj.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.simple.gh.mydownloadproj.R;

public class LeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);

        ActivityMgr.newInstance().addActivity(this);
    }
}

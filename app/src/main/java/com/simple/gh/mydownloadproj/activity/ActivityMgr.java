package com.simple.gh.mydownloadproj.activity;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by gh on 2017-08-11.
 */

public class ActivityMgr {
    private ArrayList<Activity> acts = new ArrayList<>();
    private static ActivityMgr fragment;

    private ActivityMgr() {
    }

    public static ActivityMgr newInstance() {
        if (fragment == null) {
            fragment = new ActivityMgr();
        }

        return fragment;
    }

    public void addActivity(Activity act) {
        if (act != null) {
            acts.add(act);
        }
    }
}

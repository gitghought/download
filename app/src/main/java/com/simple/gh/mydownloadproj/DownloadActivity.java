package com.simple.gh.mydownloadproj;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.simple.gh.mydownloadproj.adapter.MyRecyclerAdapter;
import com.simple.gh.mydownloadproj.object.MyTask;
import com.simple.gh.mydownloadproj.service.MyService;

import java.util.ArrayList;

public class DownloadActivity extends AppCompatActivity {

    private ArrayList<MyTask> tasks = new ArrayList<>();

    private void initList () {
        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask();
            task.setmName("good" + "" + i);
            tasks.add(task);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        initList();

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerview_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(tasks);
        recycler.setAdapter(adapter);
    }
}

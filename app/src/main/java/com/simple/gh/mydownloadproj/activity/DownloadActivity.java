package com.simple.gh.mydownloadproj.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.simple.gh.mydownloadproj.R;
import com.simple.gh.mydownloadproj.service.MyService;

public class DownloadActivity extends AppCompatActivity {
    private Button btnStartDownload;
    private Button btnLeak;
    private MyService.MyBinder binder;
    private ServiceConnection conn;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        //start service
        final Intent intent = new Intent(this, MyService.class);
        startService(intent);

        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = ((MyService.MyBinder)service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, conn, BIND_AUTO_CREATE);

        btnStartDownload = (Button) findViewById(R.id.btn_start_download);
        btnStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binder.startDownload("http://192.168.197.84:8080/server.jsp?name=gaihao");
//                binder.cancleDownload();
            }
        });

        btnLeak = (Button) findViewById(R.id.btn_leak);
        btnLeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DownloadActivity.this, LeakActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.vipin.dynamicbroadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (Button) findViewById(R.id.test);
        test.setOnClickListener(this);
    }

    BroadcastReceiver myTestBroadCastReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("TAG", "test broadcast received");

            Toast.makeText(context, "BroadCast Received", Toast.LENGTH_LONG).show();
        }
    };


    @Override
    protected void onResume() {
        super.onResume();

        LocalBroadcastManager lb = LocalBroadcastManager.getInstance(this);

        IntentFilter intentFilter = new IntentFilter("TEST_BROADCAST");
        intentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        lb.registerReceiver(myTestBroadCastReciever,intentFilter);
    }


    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager lb = LocalBroadcastManager.getInstance(this);
        lb.unregisterReceiver(myTestBroadCastReciever);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,TestService.class);
        startService(intent);
        Log.d("TAG","Service started");

    }
}
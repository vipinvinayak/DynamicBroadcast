package com.example.vipin.dynamicbroadcast;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by vipin on 7/16/2017.
 */

public class TestService extends IntentService {



    public TestService() {
        super("TEST_SERVICE");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Send broadcast from here.........................
        LocalBroadcastManager lb =  LocalBroadcastManager.getInstance(this);
        Intent testIntent = new Intent("TEST_BROADCAST");
        lb.sendBroadcast(testIntent);
        Log.d("TAG", "test broadcast fired");


    }
}

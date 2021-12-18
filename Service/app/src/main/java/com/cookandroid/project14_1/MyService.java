package com.cookandroid.project14_1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Thread mThread;
    int mCount = 0;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.i("서비스테스트", "MyService: onCreate() called");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("서비스테스트", "MyService: onStartCommand() called");

        if (mThread == null) {
            mThread = new Thread("My Thread") {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        mCount++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            break;
                        }
                        Log.i("서비스테스트", "MyService: mCount = " + mCount);
                    }
                }
            };
            mThread.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("서비스테스트", "MyService: onDestroy() called");

        if (mThread != null) {
            mThread.interrupt();
            mThread = null;
            mCount = 0;
        }
        super.onDestroy();
    }
}
package com.cookandroid.project14_1;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    int mCount = 0;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("서비스테스트", "MyIntentService: onHandleIntent() called");
        mCount = 0;
        for (int i = 0; i < 10; i++) {
            mCount++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            Log.i("서비스테스트", "MyIntentService: mCount = " + mCount);
        }
    }
}
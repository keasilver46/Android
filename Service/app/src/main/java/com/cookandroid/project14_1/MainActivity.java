package com.cookandroid.project14_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent1, intent2;
    Button btnStartService, btnStopService, btnStartIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);
        btnStartIntentService = (Button) findViewById(R.id.btnStartIntService);

        intent1 = new Intent(getApplicationContext(), MyService.class);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("서비스테스트", "MainActivity: startService(intent1) called");
                startService(intent1);
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("서비스테스트", "MainActivity: stopService() called");
                stopService(intent1);
            }
        });

        intent2 = new Intent(getApplicationContext(), MyIntentService.class);

        btnStartIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("서비스테스트", "MainActivity: startService(intent2) called");
                startService(intent2);
            }
        });
    }
}
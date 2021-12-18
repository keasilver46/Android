package com.cookandroid.project14_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnCall;
    EditText edtCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = (Button) findViewById(R.id.btnCall);
        edtCall = (EditText) findViewById(R.id.edtCall);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG},
                1000);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btnCall.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String callLog = getCallHistory();
                            edtCall.setText(callLog);
                        }
                    });
                }
                break;
        }
    }

    public String getCallHistory() {
        String[] callSet = new String[]{CallLog.Calls.DATE,
                CallLog.Calls.TYPE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION};

        ContentResolver contentResolver = getContentResolver();
        Cursor c = contentResolver.query(CallLog.Calls.CONTENT_URI, callSet, null, null, null);

        if (c == null) {
            return "통화 기록 없음";
        }

        StringBuffer callBuf = new StringBuffer();
        callBuf.append("날짜 : 타입 : 전화번호 : 통화시간\n\n");
        c.moveToFirst();
        do {
            long callDate = c.getLong(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
            String date_str = dateFormat.format(new Date(callDate));
            callBuf.append(date_str + " : ");

            if (c.getInt(1) == CallLog.Calls.INCOMING_TYPE) {
                callBuf.append("착신 : ");
            } else {
                callBuf.append("발신 : ");
            }

            callBuf.append(c.getString(2) + " : ");
            callBuf.append(c.getString(3) + "초\n");
        } while (c.moveToNext());

        c.close();
        return callBuf.toString();
    }
}
package com.cookandroid.project10_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class ThirdActivity extends Activity {
    Button btnReturn;
    EditText edtReceived;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        edtReceived = (EditText) findViewById(R.id.edt1);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();
        if (extras != null) {
            String rxName = extras.getString("Name");
            Integer rxNumber = extras.getInt("Number");
            edtReceived.setText("Received Name: " + rxName + ", Received Number: " + rxNumber);
        }

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

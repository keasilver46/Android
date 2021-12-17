package com.cookandroid.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    Button btnAddActivity, btnSubActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);

        btnAddActivity = (Button) findViewById(R.id.btnAddActivity);
        btnAddActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        AddActivity.class);
                intent.putExtra("Num1",
                        Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",
                        Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent, 1001);
            }
        });

        btnSubActivity = (Button) findViewById(R.id.btnSubActivity);
        btnSubActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        SubActivity.class);
                intent.putExtra("Num1",
                        Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",
                        Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent, 1002);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1001:
                if (resultCode == RESULT_OK) {
                    int result = data.getExtras().getInt("AddResult");
                    Toast.makeText(getApplicationContext(), "더하기 결과: " + result,
                            Toast.LENGTH_LONG).show();
                }
                break;
            case 1002:
                if (resultCode == RESULT_OK) {
                    int result = data.getExtras().getInt("SubResult");
                    Toast.makeText(getApplicationContext(), "빼기 결과: " + result,
                            Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
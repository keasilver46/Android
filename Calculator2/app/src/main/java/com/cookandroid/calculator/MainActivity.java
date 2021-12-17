package com.cookandroid.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2, edtResult;
    RadioButton rdoAdd, rdoSub, rdoMul;
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);

        rdoAdd = (RadioButton) findViewById(R.id.rdoAdd);
        rdoSub = (RadioButton) findViewById(R.id.rdoSub);
        rdoMul = (RadioButton) findViewById(R.id.rdoMul);

        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdoAdd.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), AddActivity.class);

                    intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                    startActivityForResult(intent, 1001);
                } else if (rdoSub.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), SubActivity.class);

                    intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                    startActivityForResult(intent, 1002);
                } else if (rdoMul.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), MulActivity.class);

                    intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                    startActivityForResult(intent, 1003);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        edtResult = (EditText) findViewById(R.id.edtResult);

        switch (requestCode) {
            case 1001:
                if (resultCode == RESULT_OK) {
                    int result = data.getExtras().getInt("AddResult");
                    edtResult.setText(String.valueOf(result));
                }
                break;
            case 1002:
                if (resultCode == RESULT_OK) {
                    int result = data.getExtras().getInt("SubResult");
                    edtResult.setText(String.valueOf(result));
                }
                break;
            case 1003:
                if (resultCode == RESULT_OK) {
                    int result = data.getExtras().getInt("MulResult");
                    edtResult.setText(String.valueOf(result));
                }
                break;
        }
    }
}
package com.cookandroid.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText edtSub;
    Button btnReturn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity);

        edtSub = (EditText) findViewById(R.id.edtSub);

        Intent inIntent = getIntent();
        int num1 = inIntent.getExtras().getInt("Num1");
        int num2 = inIntent.getExtras().getInt("Num2");
        final int result = num1 - num2;
        edtSub.setText(num1 + " - " + num2 + " = " + result);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("SubResult", result);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
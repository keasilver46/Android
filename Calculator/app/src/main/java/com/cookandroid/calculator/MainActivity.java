package com.cookandroid.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button[] btnNum = new Button[10];
    Integer[] btnNumID = { R.id.Btn0, R.id.Btn1, R.id.Btn2, R.id.Btn3, R.id.Btn4,
            R.id.Btn5, R.id.Btn6, R.id.Btn7, R.id.Btn8, R.id.Btn9 };
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요",
                            Toast.LENGTH_LONG).show();
                } else {
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요",
                            Toast.LENGTH_LONG).show();
                } else {
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요",
                            Toast.LENGTH_LONG).show();
                } else {
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                String zero = "0";

                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요",
                            Toast.LENGTH_LONG).show();
                } else if (num2.equals(zero)) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없음",
                            Toast.LENGTH_LONG).show();
                } else {
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
            }
        });

        for (i = 0; i < btnNumID.length; i++) {
            btnNum[i] = (Button) findViewById(btnNumID[i]);
        }

        for (i = 0; i < btnNumID.length; i++) {
            final int index;
            index = i;

            btnNum[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() + btnNum[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString() + btnNum[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "EditText를 선택하세요",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
}
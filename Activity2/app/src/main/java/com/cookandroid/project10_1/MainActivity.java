package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton rdoSecond, rdoThird;
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoSecond = (RadioButton) findViewById(R.id.rdoSecond);
        rdoThird = (RadioButton) findViewById(R.id.rdoThird);

        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdoSecond.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                } else if (rdoThird.isChecked()) {
                    Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);

                    String name = "Alice";
                    Integer number = 33;

                    intent.putExtra("Name", name);
                    intent.putExtra("Number", number);

                    startActivity(intent);
                }
            }
        });

    }

}
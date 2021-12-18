package com.cookandroid.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnRed, btnGreen, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("프래그먼트 생명주기", "MainActivity: onCreate()");

        btnRed = (Button) findViewById(R.id.btnRed);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnBlue = (Button) findViewById(R.id.btnBlue);

        MyColorFragment fragWhite = new MyColorFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, fragWhite);
        fragmentTransaction.addToBackStack("fragWhite");
        fragmentTransaction.commit();

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("ColorSelected", "red");

                MyColorFragment fragRed = new MyColorFragment();
                fragRed.setArguments(data);

                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout, fragRed);
                fragmentTransaction1.addToBackStack("fragRed");
                fragmentTransaction1.commit();
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("ColorSelected", "green");

                MyColorFragment fragGreen = new MyColorFragment();
                fragGreen.setArguments(data);

                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout, fragGreen);
                fragmentTransaction1.addToBackStack("fragGreen");
                fragmentTransaction1.commit();
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("ColorSelected", "blue");

                MyColorFragment fragBlue = new MyColorFragment();
                fragBlue.setArguments(data);

                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout, fragBlue);
                fragmentTransaction1.addToBackStack("fragBlue");
                fragmentTransaction1.commit();
            }
        });
    }
}
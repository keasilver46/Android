package com.cookandroid.project11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = (GridView) findViewById(R.id.gridView);
        MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter(MainActivity.this);
        gv.setAdapter(myGridViewAdapter);
    }
}
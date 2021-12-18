package com.cookandroid.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView[] = new ImageView[9];
    Integer imageViewId[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
            R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
    int voteCount[] = new int[9];
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < voteCount.length; i++) {
            voteCount[i] = 0;
        }

        for (int i = 0; i < imageViewId.length; i++) {
            final int index;
            index = i;
            imageView[i] = (ImageView) findViewById(imageViewId[i]);
            imageView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), "총 " + voteCount[index] + "표", Toast.LENGTH_LONG).show();
                }
            });
        }

        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                startActivity(intent);
            }
        });
    }
}
package com.cookandroid.project10_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();
        int[] voteResult = null;
        if (extras != null) {
            voteResult = extras.getIntArray("VoteCount");
        }

        RatingBar rbar[] = new RatingBar[voteResult.length];
        Integer rbarId[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        for (int i = 0; i < voteResult.length; i++) {
            rbar[i] = (RatingBar) findViewById(rbarId[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

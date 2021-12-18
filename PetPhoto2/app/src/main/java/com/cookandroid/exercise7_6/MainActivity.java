package com.cookandroid.exercise7_6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdoGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button button1;
    ImageView imgPet;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdoGroup1 = (RadioGroup) findViewById(R.id.rdoGroup1);
        rdoDog = (RadioButton) findViewById(R.id.rdoDog);
        rdoCat = (RadioButton) findViewById(R.id.rdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.rdoRabbit);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dialogView = (View) View.inflate(getApplicationContext(),
                        R.layout.dialog1, null);
                imgPet = dialogView.findViewById(R.id.imgPet1);

                dlg.setIcon(R.drawable.ic_baseline_group_24);
                dlg.setView(dialogView);

                if(rdoDog.isChecked()){
                    imgPet.setImageResource(R.drawable.dog);
                    dlg.setTitle("강아지");
                } else if(rdoCat.isChecked()){
                    imgPet.setImageResource(R.drawable.cat);
                    dlg.setTitle("고양이");
                } else if(rdoRabbit.isChecked()){
                    imgPet.setImageResource(R.drawable.rabbit);
                    dlg.setTitle("토끼");
                }

                dlg.setNegativeButton("닫기",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this,
                                R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText("대화상자를 닫았습니다");
                        toast.setView(toastView);
                        toast.show();
                    }
                });

                dlg.show();

            }

        });
    }

}
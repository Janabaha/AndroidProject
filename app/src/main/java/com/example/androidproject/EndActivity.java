package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        ImageButton imgbut = findViewById(R.id.imgbut11);
        ImageButton imgbut2 = findViewById(R.id.imgbut12);
        ImageButton imgbut3 = findViewById(R.id.imgbut13);
        imgbut2.setEnabled(false);
        imgbut3.setEnabled(false);
        Button button = findViewById(R.id.but14);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndActivity.this, MainActivity.class);
                startActivity(intent);
      }
        });


        imgbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbut.setImageResource(R.drawable.fillstar);
                imgbut2.setEnabled(true);


            }
        });
        imgbut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbut2.setImageResource(R.drawable.fillstar);
                imgbut3.setEnabled(true);
            }
        });
        imgbut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgbut3.setImageResource(R.drawable.fillstar);
            }
        });

    }
}

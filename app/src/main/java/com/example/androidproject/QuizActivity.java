package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity {
    int counter = 0;
    String[] questions;
    String[] answers1;
    String[] answers2;
    String[] answers3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ImageButton imgbut = findViewById(R.id.imgbut);
        imgbut.setVisibility(View.INVISIBLE);

        Button b2 = findViewById(R.id.but2);
        b2.setEnabled(false);

        TextView v1 = findViewById(R.id.text2);
        questions = getResources().getStringArray(R.array.questions);
        v1.setText(questions[counter]);

        RadioGroup rg1 = findViewById(R.id.rg1);
        RadioButton rb1 = findViewById(R.id.rb1);
        RadioButton rb2 = findViewById(R.id.rb2);
        RadioButton rb3 = findViewById(R.id.rb3);

        answers1 = getResources().getStringArray(R.array.answers1);
        answers2 = getResources().getStringArray(R.array.answers2);
        answers3 = getResources().getStringArray(R.array.answers3);

        rb1.setText(answers1[0]);
        rb2.setText(answers1[1]);
        rb3.setText(answers1[2]);



        Button b1 = findViewById(R.id.but1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(counter==0 && rb2.isChecked()) {
                    Toast.makeText(getBaseContext(),"You have answered correctly!",Toast.LENGTH_SHORT).show();
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    imgbut.setVisibility(View.VISIBLE);
                }
                else if(counter==0 && ( rb3.isChecked() || rb1.isChecked())){
                    Toast.makeText(getBaseContext(),"You have answered incorrectly!",Toast.LENGTH_SHORT).show();
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                }

                else if(counter==1 && rb1.isChecked()) {
                    Toast.makeText(getBaseContext(),"You have answered correctly!",Toast.LENGTH_SHORT).show();
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    imgbut.setVisibility(View.VISIBLE);
                }
                else if(counter==1 && ( rb3.isChecked() || rb2.isChecked())){
                    Toast.makeText(getBaseContext(),"You have answered incorrectly!",Toast.LENGTH_SHORT).show();
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                }
                else if(counter==2 && rb3.isChecked()) {
                    Toast.makeText(getBaseContext(),"You have answered correctly!",Toast.LENGTH_SHORT).show();
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    imgbut.setVisibility(View.VISIBLE);
                }
                else if(counter==2 && ( rb2.isChecked() || rb1.isChecked())){
                    Toast.makeText(getBaseContext(),"You have answered incorrectly!",Toast.LENGTH_SHORT).show();
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                }
                else {
                    Toast.makeText(getBaseContext(),"You have to choose an answer",Toast.LENGTH_SHORT).show();
                    return;
                }
                rb1.setClickable(false);
                rb2.setClickable(false);
                rb3.setClickable(false);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setEnabled(true);
                b2.setEnabled(false);
                rg1.clearCheck();
                rb1.setClickable(true);
                rb2.setClickable(true);
                rb3.setClickable(true);


            }
        });


        imgbut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                counter++;
                imgbut.setVisibility(View.INVISIBLE);
                rg1.clearCheck();
                b2.setEnabled(false);
                b1.setEnabled(true);
                rb1.setClickable(true);
                rb2.setClickable(true);
                rb3.setClickable(true);

                if(counter == 1) {
                    v1.setText(questions[1]);
                    rb1.setText(answers2[0]);
                    rb2.setText(answers2[1]);
                    rb3.setText(answers2[2]);
                }
                else if(counter == 2) {
                    v1.setText(questions[2]);
                    rb1.setText(answers3[0]);
                    rb2.setText(answers3[1]);
                    rb3.setText(answers3[2]);
                }
                else if(counter == 3) {
                    Intent intent = new Intent(QuizActivity.this, EndActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
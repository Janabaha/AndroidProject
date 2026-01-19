package com.example.androidproject;

import android.os.Bundle;
import android.widget.*;
import android.view.*;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class change_dress_color extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_dress_color);
        Button save_btn = findViewById(R.id.save_btn);
        RadioGroup rg = (RadioGroup) findViewById(R.id.dress);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton pink = findViewById(R.id.pink_btn);
                RadioButton blue = findViewById(R.id.blue_btn);
                RadioButton yellow = findViewById(R.id.yellow_btn);
                ImageView   img = findViewById(R.id.img_laila);

                if(pink.isChecked()){
                    img.setImageResource(R.drawable.lailapink);
                    laila.color="pink";}
                else if (blue.isChecked()){
                    img.setImageResource(R.drawable.lailablue);
                    laila.color="blue";}
                else if (yellow.isChecked()){
                    img.setImageResource(R.drawable.lailayellow);
                    laila.color="yellow";}
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
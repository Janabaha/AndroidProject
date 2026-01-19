package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        RelativeLayout lay = findViewById(R.id.main);


        if ("blue".equals(laila.color)) {
            lay.setBackgroundResource(R.drawable.blue_background);
        } else if ("yellow".equals(laila.color)) {
            lay.setBackgroundResource(R.drawable.yellow_background);
        } else if ("pink".equals(laila.color)) {
            lay.setBackgroundResource(R.drawable.pink_background);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start_btn = findViewById(R.id.start_btn);
        Button change_btn = findViewById(R.id.change_btn);
        RelativeLayout lay = findViewById(R.id.main);

        start_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, StoryActivity.class));
                finish();
            }
        });
        change_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, change_dress_color.class));
                onResume();
            }
        });
    }
}
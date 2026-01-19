package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StoryActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView rightBtn;
    private ImageView leftBtn;
    private TextView page_text;
    private Button btnQuiz;


    private int index = 1;
    private int maxPages = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        imageView = findViewById(R.id.story_image);
        page_text = findViewById(R.id.page_text);
        rightBtn  = findViewById(R.id.right_btn);
        leftBtn   = findViewById(R.id.left_btn);
        btnQuiz = findViewById(R.id.btnQuiz);


        updatePage();

        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < maxPages) {
                    index++;
                    updatePage();
                }
            }
        });

        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index > 1) {
                    index--;
                    updatePage();
                }
            }
        });
        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(StoryActivity.this, QuizActivity.class);
            startActivity(intent);
        });
    }

    private void updatePage() {
        String color = (laila.color == null)
                ? "blue"
                : laila.color.toLowerCase();

        String imageName;
        if (color.equals("blue")) {
            imageName = "blueb" + index;
        } else if (color.equals("pink")) {
            imageName = "pinkb" + index;
        } else {
            imageName = "yellowb" + index;
        }

        int resId = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName()
        );

        if (resId != 0) {
            imageView.setImageResource(resId);
        }

        page_text.setText(index + "/" + maxPages);

        leftBtn.setVisibility(index == 1 ? View.INVISIBLE : View.VISIBLE);
        rightBtn.setVisibility(index == maxPages ? View.INVISIBLE : View.VISIBLE);

        if (index == maxPages) {
            btnQuiz.setVisibility(View.VISIBLE);
        } else {
            btnQuiz.setVisibility(View.GONE);
        }

    }
}


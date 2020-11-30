package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Viev.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button yesBtn;
    private Button noBtn;

    private Question[] questions = new Question[]{
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
            new Question(R.string.question5, true)
    };


    private int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);

        textView.setText(questions[questionIndex].getQuestionResId());
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this,R.string.correct, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,R.string.nocorrect, Toast.LENGTH_LONG).show();
                @ColorInt int color = Color.parseColor("#00ff00");
                yesBtn.setBackgroundColor(color);
                questionIndex++;
                if (questionIndex<5)
                    textView.setText(questions[questionIndex].getQuestionResId());
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this,R.string.nocorrect, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,R.string.correct, Toast.LENGTH_LONG).show();
                @ColorInt int color = Color.parseColor("#ff0000");
                noBtn.setBackgroundColor(color);
                questionIndex++;
                if (questionIndex<5)
                    textView.setText(questions[questionIndex].getQuestionResId());
            }
        });

    }
}
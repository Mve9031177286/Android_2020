package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private boolean isAnswerTrue;  // переменная, в которой хранится ответ для второй активности
    private TextView textAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer2);

        isAnswerTrue = getIntent().getBooleanExtra("answer", false);   // обращаемся к интент, достаем булевое значение, поэтому getBoolean

        textAnswer = findViewById(R.id.textAnswer);

        textAnswer.setText(isAnswerTrue?R.string.yes:R.string.no); // тернарный оператор, вместо if/else, но можно и как ниже

        /*if(isAnswerTrue){
            textAnswer.setText(R.string.correct);
        }else{
            textAnswer.setText(R.string.incorrect);
        }*/
    }
}
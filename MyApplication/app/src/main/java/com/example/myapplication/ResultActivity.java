package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {


      private String[] AnswerResult;
      private TextView textAnswer8;
      private TextView textAnswer7;
      private TextView textAnswer6;
      private TextView textAnswer9;
      private TextView textAnswer10;


      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_result);

          AnswerResult = getIntent().getStringArrayListExtra("AnswerResult").toArray(new String[4]);

          textAnswer8 = findViewById(R.id.textView8);
          textAnswer7 = findViewById(R.id.textView7);
          textAnswer6 = findViewById(R.id.textView6);
          textAnswer9 = findViewById(R.id.textView9);
          textAnswer10 = findViewById(R.id.textView10);

          textAnswer8.setText((AnswerResult[0]R.string.correct) ? R.string.no : R.string.yes);
          textAnswer7.setText((AnswerResult[1]R.string.correct) ? R.string.no : R.string.yes);
          textAnswer6.setText((AnswerResult[2]R.string.correct) ? R.string.no : R.string.yes);
          textAnswer9.setText((AnswerResult[3]R.string.correct) ? R.string.no : R.string.yes);
          textAnswer10.setText((AnswerResult[4]R.string.correct) ? R.string.no : R.string.yes);


      }

}
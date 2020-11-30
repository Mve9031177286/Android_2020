package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Viev.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button yesBtn;// создал кнопку "да"
    private Button noBtn;// создал кнопку "нет"
    private Button showAnswer;

    private Question[] questions = new Question[]{
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
            new Question(R.string.question5, true)
    };


    private int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {  // метод onCreate запускается со своим хранилищем Bundle saved...наподобие ArreyList, но в Андроид
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){// при запуске приложения saved=null, там ничего нет
            questionIndex = savedInstanceState.getInt("questionIndex");  //если saved... не равен (!=) null, то берем значение question из него
        }

        textView = findViewById(R.id.textView);
        yesBtn = findViewById(R.id.yesBtn);// соединил кнопку "да" с компонентом view
        noBtn = findViewById(R.id.noBtn);//  соединил кнопку "нет" с компонентом view, стандартная конструкция, надо запомнить
        showAnswer = findViewById(R.id.showAnswer);

        textView.setText(questions[questionIndex].getQuestionResId());
        yesBtn.setOnClickListener(new View.OnClickListener() { // обработка нажатия пользователем кнопки "да"
            @Override
            public void onClick(View view) { //  реализуем метод onClick, который срабатывает при нажатии кнопки "да"
                if (questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this,R.string.correct, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,R.string.nocorrect, Toast.LENGTH_LONG).show();
                @ColorInt int color = Color.parseColor("#00ff00"); //  задал изменение цвета
                yesBtn.setBackgroundColor(color);  //  привязал изменение цвета при нажатии к кнопке "да"
                questionIndex++;
                if (questionIndex<5)  //  вместо этого можно сделать так (любое кол-во вопросов тогда, пойдет по кругу):
                                      //questionIndex = (questionIndex+1)%questions.length  не позволит выйти за пределы массива
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

        showAnswer.setOnClickListener(new View.OnClickListener() {  // обработчик клика кнопки show.. запускает новую активность когда нажали на кнопку
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);// намерение создать новую активность, новая активность запускается через андроид менеджер, в скобках текущая активность, где мы находимся (this) и  ту активность, которую хочу запустить
                intent.putExtra("answer",questions[questionIndex].isAnswerTrue());  //  прицепляю данные к ответу ( ключ, массив с вопросами[текущий вопрос] и ответ, достаем через геттер
                startActivity(intent); // командую: запускаем активность
            }
        });

    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO","Метод onStart() запущен");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO","Метод onResume() запущен");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO","Метод onPause() запущен");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){ // Метод сохранения данных перед уничтожением активности
        super.onSaveInstanceState(savedInstanceState); // запуск метода со ссылкой на родителя
        Log.d("SYSTEM INFO","Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex",questionIndex); // Добавили элемент по ключу, ключ потом запрашивается в строке 38
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO","Метод onStop() запущен");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO","Метод onDestroy() запущен");
    }
}
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

import java.util.ArrayList;

import Viev.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private TextView textView; // создал переменную textView
    private Button yesBtn;// создал кнопку "да"
    private Button noBtn;// создал кнопку "нет"
    private Button showAnswer;
    private Button resultBtn;

    private Question[] questions = new Question[]{ // создал массив question, название как у класса
            new Question(R.string.question1, true), // следующие строки - наполнение массива, элементы: 0
            new Question(R.string.question2, false), // 1   R.string.question - отсылка к string.xml, где храним строки
            new Question(R.string.question3, false), // 2   и какую кнопку нажать для правильного ответа
            new Question(R.string.question4, true),  // 3
            new Question(R.string.question5, true)   // 4
    };

    private ArrayList<String> AnswerResult = new ArrayList<String>(); // массив для показателей верности ответов
    private int questionIndex = 0; // переменная для нумерации вопросов, изначально нулевой вопрос

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // метод onCreate запускается со своим хранилищем Bundle saved...наподобие ArreyList, но в Андроид
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // активити мэйн вывелось на экран

        if (savedInstanceState != null){// при запуске приложения saved=null, там ничего нет
            questionIndex = savedInstanceState.getInt("questionIndex");  //если saved... не равен (!=) null, то берем значение question из него
        }

        textView = findViewById(R.id.textView); // нашли textView по идентификатору
        yesBtn = findViewById(R.id.yesBtn);// соединил кнопку "да" с компонентом view (xml), в скобках R - отсылка к ресурсам, папка res, далее id (ищем id) какой именно кнопки
        noBtn = findViewById(R.id.noBtn);//  соединил кнопку "нет" с компонентом view, стандартная конструкция, надо запомнить
        showAnswer = findViewById(R.id.showAnswer);  //  в общем, контактим с виджетом
        resultBtn = findViewById(R.id.resultBtn);

        textView.setText(questions[questionIndex].getQuestionResId()); // на текствью установлен текст с вопросом, сначала нулевой
        yesBtn.setOnClickListener(new View.OnClickListener() { // обработка нажатия пользователем кнопки "да"
            @Override
            public void onClick(View view) { //  реализуем метод onClick, который срабатывает при нажатии кнопки "да"
                if (questions[questionIndex].isAnswerTrue()) {  // далее записано все, что будет происходить, когда пользователь нажмет на кнопку
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_LONG).show();  // Toast - уведомление, контекст - ссылка на текущую активность,
                    AnswerResult.add(getString(R.string.correct)); // добавляем ответ в массив
                } else {                                                                             // необходимо показать уведомление в текущей активности,
                    Toast.makeText(MainActivity.this, R.string.nocorrect, Toast.LENGTH_LONG).show(); // далее строка - что появится на экране, потом - длительность того, что появится на экране.
                    AnswerResult.add(getString(R.string.nocorrect));
                    @ColorInt int color = Color.parseColor("#00ff00"); //  задал изменение цвета
                    yesBtn.setBackgroundColor(color);  //  привязал изменение цвета при нажатии к кнопке "да"
                    questionIndex++; // увеличиваем индекс, т.е. получаем номер следующего вопроса
                }
                    if (questionIndex<5)  //  вместо этого можно сделать так (любое кол-во вопросов тогда, пойдет по кругу):
                                      //questionIndex = (questionIndex+1)%questions.length  не позволит выйти за пределы массива
                    textView.setText(questions[questionIndex].getQuestionResId()); // выводим следующий вопрос
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.nocorrect, Toast.LENGTH_LONG).show();  // makeText - сделать уведомление, show - показать его
                    AnswerResult.add(getString(R.string.correct));
                } else {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_LONG).show();
                    AnswerResult.add(getString(R.string.nocorrect));
                    @ColorInt int color = Color.parseColor("#ff0000");
                    noBtn.setBackgroundColor(color);
                    questionIndex++;
                }
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

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("AnswerResult", AnswerResult);
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
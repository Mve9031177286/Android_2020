package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserFragment extends Fragment { //создал класс для фрагмента и расширяю(наследую) от класса из библиотеки поддержки
    private User user; // создаем объект, но глобально
    private TextView userName_userLastname_View; // создали виджет

    @Override  // переопределяем метод OnCreate
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // это родительский класс, обязателен
        user = new User(); // здесь мы создаем пустого пользователя, имя и фамилию будем доставать через intent
        user.setUserName("Ivan");
        user.setUserLastName("Ivanov");

    }

    @Override
    public View onCreatView(LayoutInflater, ViewGroup container, Bundle savedInstanceState); // создал метод вью, это и есть мой
    // фрагмент (создан элемент отображениея и отдан активности)
// вызывается для создания компонентов внутри фрагмента: переопределяем метод onCreat, положив аргументы 1.инфлятор "надувает" фрагмент
    //
        View view = inflater.inflate(R.layout.fragment_user, container, false); // с помощью метода инфлятор ( раздувать ) будет раздувать
    // шаблон, который здесь указан, т.е. создается фрагмент и все теперь будет лежать здесь (имя, фамилия и пр.)
        userName_userLastname_View = view.findViewById(R.id.userName_userLastname_View);// обратимся к этому вью и ищем по идентификатору элемент, св// язанный с юзером
        String userName = "Имя: "+user.getUserName()+"/n"+"Фамилия: "+user.getUserLastName();// склеим фамилию и имя
        userName_userLastname_View.setText(userName);// устанавливаем текст, положив в него предыдущую строку userName

        return view; //фрагмент возвращется в андроид и в этот момент на активности появляется компонент вью
    }
}

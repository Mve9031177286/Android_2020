package com.example.myapplication;

import java.util.UUID;

public class User {      // создаем класс пользователя
    private String userName;  // три строки - его характеристики, приватные, чтобы случайно не изменить
    private String userLastName;
    private UUID uuid; // уникальный идентификационный номер

    public User() {
        this.uuid = UUID.randomUUID(); // метод, котрый генерирует ID случайным образом
    }

    public String getUserName() {  // добавил геттеры и сеттеры к характеристикам
        return userName;     // напоминание: get возвращает, т.е.показывает значение
    }                        // а с помощью set значение присваивается

    public void setUserName(String userName) {  // геттеры и сеттеры стоит создавать всегда
        this.userName = userName;  // это полноценные методы и в них можно закладывать ограничения
    }

    public String getUserLastName() {  // снаружи, за пределами класса, должны быть доступны лишь методы
        return userLastName; // данные должны быть скрыты
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public UUID getUuid() { // для ID - только геттер: получить его мы можем, переписать - нет
        return uuid; // и это логично, иначе бред получится
    }

}

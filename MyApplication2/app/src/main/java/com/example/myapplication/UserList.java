package com.example.myapplication;

public class UserList { // создал класс для создания одного-единственного объекта - списка юзеров
    private static UserList userList; // статик - свойство, можем обращаться не создавая объект
    // приват - обратиться нельзя.
    public static UserList get(){
        if(userList == null){  // если юзерлист не существует
            userList = new UserList(); // мы его создаем
        }
        return userList; // если существует - возвращаем тот, который есть, два и более создать уже не получится
    } // чтобы вызвать геттер у класса, надо сказать, что он - статик
    private UserList(){}// приватный конструктор
}  // такой класс называется синглетным или просто синглета (может быть создан только один объект)
   // при попытке создать другой все равно вернется первый и единственный

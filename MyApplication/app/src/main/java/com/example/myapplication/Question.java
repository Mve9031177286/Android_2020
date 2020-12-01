package com.example.myapplication;

public class Question { // класс,отвечает за выдачу вопросов,хранит вопросы и ответы - верно или неверно
    private int questionResId; // поле хранит идентификатор строки
    private boolean answerTrue; // булевое значение, ответ  же может быть либо да, либо нет

    public Question(int questionResId, boolean answerTrue) { //конструктор
        this.questionResId = questionResId;
        this.answerTrue = answerTrue;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public void setQuestionResId(int questionResId) {
        this.questionResId = questionResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}

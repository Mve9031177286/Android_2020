package com.example.myapplication;

import android.view.View;

public class Viev {
    public abstract static class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }

        public abstract void onClick(Viev viev);
    }
}

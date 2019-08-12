package com.example.panicbutton;

import android.app.Application;

public class Globals extends Application {
    private int panicButtonCount = 0;

    public int getPanicButtonCount() {
        return panicButtonCount;
    }

    public void setPanicButtonCount(int panicButtonCount) {
        this.panicButtonCount = panicButtonCount;
    }
}

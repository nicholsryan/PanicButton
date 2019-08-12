package com.example.panicbutton;

import android.app.Application;

import java.util.ArrayList;

public class Globals extends Application {
    //private int panicButtonCount = 0;
    private ArrayList<Button> panicButtonList;

    /*
    public int getPanicButtonCount() {
        return panicButtonCount;
    }

    public void setPanicButtonCount(int panicButtonCount) {
        this.panicButtonCount = panicButtonCount;
    }
    */

    public void addPanicButtonToList(Button button) {
        panicButtonList.add(button);
    }

    public int getPanicButtonListSize() {
        return panicButtonList.size();
    }
}

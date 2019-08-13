package com.example.panicbutton;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class Globals extends Application {
    //private int panicButtonCount = 0;
    private ArrayList<Button> panicButtonList = new ArrayList<Button>();

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
        Log.d("SIZE", "panicButtonList.size() = " + panicButtonList.size());
        return panicButtonList.size();
    }
}

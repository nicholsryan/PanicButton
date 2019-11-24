package com.example.panicbutton;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class Globals extends Application {
    //private int panicButtonCount = 0;
    private ArrayList<PanicButton> panicButtonList = new ArrayList<PanicButton>();

    /*
    public int getPanicButtonCount() {
        return panicButtonCount;
    }

    public void setPanicButtonCount(int panicButtonCount) {
        this.panicButtonCount = panicButtonCount;
    }
    */

    public void addPanicButtonToList(PanicButton panicButton) {
        panicButtonList.add(panicButton);
    }
    
    public ArrayList<PanicButton> getPanicButtonList() {
        return panicButtonList;
    }
    
    public PanicButton getPanicButton(int buttonIndex) {
        for (PanicButton panicButton : panicButtonList) {
            if (panicButton.getPanicButtonIndex() == buttonIndex) {
                return panicButton;
            }
        }
        
        return null;
    }

    public int getPanicButtonListSize() {
        Log.d("SIZE", "panicButtonList.size() = " + panicButtonList.size());
        return panicButtonList.size();
    }
}

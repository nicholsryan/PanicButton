package com.example.panicbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Called when the user taps the "Add" button*/
    public void addPanicButton(View view) {
        Intent intent = new Intent(this, AddPanicButtonActivity.class);
        startActivity(intent);
    }

    /*Called when the user taps the "Preferences" button*/
    public void editPreferences(View view) {
        Intent intent = new Intent(this, EditPreferencesActivity.class);
        startActivity(intent);
    }
}

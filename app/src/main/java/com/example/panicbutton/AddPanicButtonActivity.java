package com.example.panicbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class AddPanicButtonActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_panic_button);

        //Get the Intent that started this activity
        Intent intent = getIntent();
    }

    public void createButton(View view) {
        Intent intent = new Intent(this, Button.class);
        Spinner panicButtonTypeSpinner = (Spinner) findViewById(R.id.panicButtonTypeSpinner);
        EditText editText =(EditText)findViewById(R.id.panicButtonName);
        String panicButtonName = editText.getText().toString();
        editText = (EditText) findViewById(R.id.panicButtonPhoneNumber);
        String panicButtonPhoneNumber = editText.getText().toString();
        String panicButtonType = panicButtonTypeSpinner.getSelectedItem().toString();
        Button button = new Button(panicButtonName, panicButtonPhoneNumber, panicButtonType);
    }
}

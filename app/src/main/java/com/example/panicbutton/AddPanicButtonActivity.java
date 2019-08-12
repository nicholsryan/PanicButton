package com.example.panicbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class AddPanicButtonActivity extends AppCompatActivity {
    /*
    private Spinner panicButtonTypeSpinner = (Spinner) findViewById(R.id.panicButtonTypeSpinner);
    //private String callString = getResources().getStringArray(R.array.panic_button_type_array);
    private String[] typeArray = getResources().getStringArray(R.array.panic_button_type_array);
    private String callString = typeArray[0];
    private String textString = typeArray[1];
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_panic_button);

        //Get the Intent that started this activity
        Intent intent = getIntent();
    }

    public void createButton(View view) {
        Intent intent = new Intent(this, Button.class);
        Globals g = (Globals) getApplication();
        Spinner panicButtonTypeSpinner;
        EditText editText;
        
        String panicButtonName;
        String panicButtonPhoneNumber;
        int panicButtonCount;

        panicButtonCount = g.getPanicButtonCount();
        panicButtonCount++;

        editText = (EditText) findViewById(R.id.panicButtonName);
        panicButtonName = editText.getText().toString();

        editText = (EditText) findViewById(R.id.panicButtonPhoneNumber);
        panicButtonPhoneNumber = editText.getText().toString();

        panicButtonTypeSpinner = (Spinner) findViewById(R.id.panicButtonTypeSpinner);
        String panicButtonType = panicButtonTypeSpinner.getSelectedItem().toString();

        Button button = new Button(panicButtonCount, panicButtonName, panicButtonPhoneNumber, panicButtonType);

        g.setPanicButtonCount(panicButtonCount++);
    }

    public void nextScreen(View view) {
        Spinner panicButtonTypeSpinner = (Spinner) findViewById(R.id.panicButtonTypeSpinner);
        //String callString = getResources().getStringArray(R.array.panic_button_type_array);
        String[] typeArray = getResources().getStringArray(R.array.panic_button_type_array);
        String callString = typeArray[0];
        String textString = typeArray[1];

        ConstraintLayout initialLayout = (ConstraintLayout) findViewById(R.id.addPanicButtonLayoutInitial);
        ConstraintLayout callLayout = (ConstraintLayout) findViewById(R.id.addPanicButtonLayoutCall);
        ConstraintLayout textLayout = (ConstraintLayout) findViewById(R.id.addPanicButtonLayoutText);
        String panicButtonType = panicButtonTypeSpinner.getSelectedItem().toString();

        if (panicButtonType.equals(callString)) {
            initialLayout.setVisibility(View.GONE);
            callLayout.setVisibility(View.VISIBLE);
        }
        else if (panicButtonType.equals(textString)) {
            initialLayout.setVisibility(View.GONE);
            textLayout.setVisibility(View.VISIBLE);
        }
    }
}

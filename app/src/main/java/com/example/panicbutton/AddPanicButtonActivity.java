package com.example.panicbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Globals g = (Globals) getApplication();
        Spinner panicButtonTypeSpinner;
        EditText editText;
        
        PanicButton panicButton;
        String panicButtonName;
        String panicButtonRecipient;
        String panicButtonPhoneNumber;
        String panicButtonType;
        String panicButtonMsg;
        int panicButtonIndex;
        
        panicButtonIndex = g.getPanicButtonListSize();
        
        editText = (EditText) findViewById(R.id.panicButtonName);
        panicButtonName = editText.getText().toString();

        editText = (EditText) findViewById(R.id.panicButtonRecipient);
        panicButtonRecipient = editText.getText().toString();

        editText = (EditText) findViewById(R.id.panicButtonPhoneNumber);
        panicButtonPhoneNumber = editText.getText().toString();

        panicButtonTypeSpinner = (Spinner) findViewById(R.id.panicButtonTypeSpinner);
        panicButtonType = panicButtonTypeSpinner.getSelectedItem().toString();
        
        editText = (EditText) findViewById(R.id.textButtonMessage);
        panicButtonMsg = editText.getText().toString();
        
        if (panicButtonType.equals("Call")) {
            panicButton = new PanicButton(panicButtonIndex, panicButtonName, panicButtonRecipient,
                    panicButtonPhoneNumber, panicButtonType);
        } else {
            panicButton = new PanicButton(panicButtonIndex, panicButtonName, panicButtonRecipient,
                    panicButtonPhoneNumber, panicButtonType, panicButtonMsg);
        }
        
        g.addPanicButtonToList(panicButton);

        Log.d("BUTTON_ADDED", "panicButton added to list");
        
        finish();
    }

    public void nextScreen(View view) {
        Spinner panicButtonTypeSpinner = (Spinner) findViewById(R.id.panicButtonTypeSpinner);
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

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
        Intent intent = new Intent(this, PanicButton.class);
        Globals g = (Globals) getApplication();
        Spinner panicButtonTypeSpinner;
        EditText editText;
        
        PanicButton panicButton;
        String panicButtonName;
        String panicButtonRecipient;
        String panicButtonPhoneNumber;
        String panicButtonType;
        String panicButtonMsg;
        //int panicButtonCount;
        int panicButtonIndex;

        Log.d("DECLARATIONS", "createButton() declarations successful");

        /*
        panicButtonCount = g.getPanicButtonCount();
        panicButtonCount++;
        */

        panicButtonIndex = g.getPanicButtonListSize();
        //panicButtonIndex++;
        Log.d("INDEX", "panicButtonIndex = " + panicButtonIndex);

        editText = (EditText) findViewById(R.id.panicButtonName);
        panicButtonName = editText.getText().toString();
        Log.d("NAME", "panicButtonName = " + panicButtonName);

        editText = (EditText) findViewById(R.id.panicButtonRecipient);
        panicButtonRecipient = editText.getText().toString();
        Log.d("RECIPIENT", "panicButtonRecipient = " + panicButtonRecipient);

        editText = (EditText) findViewById(R.id.panicButtonPhoneNumber);
        panicButtonPhoneNumber = editText.getText().toString();
        Log.d("PHONE_NUMBER", "panicButtonPhoneNumber = " + panicButtonPhoneNumber);

        panicButtonTypeSpinner = (Spinner) findViewById(R.id.panicButtonTypeSpinner);
        panicButtonType = panicButtonTypeSpinner.getSelectedItem().toString();
        Log.d("TYPE", "panicButtonType = " + panicButtonType);
        
        editText = (EditText) findViewById(R.id.textButtonMessage);
        panicButtonMsg = editText.getText().toString();
        Log.d("MESSAGE", "panicButtonMsg = " + panicButtonMsg);
        
        Log.d("PARAMETERS", "got parameters for PanicButton constructor");
        
        if (panicButtonType.equals("Call")) {
            panicButton = new PanicButton(panicButtonIndex, panicButtonName, panicButtonRecipient, panicButtonPhoneNumber, panicButtonType);
        } else {
            panicButton = new PanicButton(panicButtonIndex, panicButtonName, panicButtonRecipient, panicButtonPhoneNumber, panicButtonType, panicButtonMsg);
        }
        
        g.addPanicButtonToList(panicButton);

        Log.d("BUTTON_ADDED", "panicButton added to list");

        //g.setPanicButtonCount(panicButtonCount);

        finish();
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

package com.example.panicbutton;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonPressFragment extends Fragment implements ActivityCompat.OnRequestPermissionsResultCallback {
    
    private static final String ARG_BUTTON_INDEX = "button_index";
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 2;
    
    
    
    private PanicButton panicButton;
    private String panicButtonName;
    private TextView panicButtonNameTextView;
    private String panicButtonRecipient;
    private TextView panicButtonRecipientTextView;
    private String panicButtonPhoneNumber;
    private TextView panicButtonPhoneNumberTextView;
    private String panicButtonType;
    private String panicButtonMsg;
    private Button confirmButton;
    
    /*
    public ButtonPressFragment() {
        // Required empty public constructor
    }
    */
    
    public static ButtonPressFragment newInstance(int buttonIndex) {
        Log.d("BUTTONPRESSFRAGMENT", "beginning of newInstance()");
        Bundle args = new Bundle();
        Log.d("BUTTONPRESSFRAGMENT", "after creating new Bundle");
        args.putSerializable(ARG_BUTTON_INDEX, buttonIndex);
        
        Log.d("BUTTONPRESSFRAGMENT", "after args.putSerializable()");
        
        ButtonPressFragment fragment = new ButtonPressFragment();
        Log.d("BUTTONPRESSFRAGMENT", "after creating new ButtonPressFragment");
        fragment.setArguments(args);
        Log.d("BUTTONPRESSFRAGMENT", "after fragment.setArguments()");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("BUTTONPRESSFRAGMENT", "beginning of onCreate()");
        super.onCreate(savedInstanceState);
        Log.d("BUTTONPRESSFRAGMENT", "after super.onCreate()");

        Globals g = (Globals) getActivity().getApplication();
        Log.d("BUTTONPRESSFRAGMENT", "after setting Globals instance g");
        
        int buttonIndex = (int) getArguments().getSerializable(ARG_BUTTON_INDEX);
        Log.d("BUTTONPRESSFRAGMENT", "after setting buttonIndex via getSerializable()");
        panicButton = g.getPanicButton(buttonIndex);
        Log.d("BUTTONPRESSFRAGMENT", "after getPanicButton");
        
        return;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button_press, container, false);
        
        View.OnClickListener confirmListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast confirmToast;
                confirmToast = Toast.makeText(getActivity(), "CONFIRM " + panicButtonType, Toast.LENGTH_SHORT);
                confirmToast.show();

                if (panicButtonType.equals("Call")) {
                    //confirmToast.show();
                    
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    Log.d("BUTTONPRESSFRAGMENT", "after creating callIntent");
                    callIntent.setData(Uri.parse("tel:+1-336-416-5446"));
                    Log.d("BUTTONPRESSFRAGMENT", "after setting callIntent number");
                    
                    //int callPhonePermission = ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CALL_PHONE);
                    //Log.d("BUTTONPRESSFRAGMENT", "Manifest.permission.CALL_PHONE = \"" + callPhonePermission + "\"");
                    
                    //May need to change ActivityCompat to ContextCompat
                    if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
                        return;
                    }
                    else {
                        makeCall(callIntent);
                        //startActivity(callIntent);
                        //Log.d("BUTTONPRESSFRAGMENT", "after startActivity()");
                    }
                    
                }
                else if (panicButtonType.equals("Text")) {
                    if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
                        return;
                    }
                    else {
                        //Intent textIntent = new Intent(Intent.)
                        sendSMS();
                    }
                }
                return;
            }
        };
        
        /*
        PanicButton panicButton;
        TextView panicButtonNameTextView;
        TextView panicButtonRecipientTextView;
        TextView panicButtonPhoneNumberTextView;
        */
        
        panicButtonNameTextView = (TextView) view.findViewById(R.id.pressedButtonName);
        panicButtonRecipientTextView = (TextView) view.findViewById(R.id.pressedButtonRecipient);
        panicButtonPhoneNumberTextView = (TextView) view.findViewById(R.id.pressedButtonPhoneNumber);
        confirmButton = (Button) view.findViewById(R.id.confirm_button);
        
        panicButtonNameTextView.setText(panicButton.getPanicButtonName());
        panicButtonRecipientTextView.setText(panicButton.getPanicButtonRecipient());
        panicButtonPhoneNumberTextView.setText(panicButton.getPanicButtonPhoneNumber());

        panicButtonName = panicButton.getPanicButtonName();
        panicButtonRecipient = panicButton.getPanicButtonRecipient();
        panicButtonPhoneNumber = panicButton.getPanicButtonPhoneNumber();
        panicButtonType = panicButton.getPanicButtonType();
        panicButtonMsg = panicButton.getPanicButtonMsg();
        
        confirmButton.setOnClickListener(confirmListener);
        
        return view;
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Permission granted, make call
                } else {
                    //Permission denied, can't make call
                }
                return;
            }
            
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Permission granted, send sms
                } else {
                    //Permission denied, can't send sms
                }
                return;
            }
            
            //Cases for potential future permissions requests can go here
        }
        return;
    }
    
    public void makeCall(Intent callIntent) {
        startActivity(callIntent);
        Log.d("BUTTONPRESSFRAGMENT", "makeCall(): after startActivity(callIntent)");
        return;
    }
    
    public void sendSMS() {
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(panicButtonPhoneNumber, null, panicButtonMsg, null, null);
        Log.d("BUTTONPRESSFRAGMENT", "sendSMS(): after sendTextMessage()");
        Log.d("BUTTONPRESSFRAGMENT", "sendSMS(): panicButtonMsg = \"" + panicButtonMsg + "\"");
        return;
    }
    
}

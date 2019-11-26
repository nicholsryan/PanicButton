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
public class ButtonPressFragment extends Fragment
        implements ActivityCompat.OnRequestPermissionsResultCallback {
    
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
    
    
    public static ButtonPressFragment newInstance(int buttonIndex) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_BUTTON_INDEX, buttonIndex);
        
        ButtonPressFragment fragment = new ButtonPressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Globals g = (Globals) getActivity().getApplication();
        
        int paniButtonIndex = (int) getArguments().getSerializable(ARG_BUTTON_INDEX);
        panicButton = g.getPanicButton(paniButtonIndex);
        
        return;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button_press, container, false);
        
        View.OnClickListener confirmListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String[] typeArray = getResources().getStringArray(R.array.panic_button_type_array);
                String callString = typeArray[0];
                String textString = typeArray[1];

                if (panicButtonType.equals(callString)) {
                    if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.CALL_PHONE},
                                MY_PERMISSIONS_REQUEST_CALL_PHONE);
                        return;
                    }
                    else {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse(panicButtonPhoneNumber));
                        makeCall(callIntent);
                    }
                }
                else if (panicButtonType.equals(textString)) {
                    if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
                            Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.SEND_SMS},
                                MY_PERMISSIONS_REQUEST_SEND_SMS);
                        return;
                    }
                    else {
                        Uri uri = Uri.parse(panicButtonPhoneNumber);
                        Intent textIntent = new Intent(Intent.ACTION_SENDTO, uri);
                        textIntent.putExtra("sms_body", panicButtonMsg);
                        sendSMS(textIntent);
//                        sendSMS();  //Send SMS without opening default SMS app
                    }
                }
                return;
            }
        };
        
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
    
    //Send SMS without opening default SMS app
    public void sendSMS() {
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(panicButtonPhoneNumber, null, panicButtonMsg, null, null);
        Log.d("BUTTONPRESSFRAGMENT", "sendSMS(): after sendTextMessage()");
        Log.d("BUTTONPRESSFRAGMENT", "sendSMS(): panicButtonMsg = \"" + panicButtonMsg + "\"");
        return;
    }
    
    //Send SMS by opening default SMS app
    public void sendSMS(Intent textIntent) {
        startActivity(textIntent);
        Log.d("BUTTONPRESSFRAGMENT", "sendSMS(): panicButtonMsg = \"" + panicButtonMsg + "\"");
    }
    
}

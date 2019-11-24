package com.example.panicbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ButtonPressActivity extends AppCompatActivity {
    
    private static final String EXTRA_BUTTON_INDEX = "com.example.panicbutton.button_index";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("BUTTONPRESSACTIVITY", "beginning of onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_press);
        
        Log.d("BUTTONPRESSACTIVITY", "after setContentView()");
        
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        
        Log.d("BUTTONPRESSACTIVITY", "after findFragmentById()");
        
        if (fragment == null) {
            Log.d("BUTTONPRESSACTIVITY", "fragment == null");
            fragment = createFragment();
            Log.d("BUTTONPRESSACTIVITY", "after createFragment()");
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
            Log.d("BUTTONPRESSACTIVITY", "after commit()");
        }
    }
    
    public static Intent newIntent(Context packageContext, int buttonIndex) {
        Log.d("BUTTONPRESSACTIVITY", "beginning of newIntent");
        Intent intent = new Intent(packageContext, ButtonPressActivity.class);
        Log.d("BUTTONPRESSACTIVITY", "after intent created");
        intent.putExtra(EXTRA_BUTTON_INDEX, buttonIndex);
        Log.d("BUTTONPRESSACTIVITY", "after putExtra()");
        return intent;
    }
    
    protected Fragment createFragment() {
        Log.d("BUTTONPRESSACTIVITY", "beginning of createFragment()");
        int buttonIndex = (int) getIntent().getSerializableExtra(EXTRA_BUTTON_INDEX);
        return ButtonPressFragment.newInstance(buttonIndex);
    }
}

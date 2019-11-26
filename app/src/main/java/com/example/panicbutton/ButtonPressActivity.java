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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_press);
        
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
    
    public static Intent newIntent(Context packageContext, int buttonIndex) {
        Intent intent = new Intent(packageContext, ButtonPressActivity.class);
        intent.putExtra(EXTRA_BUTTON_INDEX, buttonIndex);
        return intent;
    }
    
    protected Fragment createFragment() {
        int buttonIndex = (int) getIntent().getSerializableExtra(EXTRA_BUTTON_INDEX);
        return ButtonPressFragment.newInstance(buttonIndex);
    }
}

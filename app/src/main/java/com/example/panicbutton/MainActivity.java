package com.example.panicbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView buttonRecyclerView;
    private ButtonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonRecyclerView = (RecyclerView) findViewById(R.id.button_recycler_view);
        buttonRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        
        updateUI();
    }
    
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    
    private void updateUI() {
        Globals g = (Globals) getApplication();
        ArrayList<PanicButton> panicButtonList = g.getPanicButtonList();
        
        if (adapter == null) {
            adapter = new ButtonAdapter(panicButtonList);
            buttonRecyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
    
    private class ButtonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private PanicButton panicButton;
        private Button buttonItem;
        
        public ButtonHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_button, parent, false));
            itemView.setOnClickListener(this);
            
            buttonItem = (Button) itemView.findViewById(R.id.button_item);
        }
        
        public void bind(PanicButton panicButton) {
            this.panicButton = panicButton;
            buttonItem.setText(panicButton.getPanicButtonName());
            buttonItem.setOnClickListener(this);
        }
        
        @Override
        public void onClick(View view) {
            Log.d("BUTTONHOLDER", "ButtonHolder.onClick(): beginning of onClick()");
            Intent intent = ButtonPressActivity.newIntent(getApplicationContext(),
                    panicButton.getPanicButtonIndex());
            Log.d("BUTTONHOLDER", "ButtonHolder.onClick(): after newIntent()");
            startActivity(intent);
            Log.d("BUTTONHOLDER", "ButtonHolder.onClick(): after startActivity()");
        }
    }
    
    private class ButtonAdapter extends RecyclerView.Adapter<ButtonHolder> {
        private ArrayList<PanicButton> panicButtonList;
        
        private ButtonAdapter(ArrayList<PanicButton> panicButtonList) {
            this.panicButtonList = panicButtonList;
        }
        
        @NonNull
        @Override
        public ButtonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            
            return new ButtonHolder(layoutInflater, parent);
        }
        
        @Override
        public void onBindViewHolder(@NonNull ButtonHolder holder, int position) {
            PanicButton panicButton = panicButtonList.get(position);
            holder.bind(panicButton);
        }
        
        @Override
        public int getItemCount() {
            return panicButtonList.size();
        }
    }

    /*Called when the user taps the "Add" panicButton*/
    public void addPanicButton(View view) {
        Intent intent = new Intent(this, AddPanicButtonActivity.class);
        startActivity(intent);
    }

    /*Called when the user taps the "Preferences" panicButton*/
    public void editPreferences(View view) {
        Intent intent = new Intent(this, EditPreferencesActivity.class);
        startActivity(intent);
    }

}

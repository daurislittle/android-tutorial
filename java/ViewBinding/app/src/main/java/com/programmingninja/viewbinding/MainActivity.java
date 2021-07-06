package com.programmingninja.viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.programmingninja.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //binding class to the xml
    //allows the system to automatically generate the system
    ActivityMainBinding amb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflating the xml
        amb = ActivityMainBinding.inflate(getLayoutInflater());

        //retrieve the root layout
        View v = amb.getRoot();

        //ContentView for the layout
        setContentView(v);

        //calling the button and setting the click listener
        //call the button by id and set the click listener
        amb.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = amb.etMessage.getText().toString();
                if (!msg.isEmpty()) Snackbar.make(amb.clLayer, amb.etMessage.getText().toString(), Snackbar.LENGTH_SHORT).show();
                else Snackbar.make(amb.clLayer, "Message is empty", Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}
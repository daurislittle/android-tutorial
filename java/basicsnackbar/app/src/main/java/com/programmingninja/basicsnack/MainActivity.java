package com.programmingninja.basicsnack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout cl;
    private Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = findViewById(R.id.app_Coordinator);
        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
    }

    public void basicSnack(View v){
        Snackbar sb = Snackbar.make(cl, "This is a basic Snackbar Display", Snackbar.LENGTH_SHORT);
        sb.show();
    }

    public void basicActionSnack(View v) {
        Snackbar sb = Snackbar.make(cl, "Snackbar with Action Feature", Snackbar.LENGTH_SHORT);
        sb.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Undo action", Toast.LENGTH_SHORT).show();
            }
        });

        sb.show();
    }

    public void basicCustomSnack( View v) {
        Snackbar sb = Snackbar.make(cl, "Custom Snackbar", Snackbar.LENGTH_SHORT);
        sb.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Undoing Action", Toast.LENGTH_SHORT).show();
            }
        });

        sb.setActionTextColor(Color.CYAN);

        View sbv = sb.getView();
        TextView tv = sbv.findViewById(R.id.snackbar_text);
        tv.setTextColor(Color.GREEN);

        sb.show();
    }
}

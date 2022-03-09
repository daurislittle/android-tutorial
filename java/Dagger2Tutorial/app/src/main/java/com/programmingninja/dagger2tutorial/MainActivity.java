package com.programmingninja.dagger2tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.programmingninja.dagger2tutorial.helper.DaggerMyComponent;
import com.programmingninja.dagger2tutorial.helper.MyComponent;
import com.programmingninja.dagger2tutorial.helper.SharePrefModule;

import java.util.Locale;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;
import dagger.internal.DaggerGenerated;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatEditText txtUserName, txtNumeric;
    AppCompatButton btnSave, btnRetrieve;
    LinearLayoutCompat parent;

    private MyComponent mc;

    @Inject
    SharedPreferences sp;

    //init Dagger Componenent and inject it
    private void initDaggerComponent() {
        mc = DaggerMyComponent
                .builder()
                .sharePrefModule(new SharePrefModule(this))
                .build();
        mc.inject(this);
    }

    //init the AppCompatEditText and AppCompatButton
    private void initViews() {
        parent = findViewById(R.id.root_level);
        txtUserName = findViewById(R.id.et_username);
        txtNumeric = findViewById(R.id.et_numeric);

        btnSave = findViewById(R.id.btn_storeValue);
        btnRetrieve = findViewById(R.id.btn_findData);

        btnSave.setOnClickListener(this);
        btnRetrieve.setOnClickListener(this);
    }

    //clear the fields after saving
    private void  clearFields() {
        txtUserName.setText(null);
        txtNumeric.setText(null);
    }

    private void deleteRecord() {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_findData:
                retrieveSharedPreferenceData();
                break;
            case R.id.btn_storeValue:
                saveSharedPerferenceData();
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        initDaggerComponent();
    }

    private void saveSharedPerferenceData() {
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("username", txtUserName.getText().toString().trim()); //get value from appcompatedittext
        editor.putString("number", txtNumeric.getText().toString().trim()); //get value from appcompatedittext
        editor.commit();

        Snackbar.make(parent, "Data Stored", Snackbar.LENGTH_SHORT).show();
        clearFields();
    }

    private void retrieveSharedPreferenceData() {
        txtUserName.setText(sp.getString("username", "No Data"));
        txtNumeric.setText(sp.getString("number", "0000"));

        if (txtUserName.getText().toString() == "No Data"){
            Snackbar.make(parent, "Pardon sir/madam no data", Snackbar.LENGTH_LONG).show();
        }
    }

}
package com.africa.cloud.basefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class NettoyageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nettoyage);

        Toolbar toolbar = findViewById(R.id.toolbar); //Declaration du toolbar
        toolbar.setTitle("Mon Pressing");//Donner au toobar
    }
}

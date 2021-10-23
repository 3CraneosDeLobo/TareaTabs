package com.example.tareatabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OptionsActivity extends AppCompatActivity {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        String username = getIntent().getStringExtra("username");
        txt = findViewById(R.id.option);

        txt.setText("Entraste a "+username);


    }
}
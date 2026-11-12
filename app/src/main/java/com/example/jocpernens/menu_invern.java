package com.example.jocpernens;

import android.os.Bundle;
import android.graphics.Color;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class menu_invern extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        LinearLayout cabecera = findViewById(R.id.cabecera);
        cabecera.setBackgroundColor(Color.parseColor("#5DADE2"));
    }
}

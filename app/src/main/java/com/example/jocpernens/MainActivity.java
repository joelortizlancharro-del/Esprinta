package com.example.jocpernens;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // al darle a jugar vamos a elegir estacion
        findViewById(R.id.btnJugar).setOnClickListener(v -> {
            Intent intent = new Intent(this, EstacionesActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btnProfessorat).setOnClickListener(v -> {
            Intent intent = new Intent(this, AccesoActivity.class);
            startActivity(intent);
        });
    }
}
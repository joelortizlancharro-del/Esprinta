package com.example.jocpernens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AccesoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acceso);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnInicio).setOnClickListener(v -> finish());

        // 3 + 2 = 5, solo el 5 deja entrar al panel
        findViewById(R.id.btn5).setOnClickListener(v -> {
            Intent intent = new Intent(this, PanelActivity.class);
            startActivity(intent);
            finish();
        });
        findViewById(R.id.btn4).setOnClickListener(v -> mal());
        findViewById(R.id.btn6).setOnClickListener(v -> mal());
    }

    private void mal() {
        Toast.makeText(this, "NO ÉS CORRECTE", Toast.LENGTH_SHORT).show();
    }
}

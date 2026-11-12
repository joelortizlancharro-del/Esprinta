package com.example.jocpernens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EstacionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_estaciones);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // en esta pantalla la cabecera es blanca y sin estacion
        findViewById(R.id.cabecera).setBackgroundColor(getColor(R.color.blanco));
        findViewById(R.id.pastillaEstacion).setVisibility(View.GONE);
        findViewById(R.id.btnAtras).setVisibility(View.GONE);
        TextView titulo = findViewById(R.id.txtTitulo);
        titulo.setText(R.string.tria_estacio);

        findViewById(R.id.btnInicio).setOnClickListener(v -> finish());

        // cada tarjeta abre el menu con su estacion
        findViewById(R.id.cardPrimavera).setOnClickListener(v -> abrirMenu("PRIMAVERA"));
        findViewById(R.id.cardVerano).setOnClickListener(v -> abrirMenu("ESTIU"));
        findViewById(R.id.cardOtono).setOnClickListener(v -> abrirMenu("TARDOR"));
        findViewById(R.id.cardInvierno).setOnClickListener(v -> abrirMenu("HIVERN"));
    }

    private void abrirMenu(String estacion) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("estacion", estacion);
        startActivity(intent);
    }
}

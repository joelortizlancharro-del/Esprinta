package com.example.jocpernens;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RelacionarActivity extends AppCompatActivity {

    String estacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_relacionar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        estacion = getIntent().getStringExtra("estacion");
        Cabecera.poner(this, estacion, getString(R.string.on_es, articulo()));

        // el simbolo grande de la estacion
        ImageView simbolo = findViewById(R.id.imgSimbolo);
        if (estacion.equals("PRIMAVERA")) {
            simbolo.setImageResource(R.drawable.ic_primavera);
            simbolo.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.estacion_primavera)));
        } else if (estacion.equals("ESTIU")) {
            simbolo.setImageResource(R.drawable.ic_verano);
            simbolo.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.estacion_verano)));
        } else if (estacion.equals("HIVERN")) {
            simbolo.setImageResource(R.drawable.ic_invierno);
            simbolo.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.estacion_invierno)));
        }

        // cuando acaba va a la pantalla de molt be
        findViewById(R.id.btnFet).setOnClickListener(v -> {
            Intent intent = new Intent(this, FelicitacionActivity.class);
            startActivity(intent);
        });
    }

    // para el titulo: ON ES LA PRIMAVERA?, ON ES L'ESTIU?...
    private String articulo() {
        if (estacion.equals("PRIMAVERA")) return "LA PRIMAVERA";
        if (estacion.equals("ESTIU")) return "L'ESTIU";
        if (estacion.equals("TARDOR")) return "LA TARDOR";
        return "L'HIVERN";
    }
}

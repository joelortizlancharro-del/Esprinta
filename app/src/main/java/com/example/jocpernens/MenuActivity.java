package com.example.jocpernens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    String estacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        estacion = getIntent().getStringExtra("estacion");
        Cabecera.poner(this, estacion, getString(R.string.que_vols_fer));
        ponerFotos();

        // cada actividad se abre con un intent y le pasamos la estacion
        findViewById(R.id.actRelaciona).setOnClickListener(v -> abrir(RelacionarActivity.class));
        findViewById(R.id.actVestir).setOnClickListener(v -> abrir(VestirActivity.class));
        findViewById(R.id.actCanciones).setOnClickListener(v -> abrir(CancionesActivity.class));
        findViewById(R.id.actArbol).setOnClickListener(v -> abrir(ArbolActivity.class));
        findViewById(R.id.actMochila).setOnClickListener(v -> abrir(MochilaActivity.class));
    }

    private void abrir(Class<?> pantalla) {
        Intent intent = new Intent(this, pantalla);
        intent.putExtra("estacion", estacion);
        startActivity(intent);
    }

    // las fotos del menu cambian segun la estacion
    private void ponerFotos() {
        ImageView imgRelaciona = findViewById(R.id.imgRelaciona);
        ImageView imgArbol = findViewById(R.id.imgArbol);
        ImageView imgMochila = findViewById(R.id.imgMochila);

        if (estacion.equals("PRIMAVERA")) {
            imgRelaciona.setImageResource(R.drawable.foto_jardin);
            imgArbol.setImageResource(R.drawable.foto_flores);
            imgMochila.setImageResource(R.drawable.foto_paraguas);
        } else if (estacion.equals("ESTIU")) {
            imgRelaciona.setImageResource(R.drawable.foto_playa);
            imgArbol.setImageResource(R.drawable.foto_hojas_verdes);
            imgMochila.setImageResource(R.drawable.foto_gafas);
        } else if (estacion.equals("TARDOR")) {
            imgRelaciona.setImageResource(R.drawable.foto_bosque);
            imgArbol.setImageResource(R.drawable.foto_hojas_marrones);
            imgMochila.setImageResource(R.drawable.foto_botas);
        } else {
            imgRelaciona.setImageResource(R.drawable.foto_montana);
            imgArbol.setImageResource(R.drawable.foto_nieve);
            imgMochila.setImageResource(R.drawable.foto_guantes);
        }
    }
}

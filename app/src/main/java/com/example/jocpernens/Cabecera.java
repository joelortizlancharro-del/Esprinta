package com.example.jocpernens;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// la cabecera es igual en todas las pantallas de juego, asi no repetimos el codigo
public class Cabecera {

    public static void poner(AppCompatActivity pantalla, String estacion, String titulo) {
        int color, fondo, icono, nombre;

        if (estacion.equals("PRIMAVERA")) {
            color = R.color.estacion_primavera;
            fondo = R.color.fondo_primavera;
            icono = R.drawable.ic_primavera;
            nombre = R.string.primavera;
        } else if (estacion.equals("ESTIU")) {
            color = R.color.estacion_verano;
            fondo = R.color.fondo_verano;
            icono = R.drawable.ic_verano;
            nombre = R.string.estiu;
        } else if (estacion.equals("TARDOR")) {
            color = R.color.estacion_otono;
            fondo = R.color.fondo_otono;
            icono = R.drawable.ic_otono;
            nombre = R.string.tardor;
        } else {
            color = R.color.estacion_invierno;
            fondo = R.color.fondo_invierno;
            icono = R.drawable.ic_invierno;
            nombre = R.string.hivern;
        }

        pantalla.findViewById(R.id.cabecera).setBackgroundColor(pantalla.getColor(color));
        pantalla.findViewById(R.id.main).setBackgroundColor(pantalla.getColor(fondo));

        ImageView imgEstacion = pantalla.findViewById(R.id.imgEstacion);
        imgEstacion.setImageResource(icono);
        imgEstacion.setBackgroundTintList(ColorStateList.valueOf(pantalla.getColor(color)));
        TextView txtEstacion = pantalla.findViewById(R.id.txtEstacion);
        txtEstacion.setText(nombre);
        TextView txtTitulo = pantalla.findViewById(R.id.txtTitulo);
        txtTitulo.setText(titulo);

        // casa: al inicio cerrando las pantallas de en medio
        pantalla.findViewById(R.id.btnInicio).setOnClickListener(v -> {
            Intent intent = new Intent(pantalla, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pantalla.startActivity(intent);
        });
        // flecha: pantalla anterior
        pantalla.findViewById(R.id.btnAtras).setOnClickListener(v -> pantalla.finish());
    }
}

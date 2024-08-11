package com.example.entregareto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {

    ImageView ImageViewCancha;
    ImageView ImageViewArena;
    ImageView ImageViewGym;
    ImageView ImageViewPiscina;
    ImageView Consejos;
    ImageView Inicio;
    ImageView Estadistica;
    ImageView Bolsa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);


        ImageViewCancha = findViewById(R.id.imageView13);
        ImageViewArena = findViewById(R.id.imageView14);
        ImageViewGym = findViewById(R.id.imageView15);
        ImageViewPiscina = findViewById(R.id.imageView16);
        Consejos = findViewById(R.id.imageView12);

        ImageViewCancha.setOnClickListener(view -> {
            Intent intent = new Intent(this, AgregaPanelActivity.class);
            startActivity(intent);
        });

        ImageViewArena.setOnClickListener(view -> {
            Intent intent = new Intent(this, AgregaPanelActivity.class);
            startActivity(intent);
        });

        ImageViewGym.setOnClickListener(view -> {
            Intent intent = new Intent(this, AgregaPanelActivity.class);
            startActivity(intent);
        });

        ImageViewPiscina.setOnClickListener(view -> {
            Intent intent = new Intent(this, AgregaPanelActivity.class);
            startActivity(intent);
        });

        Consejos.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConsejoActivity.class);
            startActivity(intent);
        });

        Estadistica = findViewById(R.id.imageView10);
        Estadistica.setOnClickListener(view -> {
            Toast.makeText(this, "Funcion no disponible", Toast.LENGTH_SHORT).show();
        });
        Bolsa = findViewById(R.id.imageView11);
        Bolsa.setOnClickListener(view -> {
            Toast.makeText(this, "Funcion no disponible", Toast.LENGTH_SHORT).show();
        });



    }
}

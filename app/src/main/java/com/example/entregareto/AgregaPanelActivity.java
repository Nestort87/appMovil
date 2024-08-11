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

public class AgregaPanelActivity extends AppCompatActivity {

    private ImageView Inicio;
    private ImageView Estadistica;
    private ImageView Bolsa;
    private ImageView Consejos;
    private ImageView AgregarPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agrega_panel);

        Inicio = findViewById(R.id.imageView9);
        Inicio.setOnClickListener(view -> {
            Intent intent = new Intent(this, PrincipalActivity.class);
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
        Consejos = findViewById(R.id.imageView12);
        Consejos.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConsejoActivity.class);
            startActivity(intent);
        });
        AgregarPanel = findViewById(R.id.bottonMedio);
        AgregarPanel.setOnClickListener(view -> {
            Toast.makeText(this, "Funcion no disponible", Toast.LENGTH_SHORT).show();
        });




    }
}
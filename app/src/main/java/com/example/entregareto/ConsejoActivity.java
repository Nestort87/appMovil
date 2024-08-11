package com.example.entregareto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import org.json.JSONArray;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ConsejoActivity extends AppCompatActivity {

    private TextView tvEcoTip;
    private TextView tvCounter;
    private final List<String> ecoTips = new ArrayList<>();
    private int currentIndex = 0;
    private final Handler handler = new Handler();
    private final int updateInterval = 1000; // Actualización cada segundo
    private final int totalDuration = 10000; // Duración total de 10 segundos
    private int timeLeft = totalDuration / updateInterval;

    private ImageView Inicio;
    private ImageView Estadistica;
    private ImageView Bolsa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consejo);

        tvEcoTip = findViewById(R.id.tvEcoTip);
        tvCounter = findViewById(R.id.tvCounter);

        loadEcoTips();
        displayNextTip();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (timeLeft > 0) {
                    tvCounter.setText("Siguiente consejo en " + timeLeft + " segundos");
                    timeLeft--;
                    handler.postDelayed(this, updateInterval);
                } else {
                    displayNextTip();
                    timeLeft = totalDuration / updateInterval;
                    handler.postDelayed(this, updateInterval);
                }
            }
        }, updateInterval);

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

    }

    private void loadEcoTips() {
        try {
            InputStream is = getAssets().open("eco_tips.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                ecoTips.add(jsonArray.getString(i));
            }
        } catch (IOException | org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    private void displayNextTip() {
        if (!ecoTips.isEmpty()) {
            tvEcoTip.setText(ecoTips.get(currentIndex));
            currentIndex = (currentIndex + 1) % ecoTips.size();
        }


    }
}
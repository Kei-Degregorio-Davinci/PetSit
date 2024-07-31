package com.example.petsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MascotaEncontradaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_encontrada);

        Button btnReportarMascota = findViewById(R.id.btnReportarMascota);
        btnReportarMascota.setOnClickListener(v -> {
            Toast.makeText(this, "Reportar una mascota encontrada", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MascotaEncontradaActivity.this, ReportarMascotaEncontradaActivity.class);
            startActivity(intent);
        });

        // Botón de retroceso
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(MascotaEncontradaActivity.this, MenuUsuarioActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
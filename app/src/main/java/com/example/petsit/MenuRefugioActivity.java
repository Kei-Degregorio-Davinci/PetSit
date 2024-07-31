package com.example.petsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuRefugioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_refugio);


        ImageButton btnBack = findViewById(R.id.btnBack);
        ImageButton btnExit = findViewById(R.id.btnExit);
        ImageButton btnMisAnimales = findViewById(R.id.btnMisAnimales);
        ImageButton btnReportes = findViewById(R.id.btnReportes);
        ImageButton btnSolicitudes = findViewById(R.id.btnSolicitudes);
        ImageButton btnPerfilRefugio = findViewById(R.id.btnPerfilRefugio);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(MenuRefugioActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        btnExit.setOnClickListener(v -> {
            Toast.makeText(this, "Hasta pronto", Toast.LENGTH_SHORT).show();
            finishAffinity(); // Cierra todas las actividades y sale de la aplicación
        });

        btnMisAnimales.setOnClickListener(view -> {
            Toast.makeText(this, "Mis animales", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuRefugioActivity.this, MisAnimalesActivity.class);
            startActivity(intent);
            finish();
        });

        btnReportes.setOnClickListener(view -> {
            Toast.makeText(this, "Reportes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuRefugioActivity.this, ReportesActivity.class);
            startActivity(intent);
            finish();
        });

        btnSolicitudes.setOnClickListener(view -> {
            Toast.makeText(this, "Solicitudes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuRefugioActivity.this, SolicitudesActivity.class);
            startActivity(intent);
            finish();
        });

        btnPerfilRefugio.setOnClickListener(view -> {
            Toast.makeText(this, "Mi Perfil", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuRefugioActivity.this, PerfilRefugiosActivity.class);
            startActivity(intent);
            finish();
        });



    }
}
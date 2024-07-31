package com.example.petsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MascotaPerdidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_perdida);

        Button btnReportarMascota = findViewById(R.id.btnReportarMascota);
        btnReportarMascota.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MascotaPerdidaActivity.this, ReportarMascotaActivity.class);
                startActivity(intent);
            }
        });

        // Botón de retroceso
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(MascotaPerdidaActivity.this, MenuUsuarioActivity.class);
            startActivity(intent);
            finish();
        });


    }
}
package com.example.petsit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MenuUsuarioActivity extends AppCompatActivity {

    private ImageButton btnBack, btnExit,
            btnRegistrarMascota, btnMascotaPerdida,
            btnMascotaEncontrada, btnRefugios, btnPetshop,
            btnChat, btnPerfil, btnAjustes, btnQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);

        btnBack = findViewById(R.id.btnBack);
        btnExit = findViewById(R.id.btnExit);
        btnRegistrarMascota = findViewById(R.id.btnRegistrarMascota);
        btnMascotaPerdida = findViewById(R.id.btnMascotaPerdida);
        btnMascotaEncontrada = findViewById(R.id.btnMascotaEncontrada);
        btnRefugios = findViewById(R.id.btnRefugios);
        btnPetshop = findViewById(R.id.btnPetshop);
        btnChat = findViewById(R.id.btnChat);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnAjustes = findViewById(R.id.btnAjustes);
        btnQr = findViewById(R.id.btnQr);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(MenuUsuarioActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // Cierra todas las actividades y sale de la aplicación
            }
        });

        btnRegistrarMascota.setOnClickListener(view -> {
            Intent intent = new Intent(MenuUsuarioActivity.this, RegistroMascotaActivity.class);
            startActivity(intent);
            finish();
        });

        btnMascotaPerdida.setOnClickListener(view -> {
            Intent intent = new Intent(MenuUsuarioActivity.this, MascotaPerdidaActivity.class);
            startActivity(intent);
            finish();
        });

        btnMascotaEncontrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción para reportar mascota encontrada
            }
        });

        btnRefugios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción para ver refugios
            }
        });

        btnPetshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción para ir al Petshop
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción para abrir el chat
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción para ver perfil
            }
        });

        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción para abrir ajustes
            }
        });

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción para abrir QR
            }
        });
    }
}

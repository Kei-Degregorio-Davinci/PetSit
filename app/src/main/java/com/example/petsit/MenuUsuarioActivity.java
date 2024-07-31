package com.example.petsit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);

        ImageButton btnBack = findViewById(R.id.btnBack);
        ImageButton btnExit = findViewById(R.id.btnExit);
        ImageButton btnRegistrarMascota = findViewById(R.id.btnRegistrarMascota);
        ImageButton btnMascotaPerdida = findViewById(R.id.btnMascotaPerdida);
        ImageButton btnMascotaEncontrada = findViewById(R.id.btnMascotaEncontrada);
        ImageButton btnRefugios = findViewById(R.id.btnRefugios);
        ImageButton btnPetshop = findViewById(R.id.btnPetshop);
        ImageButton btnPerfil = findViewById(R.id.btnPerfil);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(MenuUsuarioActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        btnExit.setOnClickListener(v -> {
            Toast.makeText(this, "Hasta pronto", Toast.LENGTH_SHORT).show();
            finishAffinity(); // Cierra todas las actividades y sale de la aplicación
        });

        btnRegistrarMascota.setOnClickListener(view -> {
            Toast.makeText(this, "Registrar una mascota", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuUsuarioActivity.this, RegistroMascotaActivity.class);
            startActivity(intent);
            finish();
        });

        btnMascotaPerdida.setOnClickListener(view -> {
            Toast.makeText(this, "Mascotas perdidas", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuUsuarioActivity.this, MascotaPerdidaActivity.class);
            startActivity(intent);
            finish();
        });

        btnMascotaEncontrada.setOnClickListener(view -> {
            Toast.makeText(this, "Mascotas encontradas", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuUsuarioActivity.this, MascotaEncontradaActivity.class);
            startActivity(intent);
            finish();
        });

        btnRefugios.setOnClickListener(view -> {
            Toast.makeText(this, "Refugios", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuUsuarioActivity.this, RefugiosActivity.class);
            startActivity(intent);
            finish();
        });

        btnPetshop.setOnClickListener(view -> {
            Toast.makeText(this, "PetShop", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuUsuarioActivity.this, PetShopActivity.class);
            startActivity(intent);
            finish();
        });

        btnPerfil.setOnClickListener(view -> {
            Toast.makeText(this, "Mi Perfíl", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MenuUsuarioActivity.this, PerfilUsuarioActivity.class);
            startActivity(intent);
            finish();
        });


    }
}
package com.example.petsit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class RegistroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Configurar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(v -> onBackPressedDispatcher.onBackPressed());

        // Configurar botones
        ImageButton btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);
        ImageButton btnRegistrarRefugio = findViewById(R.id.btnRegistrarRefugio);

        btnRegistrarUsuario.setOnClickListener(view -> {
            // Acción para registrar usuario
            Toast.makeText(RegistroActivity.this, "Registrar Usuario", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, RegistroUsuarioActivity.class);
            startActivity(intent);
        });

        btnRegistrarRefugio.setOnClickListener(view -> {
            // Acción para registrar refugio
            Toast.makeText(RegistroActivity.this, "Registrar Refugio", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, RegistroRefugioActivity.class);
            startActivity(intent);
        });

        // Configurar TextView de login
        TextView txtLogin = findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(view -> {
            // Acción para iniciar sesión
            Toast.makeText(RegistroActivity.this, "Iniciar Sesión", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}

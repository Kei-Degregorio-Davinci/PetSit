package com.example.petsit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Configurar botón de regreso
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Configurar botones
        ImageButton btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);
        ImageButton btnRegistrarRefugio = findViewById(R.id.btnRegistrarRefugio);

        btnRegistrarUsuario.setOnClickListener(v -> {
            Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, RegistroUsuarioActivity.class);
            startActivity(intent);
        });

        btnRegistrarRefugio.setOnClickListener(v -> {
            Toast.makeText(this, "Registrar Refugio", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, RegistroRefugioActivity.class);
            startActivity(intent);
        });

        // Configurar TextView de login
        TextView txtLogin = findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(v -> {
            Toast.makeText(this, "Iniciar Sesión", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}

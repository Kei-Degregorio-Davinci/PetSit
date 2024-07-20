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

        // Configure back button
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {

            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        });

        // Configure buttons
        ImageButton btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);
        ImageButton btnRegistrarRefugio = findViewById(R.id.btnRegistrarRefugio);

        btnRegistrarUsuario.setOnClickListener(v -> {
            // Action to register user
            Toast.makeText(this, "Register User", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, RegistroUsuarioActivity.class);
            startActivity(intent);
        });

        btnRegistrarRefugio.setOnClickListener(v -> {
            // Action to register shelter
            Toast.makeText(this, "Register Shelter", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, RegistroRefugioActivity.class);
            startActivity(intent);
        });

        // Configure login TextView
        TextView txtLogin = findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(v -> {
            // Action to log in
            Toast.makeText(this, "Log In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}

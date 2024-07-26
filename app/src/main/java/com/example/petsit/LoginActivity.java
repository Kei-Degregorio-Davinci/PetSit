package com.example.petsit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Vincular los elementos del layout
        EditText etEmailLogin = findViewById(R.id.etEmailLogin);
        EditText etContrasenaLogin = findViewById(R.id.etContrasenaLogin);
        Button btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        Button btnOlvideMiClave = findViewById(R.id.btnOlvideMiClave);
        ImageButton btnBack = findViewById(R.id.btnBack);

        // Configurar el botón de regreso
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(intent);
            finish();
        });

        // Configurar el botón de iniciar sesión
        btnIniciarSesion.setOnClickListener(view -> iniciarSesion(etEmailLogin, etContrasenaLogin));

        // Configurar el botón de olvidé mi clave
        btnOlvideMiClave.setOnClickListener(view -> {
            // Redirigir a la actividad de recuperación de contraseña
            Intent intent = new Intent(LoginActivity.this, RecuperarClaveActivity.class);
            startActivity(intent);
        });
    }

    private void iniciarSesion(EditText etEmailLogin, EditText etContrasenaLogin) {
        String email = etEmailLogin.getText().toString().trim();
        String contrasena = etContrasenaLogin.getText().toString().trim();

        if (email.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, contrasena)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Inicio de sesión exitoso
                        Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                        // Redirigir a la actividad principal
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Si el inicio de sesión falla, mostrar un mensaje al usuario
                        String message = task.getException() != null ? task.getException().getMessage() : "Error en el inicio de sesión";
                        Toast.makeText(this, "Error en el inicio de sesión: " + message, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}


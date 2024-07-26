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

public class RegistroUsuarioActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Vincular los elementos del layout
        EditText etNombre = findViewById(R.id.Nombre);
        EditText etTelefono = findViewById(R.id.Telefono);
        EditText etEmail = findViewById(R.id.Email);
        EditText etContrasena = findViewById(R.id.Contrasena);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        ImageButton btnBack = findViewById(R.id.btnBack);
        Button btnLogin = findViewById(R.id.btnLogin);

        // Configurar el botón de regreso
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(RegistroUsuarioActivity.this, RegistroActivity.class);
            startActivity(intent);
            finish();
        });

        // Configurar el botón de registrar
        btnRegistrar.setOnClickListener(view -> registrarUsuario(etNombre, etTelefono, etEmail, etContrasena));

        // Configurar el botón de login
        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(RegistroUsuarioActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void registrarUsuario(EditText etNombre, EditText etTelefono, EditText etEmail, EditText etContrasena) {
        String nombreStr = etNombre.getText().toString().trim();
        String telefonoStr = etTelefono.getText().toString().trim();
        String emailStr = etEmail.getText().toString().trim();
        String contrasenaStr = etContrasena.getText().toString().trim();

        if (nombreStr.isEmpty() || telefonoStr.isEmpty() || emailStr.isEmpty() || contrasenaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailStr, contrasenaStr)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Registro exitoso
                        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        // Redirigir a la actividad de inicio de sesión
                        Intent intent = new Intent(RegistroUsuarioActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Si el registro falla, mostrar un mensaje al usuario
                        String message = task.getException() != null ? task.getException().getMessage() : "Error en el registro";
                        Toast.makeText(this, "Error en el registro: " + message, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

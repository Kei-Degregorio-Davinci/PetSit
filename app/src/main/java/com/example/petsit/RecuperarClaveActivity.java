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

public class RecuperarClaveActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_clave);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Vincular los elementos del layout
        EditText etEmail = findViewById(R.id.Email);
        EditText etClavenueva = findViewById(R.id.Clavenueva);
        Button btnGuardar = findViewById(R.id.btnGuardar);
        ImageButton btnBack = findViewById(R.id.btnBack);

        // Configurar el botón de regreso
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(RecuperarClaveActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        // Configurar el botón de guardar
        btnGuardar.setOnClickListener(view -> {
            String emailStr = etEmail.getText().toString().trim();
            String clavenuevaStr = etClavenueva.getText().toString().trim();

            if (emailStr.isEmpty() || clavenuevaStr.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.sendPasswordResetEmail(emailStr)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Modificación exitosa", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RecuperarClaveActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            String errorMessage = (task.getException() != null) ? task.getException().getMessage() : "Error desconocido";
                            Toast.makeText(this, "No existe el mail: " + errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}

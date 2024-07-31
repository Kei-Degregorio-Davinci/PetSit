package com.example.petsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MisAnimalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_animales);

        // Botón de retroceso
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(MisAnimalesActivity.this, MenuRefugioActivity.class);
            startActivity(intent);
            finish();
        });

        Button btnNuevoAnimal = findViewById(R.id.btnNuevoAnimal);
        btnNuevoAnimal.setOnClickListener(v -> {
            Toast.makeText(this, "Registrar un nuevo animal", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MisAnimalesActivity.this, RegistrarAnimalActivity.class);
            startActivity(intent);
            finish();
        } );



    }
}
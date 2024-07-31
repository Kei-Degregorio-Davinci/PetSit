package com.example.petsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class PerfilUsuarioActivity extends AppCompatActivity {
    private EditText etEmail, etCelular, etNombre, etApellido, etClave;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        // Inicializar Firebase Auth
        FirebaseAuth auth = FirebaseAuth.getInstance();

        // Obtener referencia de la base de datos
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(Objects.requireNonNull(auth.getCurrentUser()).getUid());

        // Inicializar EditTexts y botón
        etEmail = findViewById(R.id.etEmail);
        etCelular = findViewById(R.id.etCelular);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etClave = findViewById(R.id.etClave);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        // Leer datos de Firebase y mostrar en los EditTexts
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Obtener datos de Firebase
                String email = dataSnapshot.child("email").getValue(String.class);
                String celular = dataSnapshot.child("celular").getValue(String.class);
                String nombre = dataSnapshot.child("nombre").getValue(String.class);
                String apellido = dataSnapshot.child("apellido").getValue(String.class);
                String clave = dataSnapshot.child("clave").getValue(String.class);

                // Mostrar datos en los EditTexts
                etEmail.setText(email);
                etCelular.setText(celular);
                etNombre.setText(nombre);
                etApellido.setText(apellido);
                etClave.setText(clave);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Manejar error
                Toast.makeText(PerfilUsuarioActivity.this, "Error al cargar datos", Toast.LENGTH_SHORT).show();
            }
        });

        btnGuardar.setOnClickListener(v -> {
            // Obtener los valores editados
            String newEmail = etEmail.getText().toString();
            String newCelular = etCelular.getText().toString();
            String newNombre = etNombre.getText().toString();
            String newApellido = etApellido.getText().toString();
            String newClave = etClave.getText().toString();

            // Guardar los datos editados en Firebase
            databaseReference.child("email").setValue(newEmail);
            databaseReference.child("celular").setValue(newCelular);
            databaseReference.child("nombre").setValue(newNombre);
            databaseReference.child("apellido").setValue(newApellido);
            databaseReference.child("clave").setValue(newClave);

            Toast.makeText(PerfilUsuarioActivity.this, "Datos guardados", Toast.LENGTH_SHORT).show();
        });

        // Botón de retroceso
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PerfilUsuarioActivity.this, MenuUsuarioActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
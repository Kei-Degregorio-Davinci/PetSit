package com.example.petsit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilRefugiosActivity extends AppCompatActivity {

    private EditText etNombreRefugio, etDireccion, etTelefono, etEmailRefugio, etClave, etHorarios;
    private DatabaseReference refugioRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_refugios);

        // Inicializar los elementos de la interfaz de usuario
        etNombreRefugio = findViewById(R.id.etNombreRefugio);
        etDireccion = findViewById(R.id.etDireccion);
        etTelefono = findViewById(R.id.etTelefono);
        etEmailRefugio = findViewById(R.id.etEmailRefugio);
        etClave = findViewById(R.id.etClave);
        etHorarios = findViewById(R.id.etHorarios);
        ImageButton btnBack = findViewById(R.id.btnBack);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        // Inicializar Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        refugioRef = database.getReference("refugios").child("id_del_refugio"); // Reemplazar "id_del_refugio" con el ID correcto

        // Cargar los datos del refugio desde Firebase
        cargarDatosRefugio();

        // Configurar el botón de regreso
        btnBack.setOnClickListener(view -> finish());

        // Configurar el botón de guardar
        btnGuardar.setOnClickListener(view -> guardarDatosRefugio());

        // Configurar botones de edición
        findViewById(R.id.btnEditNombreRefugio).setOnClickListener(view -> etNombreRefugio.setEnabled(true));
        findViewById(R.id.btnEditDireccion).setOnClickListener(view -> etDireccion.setEnabled(true));
        findViewById(R.id.btnEditarCelular).setOnClickListener(view -> etTelefono.setEnabled(true));
        findViewById(R.id.btnEditarEmail).setOnClickListener(view -> etEmailRefugio.setEnabled(true));
        findViewById(R.id.btnEditClave).setOnClickListener(view -> etClave.setEnabled(true));
        findViewById(R.id.btnEditarHorarios).setOnClickListener(view -> etHorarios.setEnabled(true));
    }

    private void cargarDatosRefugio() {
        refugioRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Obtener datos del snapshot
                    String nombre = snapshot.child("nombre").getValue(String.class);
                    String direccion = snapshot.child("direccion").getValue(String.class);
                    String telefono = snapshot.child("telefono").getValue(String.class);
                    String email = snapshot.child("email").getValue(String.class);
                    String clave = snapshot.child("clave").getValue(String.class);
                    String horarios = snapshot.child("horarios").getValue(String.class);

                    // Establecer los datos en los EditText
                    etNombreRefugio.setText(nombre);
                    etDireccion.setText(direccion);
                    etTelefono.setText(telefono);
                    etEmailRefugio.setText(email);
                    etClave.setText(clave);
                    etHorarios.setText(horarios);

                    // Deshabilitar los EditText
                    etNombreRefugio.setEnabled(false);
                    etDireccion.setEnabled(false);
                    etTelefono.setEnabled(false);
                    etEmailRefugio.setEnabled(false);
                    etClave.setEnabled(false);
                    etHorarios.setEnabled(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(PerfilRefugiosActivity.this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void guardarDatosRefugio() {
        String nombre = etNombreRefugio.getText().toString().trim();
        String direccion = etDireccion.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();
        String email = etEmailRefugio.getText().toString().trim();
        String clave = etClave.getText().toString().trim();
        String horarios = etHorarios.getText().toString().trim();

        refugioRef.child("nombre").setValue(nombre);
        refugioRef.child("direccion").setValue(direccion);
        refugioRef.child("telefono").setValue(telefono);
        refugioRef.child("email").setValue(email);
        refugioRef.child("clave").setValue(clave);
        refugioRef.child("horarios").setValue(horarios);

        Toast.makeText(this, "Datos guardados con éxito", Toast.LENGTH_SHORT).show();


        // Botón de retroceso
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(PerfilRefugiosActivity.this, MenuRefugioActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
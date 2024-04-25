package com.example.bodega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.EditText;
import com.google.android.material.button.MaterialButton;
import android.util.Log;

import com.example.bodega.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText correo_electronico_input;
    private EditText contrasena_input;
    private MaterialButton loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correo_electronico_input = findViewById(R.id.correo_input);
        contrasena_input =  findViewById(R.id.contrasena_input);
        loginBtn = findViewById(R.id.boton_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acciones a realizar cuando se haga clic en el botón
                String correo_electronico = correo_electronico_input.getText().toString();
                String contrasena = contrasena_input.getText().toString();
                Intent intent = new Intent(Login.this, HomePage.class);
                Log.i("Login", "Correo electrónico: " + correo_electronico + ", Contraseña: " + contrasena);


                startActivity(intent);

            }

            // Poner una validacion para el log in
        });


    }
}
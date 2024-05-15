package com.example.bodega.frontend.detalles.producto;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bodega.R;
import com.example.bodega.backend.clases.Producto;
import com.example.bodega.backend.clases.persona;
import com.example.bodega.backend.metodos.MyApplication;

public class detallesProducto extends AppCompatActivity {

    private Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallesproducto);
        MyApplication myApp = (MyApplication) getApplicationContext();
        Intent intent = getIntent();
        if(intent != null) {
            int id = intent.getIntExtra("id", -1);

            producto = myApp.getInventario().getProductoById(id);

            if (producto != null) {
                EditText editTextNombre = findViewById(R.id.editTextNombre);
                EditText editTextPrecio = findViewById(R.id.editTextPrecio);
                EditText editTextCantidad = findViewById(R.id.editTextCantidad);

                editTextNombre.setText(producto.getNombre());
                editTextPrecio.setText(String.valueOf(producto.getPrecio()));
                editTextCantidad.setText(String.valueOf(producto.getCantidad()));
            }
        }

        Button buttonGuardar = findViewById(R.id.buttonGuardar);
        Button buttonEliminar =findViewById(R.id.buttonEliminar);
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarCambios();
            }
        });
        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarProducto();
            }
        });
    }

    private void eliminarProducto() {
        MyApplication myApp = (MyApplication) getApplicationContext();
        myApp.getInventario().removeProducto(producto);

        finish();
    }

    private void guardarCambios() {
        // Obtener los nuevos valores de los EditText y actualizar el objeto Producto
        EditText editTextNombre = findViewById(R.id.editTextNombre);
        EditText editTextPrecio = findViewById(R.id.editTextPrecio);
        EditText editTextCantidad = findViewById(R.id.editTextCantidad);

        String nombre = editTextNombre.getText().toString();
        double precio = Double.parseDouble(editTextPrecio.getText().toString());
        int cantidad = Integer.parseInt(editTextCantidad.getText().toString());

// Actualizar los valores del objeto Producto
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);

        finish();
    }

}


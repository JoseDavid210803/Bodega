package com.example.bodega.frontend.app.drawer_menu.anadir_producto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.bodega.R;
import com.example.bodega.backend.clases.Producto;
import com.example.bodega.backend.metodos.MyApplication;
import com.example.bodega.databinding.FragmentAnadirProductoBinding;
import com.google.android.material.snackbar.Snackbar;

public class AnadirProductoFragment extends Fragment {

    private FragmentAnadirProductoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAnadirProductoBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        Button botonAnadirProducto = rootView.findViewById(R.id.boton_anadir_producto);

        botonAnadirProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nombreEditText = rootView.findViewById(R.id.input_nombre_producto);
                EditText precioEditText = rootView.findViewById(R.id.input_precio_producto);
                EditText idEditText = rootView.findViewById(R.id.input_id);
                EditText cantidadEditText = rootView.findViewById(R.id.input_cant_inicial_producto);

                String nombre = nombreEditText.getText().toString();
                double precio = Double.parseDouble(precioEditText.getText().toString());
                int id = Integer.parseInt(idEditText.getText().toString());
                int cantidad =Integer.parseInt(cantidadEditText.getText().toString());
                MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
                if (myApp.getInventario().idDisponible(id))
                {
                    myApp.getInventario().addProducto(new Producto(id, cantidad, precio, nombre));

                    nombreEditText.setText("");
                    precioEditText.setText("");
                    idEditText.setText("");
                    cantidadEditText.setText("");
                    Snackbar.make(view, "Producto añadido con exito", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.icono_flotante).show();
                }
                else{
                    Snackbar.make(view, "Id no disponible", Snackbar.LENGTH_LONG)
                            .setAnchorView(R.id.icono_flotante).show();
                }

                // También puedes iniciar una nueva actividad si es necesario
                // Intent intent = new Intent(getActivity(), NuevaActividad.class);
                // startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

package com.example.bodega.frontend.app.drawer_menu.registrar_proveedor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.R;
import com.example.bodega.backend.clases.persona;
import com.example.bodega.backend.metodos.MyApplication;
import com.example.bodega.databinding.FragmentRegistrarClienteBinding;
import com.example.bodega.databinding.FragmentRegistrarProveedorBinding;

public class RegistrarProveedorFragment extends Fragment {

    private FragmentRegistrarProveedorBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegistrarProveedorBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();
        //obtencion de los widgets de la pantalla
        Button botonAnadirProducto = rootView.findViewById(R.id.buttonRegistrar);
        MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
        EditText nombreEditText = rootView.findViewById(R.id.editTextNombre);
        EditText correoEditText = rootView.findViewById(R.id.editTextCorreo);
        EditText telefonoEditText = rootView.findViewById(R.id.editTextTelefono);
        //sugiere el id del producto a añadir
        botonAnadirProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //comprobacion de que todos los datos son correctos y no haya datos vacios
                if (nombreEditText.getText().toString().isEmpty() || correoEditText.getText().toString().isEmpty() || telefonoEditText.getText().toString().isEmpty())
                {
                    return;
                }
                String nombre = nombreEditText.getText().toString();
                String correo = correoEditText.getText().toString();
                String telefono = telefonoEditText.getText().toString();

                myApp.getProveedores().add(new persona(nombre, telefono, correo));
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

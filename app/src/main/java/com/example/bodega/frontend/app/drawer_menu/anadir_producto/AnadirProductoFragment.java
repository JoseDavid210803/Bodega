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
import com.example.bodega.backend.clases.ticket;
import com.example.bodega.backend.metodos.MyApplication;
import com.example.bodega.databinding.FragmentAnadirProductoBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public class AnadirProductoFragment extends Fragment {

    private FragmentAnadirProductoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAnadirProductoBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();
        //obtencion de los widgets de la pantalla
        Button botonAnadirProducto = rootView.findViewById(R.id.boton_anadir_producto);
        MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
        EditText nombreEditText = rootView.findViewById(R.id.input_nombre_producto);
        EditText precioEditText = rootView.findViewById(R.id.input_precio_producto);
        EditText idEditText = rootView.findViewById(R.id.input_id);
        EditText cantidadEditText = rootView.findViewById(R.id.input_cant_inicial_producto);
        //sugiere el id del producto a añadir
        idEditText.setText(myApp.getInventario().getProductos().size()+1+"");
        botonAnadirProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //comprobacion de que todos los datos son correctos y no haya datos vacios
                if (nombreEditText.getText().toString().isEmpty() || precioEditText.getText().toString().isEmpty()||
                        precioEditText.getText().toString().equals("0")||cantidadEditText.getText().toString().equals("0") ||
                        idEditText.getText().toString().isEmpty() || cantidadEditText.getText().toString().isEmpty())
                {
                    return;
                }
                String nombre = nombreEditText.getText().toString();
                double precio = Double.parseDouble(precioEditText.getText().toString());
                int id = Integer.parseInt(idEditText.getText().toString());
                int cantidad =Integer.parseInt(cantidadEditText.getText().toString());
                if (myApp.getInventario().idDisponible(id))
                {
                    Producto p = new Producto(id, cantidad, precio, nombre);
                    ticket t =new ticket(new Date());
                    t.addProducto(p, cantidad, myApp.getInventario());//agrega el producto al inventario

                    nombreEditText.setText("");
                    precioEditText.setText("");
                    idEditText.setText(myApp.getInventario().getProductos().size()+1+"");
                    cantidadEditText.setText("");



                    myApp.getTicketsEntrada().agregarTicket(t);
                    Snackbar.make(view, "Producto añadido con exito", Snackbar.LENGTH_LONG)
                            .setAnchorView(R.id.boton_anadir_producto).show();


                }
                else{
                    Snackbar.make(view, "Id no disponible", Snackbar.LENGTH_LONG)
                            .setAnchorView(R.id.boton_anadir_producto).show();
                }
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

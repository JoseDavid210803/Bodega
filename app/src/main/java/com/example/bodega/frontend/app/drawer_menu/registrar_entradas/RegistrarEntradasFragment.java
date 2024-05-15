package com.example.bodega.frontend.app.drawer_menu.registrar_entradas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodega.R;
import com.example.bodega.backend.clases.Producto;
import com.example.bodega.backend.clases.pair;
import com.example.bodega.backend.clases.persona;
import com.example.bodega.backend.clases.stock;
import com.example.bodega.backend.clases.ticket;
import com.example.bodega.backend.metodos.MyApplication;
import com.example.bodega.databinding.FragmentRegistrarEntradasBinding;
import com.google.android.material.button.MaterialButton;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrarEntradasFragment extends Fragment {

    private View rootView ;
    private List<pair<Producto, Integer>> productos_anadir = new ArrayList<>();
    MaterialButton boton_registrarEntrada;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FragmentRegistrarEntradasBinding binding = FragmentRegistrarEntradasBinding.inflate(inflater, container, false);
        boton_registrarEntrada = (MaterialButton) binding.buttonRegistrarEntrada;
        rootView = binding.getRoot();
        MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
        View root = binding.getRoot();

        List<String> elements = new ArrayList<>();
        List<String> elements2 = new ArrayList<>();
        final persona[] proveedor = {null};

        elements2.add("");
        for (int i = 0; i < myApp.getInventario().getProductos().size(); i++) {
            elements2.add(myApp.getInventario().getProductos().get(i).getNombre());
        }
        elements.add("");
        for (int i = 0; i < myApp.getProveedores().size(); i++) {
            elements.add(myApp.getProveedores().get(i).getNombre());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, elements);
        Spinner spinner = root.findViewById(R.id.spinnerProveedores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, elements2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner_productos = root.findViewById(R.id.spinnerProductosEntradas);
        spinner_productos.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    return;
                }
                proveedor[0] = myApp.getProveedores().get(position -1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        spinner_productos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public boolean contieneValorObjetivo(Producto producto)
            {
                boolean contieneValorObjetivo = false;
                for (pair<Producto, Integer> par : productos_anadir)
                {
                    if (par.getFirst().equals(producto))
                    {
                        contieneValorObjetivo = true;
                        return true;
                    }
                }
                return false;
            }
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Producto selectedProducto = null;
                if (position > 0) {
                    selectedProducto =  myApp.getInventario().getProductos().get(position - 1);

                    if (!contieneValorObjetivo(selectedProducto)) {
                        productos_anadir.add(new pair<>(selectedProducto, 0));
                        openNumberInputDialog(requireContext());;
                        init(productos_anadir);
                        Toast.makeText(requireContext(), "Producto añadido", Toast.LENGTH_SHORT).show();

                    }
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }

        });
        boton_registrarEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticket ticket = new ticket(new Date());
                ticket.setPersona(proveedor[0]);
                MyApplication MyApp = (MyApplication) requireContext().getApplicationContext();
                stock s = MyApp.getInventario();
                for (pair <Producto, Integer> p : productos_anadir) {
                    ticket.addProducto(p.getFirst(), p.getSecond(), s);;
                }
                MyApp.getTicketsEntrada().agregarTicket(ticket);
                Toast.makeText(requireContext(), "Entrada registrada", Toast.LENGTH_SHORT).show();
                productos_anadir.clear();
                init(productos_anadir);
                }
        });
        return root;
    }
    private int openNumberInputDialog(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_input_number, null);
        EditText editTextNumber = view.findViewById(R.id.editTextNumber);
        final int[] cantidad_ingresar = new int[1];

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view)
                .setTitle("Ingrese un número")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Obtener el número ingresado por el usuario
                        String input = editTextNumber.getText().toString();
                        productos_anadir.get(productos_anadir.size() - 1).setSecond(Integer.parseInt(input));
                        init(productos_anadir);
                        Toast.makeText(context, "Número ingresado: " + input, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        productos_anadir.remove(productos_anadir.size() - 1);
                        init(productos_anadir);
                    }

                })
                .create()
                .show();
            return cantidad_ingresar[0];
                }
    public void init(List<pair<Producto, Integer>> productos_anadir) {
        Context context = requireContext();
        ListAdapterRegistrarEntradas listAdapter = new ListAdapterRegistrarEntradas(productos_anadir, context);
        RecyclerView recyclerView = rootView.findViewById(R.id.Entrada_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(listAdapter);

        listAdapter.setItems(productos_anadir);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rootView = null;

    }
}

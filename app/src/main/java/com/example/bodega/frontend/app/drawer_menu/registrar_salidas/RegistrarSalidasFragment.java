package com.example.bodega.frontend.app.drawer_menu.registrar_salidas;

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

import com.example.bodega.databinding.FragmentRegistrarSalidasBinding;
import com.example.bodega.frontend.app.drawer_menu.registrar_entradas.ListAdapterRegistrarEntradas;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrarSalidasFragment extends Fragment {

    private View rootView ;
    private List<pair<Producto, Integer>> productos_retirar = new ArrayList<>();
    MaterialButton boton_registrarSalida;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FragmentRegistrarSalidasBinding binding = FragmentRegistrarSalidasBinding.inflate(inflater, container, false);
        boton_registrarSalida = (MaterialButton) binding.buttonRegistrarSalida;
        rootView = binding.getRoot();
        MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
        View root = binding.getRoot();

        List<String> elements = new ArrayList<>();
        List<String> elements2 = new ArrayList<>();
        final persona[] cliente = {null};

        elements2.add("");
        for (int i = 0; i < myApp.getInventario().getProductos().size(); i++) {
            elements2.add(myApp.getInventario().getProductos().get(i).getNombre());
        }
        elements.add("");
        for (int i = 0; i < myApp.getClientes().size(); i++) {
            elements.add(myApp.getClientes().get(i).getNombre());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, elements);
        Spinner spinner = root.findViewById(R.id.spinnerClientes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_item, elements2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner_productos = root.findViewById(R.id.spinnerProductoSalida);
        spinner_productos.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    return;
                }
                cliente[0] = myApp.getClientes().get(position -1);
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
                for (pair<Producto, Integer> par : productos_retirar)
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
                        productos_retirar.add(new pair<>(selectedProducto, 0));
                        openNumberInputDialog(requireContext());;
                        init(productos_retirar);
                        Toast.makeText(requireContext(), "Producto añadido", Toast.LENGTH_SHORT).show();

                    }
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }

        });
        boton_registrarSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticket ticket = new ticket(new Date());
                ticket.setPersona(cliente[0]);
                MyApplication MyApp = (MyApplication) requireContext().getApplicationContext();
                stock s = MyApp.getInventario();
                for (pair <Producto, Integer> p : productos_retirar) {
                    ticket.disminuirStockProducto(p.getFirst(), p.getSecond(), s);;
                }
                MyApp.getTicketsSalida().agregarTicket(ticket);
                Toast.makeText(requireContext(), "Salida registrada", Toast.LENGTH_SHORT).show();
                productos_retirar.clear();
                init(productos_retirar);
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
                        String input = editTextNumber.getText().toString();
                        if (productos_retirar.get(productos_retirar.size() - 1).getFirst().getCantidad()<Integer.parseInt(input))
                        {
                            Toast.makeText(context, "Cantidad insuficiente para retirar", Toast.LENGTH_SHORT).show();
                            productos_retirar.remove(productos_retirar.size() - 1);
                            return;
                        }
                        productos_retirar.get(productos_retirar.size() - 1).setSecond(Integer.parseInt(input));
                        init(productos_retirar);
                        Toast.makeText(context, "Número ingresado: " + input, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        productos_retirar.remove(productos_retirar.size() - 1);
                        init(productos_retirar);
                    }

                })
                .create()
                .show();
        return cantidad_ingresar[0];
    }
    public void init(List<pair<Producto, Integer>> productos_retirar) {
        Context context = requireContext();
        ListAdapterRegistrarEntradas listAdapter = new ListAdapterRegistrarEntradas(productos_retirar, context);
        RecyclerView recyclerView = rootView.findViewById(R.id.Salida_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(listAdapter);

        listAdapter.setItems(productos_retirar);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rootView = null;

    }
}

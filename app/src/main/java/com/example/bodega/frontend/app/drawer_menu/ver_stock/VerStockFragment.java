package com.example.bodega.frontend.app.drawer_menu.ver_stock;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodega.R;
import com.example.bodega.backend.clases.producto;
import com.example.bodega.backend.clases.stock;
import com.example.bodega.backend.metodos.MyApplication;
import com.example.bodega.databinding.FragmentVerStockBinding;
import com.example.bodega.frontend.metodos.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class VerStockFragment extends Fragment {
    private List<producto> elements;
    private FragmentVerStockBinding binding;
    private View rootView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVerStockBinding.inflate(inflater, container, false);
        rootView = binding.getRoot();

        init();

        return rootView;
    }

    public void init() {
        elements = new ArrayList<>();

        // Obtener el inventario desde MyApplication
        MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
        stock inventario = myApp.getInventario();

        // Agregar productos al elemento
        for (int i = 0; i < inventario.getCantidad(); i++) {
            elements.add(inventario.getProductos().get(i));
        }
        for (int i = 0; i < inventario.getCantidad(); i++) {
            elements.add(inventario.getProductos().get(i));
        }

        // Configurar RecyclerView
        Context context = requireContext();
        ListAdapter listAdapter = new ListAdapter(elements, context);
        RecyclerView recyclerView = rootView.findViewById(R.id.stock_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(listAdapter);
    }
}

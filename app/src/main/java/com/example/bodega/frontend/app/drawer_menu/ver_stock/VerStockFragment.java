package com.example.bodega.frontend.app.drawer_menu.ver_stock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodega.R;
import com.example.bodega.backend.clases.Producto;

import com.example.bodega.backend.metodos.MyApplication;
import com.example.bodega.databinding.FragmentVerStockBinding;
import com.example.bodega.frontend.detalles.producto.detallesProducto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VerStockFragment extends Fragment implements stockElementInterface{

    private List<Producto> elements=new ArrayList<>();;
    private View rootView;
    //private SearchView busqueda;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        com.example.bodega.databinding.FragmentVerStockBinding binding = FragmentVerStockBinding.inflate(inflater, container, false);
        rootView = binding.getRoot();
        MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
        elements = myApp.getInventario().getProductos();

        init(this);
        return rootView;
    }

    public void init(stockElementInterface listener) {


        Thread thread = new Thread() {
            @Override
            public void run() {
                Context context = requireContext();
                ListAdapter listAdapter = new ListAdapter(elements, context, listener);
                RecyclerView recyclerView = rootView.findViewById(R.id.stock_recyclerview);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(listAdapter);
                listAdapter.setItems(elements);
            }
        };
        thread.start();


    }

    void realizar_busqueda(String cadena_buscar)
    {
        List<Producto> sublista= new ArrayList<>();
        for (int i=0; i<elements.size(); i++) {
            //if(elements(i).get contains(cadena_buscar)){


        }
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(), "Item " + position + " clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), detallesProducto.class);
        int id = elements.get(position).getId();
        intent.putExtra("id",  id);
        startActivity(intent);
    }
}


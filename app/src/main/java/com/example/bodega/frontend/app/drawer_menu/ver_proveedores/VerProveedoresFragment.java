package com.example.bodega.frontend.app.drawer_menu.ver_proveedores;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodega.R;
import com.example.bodega.backend.clases.Producto;

import com.example.bodega.backend.clases.persona;
import com.example.bodega.backend.metodos.MyApplication;
import com.example.bodega.databinding.FragmentVerProveedoresBinding;
import com.example.bodega.frontend.app.drawer_menu.ver_proveedores.ListAdapterProveedores;


import java.util.ArrayList;
import java.util.List;

public class VerProveedoresFragment extends Fragment implements SearchView.OnQueryTextListener{

    private List<persona> elements=new ArrayList<>();;
    private View rootView;
    //private SearchView busqueda;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        com.example.bodega.databinding.FragmentVerProveedoresBinding binding = FragmentVerProveedoresBinding.inflate(inflater, container, false);
        rootView = binding.getRoot();
        MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
        elements = myApp.getProveedores();

        //busqueda = rootView.findViewById(R.id.search_view);

        /*
        busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                realizar_busqueda(query);

                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                realizar_busqueda(newText);
                return true;
            }
        });*/
        init();
        return rootView;
    }

    public void init() {

        Context context = requireContext();
        ListAdapterProveedores listAdapter = new ListAdapterProveedores(elements, context);
        RecyclerView recyclerView = rootView.findViewById(R.id.proveedores_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(listAdapter);

        listAdapter.setItems(elements);

    }

    void realizar_busqueda(String cadena_buscar)
    {
        List<Producto> sublista= new ArrayList<>();
        for (int i=0; i<elements.size(); i++) {
            //if(elements(i).get contains(cadena_buscar)){


        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}

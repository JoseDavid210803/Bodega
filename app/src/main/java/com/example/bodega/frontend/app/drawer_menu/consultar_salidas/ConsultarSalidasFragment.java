package com.example.bodega.frontend.app.drawer_menu.consultar_salidas;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bodega.R;
import com.example.bodega.backend.clases.ticket;
import com.example.bodega.backend.metodos.MyApplication;
import com.example.bodega.databinding.FragmentConsultarSalidasBinding;
import com.example.bodega.frontend.app.drawer_menu.consultar_salidas.ListAdapter_salidas;

import java.util.ArrayList;
import java.util.List;

public class ConsultarSalidasFragment extends Fragment {


    private List<ticket> elements = new ArrayList<>();
    ;
    private View rootView;
    //private SearchView busqueda;
    //com.example.bodega.databinding.FragmentConsultarEntradasBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        FragmentConsultarSalidasBinding binding = FragmentConsultarSalidasBinding.inflate(inflater, container, false);
        rootView = binding.getRoot();
        MyApplication myApp = (MyApplication) requireContext().getApplicationContext();
        elements = myApp.getTicketsSalida().getListaTickets();
        init();
        return rootView;
    }

    public void init() {

        Context context = requireContext();
        ListAdapter_salidas listAdapter = new ListAdapter_salidas(elements, context);
        RecyclerView recyclerView = rootView.findViewById(R.id.salidas_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(listAdapter);

        listAdapter.setItems(elements);

    }
}
    /*

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}*/
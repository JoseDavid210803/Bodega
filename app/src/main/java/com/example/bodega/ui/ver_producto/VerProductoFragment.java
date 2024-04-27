package com.example.bodega.ui.ver_producto;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVerClientesBinding;
import com.example.bodega.databinding.FragmentVerProductoBinding;
import com.example.bodega.ui.ver_clientes.VerClientesViewModel;
import com.example.bodega.ui.ver_producto.VerProductoViewModel;

public class VerProductoFragment extends Fragment {

    private FragmentVerProductoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.example.bodega.ui.ver_producto.VerProductoViewModel VerProductoViewModel =
                new ViewModelProvider(this).get(com.example.bodega.ui.ver_producto.VerProductoViewModel.class);

        binding = FragmentVerProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVerproductos;
        VerProductoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
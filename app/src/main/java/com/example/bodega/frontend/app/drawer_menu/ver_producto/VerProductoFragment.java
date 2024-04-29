package com.example.bodega.frontend.app.drawer_menu.ver_producto;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVerProductoBinding;

public class VerProductoFragment extends Fragment {

    private FragmentVerProductoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VerProductoViewModel VerProductoViewModel =
                new ViewModelProvider(this).get(com.example.bodega.frontend.app.drawer_menu.ver_producto.VerProductoViewModel.class);

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
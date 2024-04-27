package com.example.bodega.ui.ver_proveedores;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVerProveedoresBinding;
import com.example.bodega.ui.ver_proveedores.VerProveedoresViewModel;

public class VerProveedoresFragment extends Fragment {

    private FragmentVerProveedoresBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.example.bodega.ui.ver_proveedores.VerProveedoresViewModel VerProveedoresViewModel =
                new ViewModelProvider(this).get(com.example.bodega.ui.ver_proveedores.VerProveedoresViewModel.class);

        binding = FragmentVerProveedoresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVerProveedores;
        VerProveedoresViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
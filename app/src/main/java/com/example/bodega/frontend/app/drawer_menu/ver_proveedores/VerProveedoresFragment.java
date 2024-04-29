package com.example.bodega.frontend.app.drawer_menu.ver_proveedores;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVerProveedoresBinding;

public class VerProveedoresFragment extends Fragment {

    private FragmentVerProveedoresBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VerProveedoresViewModel VerProveedoresViewModel =
                new ViewModelProvider(this).get(com.example.bodega.frontend.app.drawer_menu.ver_proveedores.VerProveedoresViewModel.class);

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
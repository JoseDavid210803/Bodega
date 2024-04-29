package com.example.bodega.frontend.app.drawer_menu.ver_clientes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVerClientesBinding;

public class VerClientesFragment extends Fragment {

    private FragmentVerClientesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VerClientesViewModel VerClientesViewModel =
                new ViewModelProvider(this).get(com.example.bodega.frontend.app.drawer_menu.ver_clientes.VerClientesViewModel.class);

        binding = FragmentVerClientesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVerClientes;
        VerClientesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
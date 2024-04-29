package com.example.bodega.frontend.app.drawer_menu.registrar_salidas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentRegistrarSalidasBinding;

public class RegistrarSalidasFragment extends Fragment {

    private FragmentRegistrarSalidasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RegistrarSalidasViewModel RegistrarSalidasViewModel =
                new ViewModelProvider(this).get(com.example.bodega.frontend.app.drawer_menu.registrar_salidas.RegistrarSalidasViewModel.class);

        binding = FragmentRegistrarSalidasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRegistrarSalidas;
        RegistrarSalidasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
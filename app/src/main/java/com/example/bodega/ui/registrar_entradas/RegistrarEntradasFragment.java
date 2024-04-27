package com.example.bodega.ui.registrar_entradas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentRegistrarEntradasBinding;

public class RegistrarEntradasFragment extends Fragment {

    private FragmentRegistrarEntradasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RegistrarEntradasViewModel RegistrarEntradasViewModel =
                new ViewModelProvider(this).get(RegistrarEntradasViewModel.class);

        binding = FragmentRegistrarEntradasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRegistrarEntradas;
        RegistrarEntradasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
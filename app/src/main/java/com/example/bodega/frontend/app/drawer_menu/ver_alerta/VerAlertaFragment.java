package com.example.bodega.frontend.app.drawer_menu.ver_alerta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVisualizarAlertasBinding;

public class VerAlertaFragment extends Fragment {

    private FragmentVisualizarAlertasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VerAlertaViewModel VerAlertaViewModel =
                new ViewModelProvider(this).get(com.example.bodega.frontend.app.drawer_menu.ver_alerta.VerAlertaViewModel.class);

        binding = FragmentVisualizarAlertasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVerAlerta;
        VerAlertaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
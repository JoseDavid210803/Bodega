package com.example.bodega.ui.establecer_alerta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentEstablecerAlertaBinding;
import com.example.bodega.ui.establecer_alerta.EstablecerAlertaFragment;

public class EstablecerAlertaFragment extends Fragment {

    private FragmentEstablecerAlertaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EstablecerAlertaViewModel homeViewModel =
                new ViewModelProvider(this).get(EstablecerAlertaViewModel.class);

        binding = FragmentEstablecerAlertaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEstablecerAlerta;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
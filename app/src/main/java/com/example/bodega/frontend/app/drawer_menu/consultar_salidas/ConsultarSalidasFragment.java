package com.example.bodega.frontend.app.drawer_menu.consultar_salidas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentConsultarSalidasBinding;

public class ConsultarSalidasFragment extends Fragment {

    private FragmentConsultarSalidasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ConsultarSalidasViewModel homeViewModel =
                new ViewModelProvider(this).get(ConsultarSalidasViewModel.class);

        binding = FragmentConsultarSalidasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textConsultarSalidas;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
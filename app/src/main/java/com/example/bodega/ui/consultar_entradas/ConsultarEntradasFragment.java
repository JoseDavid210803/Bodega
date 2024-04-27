package com.example.bodega.ui.consultar_entradas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentConsultarEntradasBinding;

public class ConsultarEntradasFragment extends Fragment {

    private FragmentConsultarEntradasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ConsultarEntradasViewModel consultarEntradasViewModel =
                new ViewModelProvider(this).get(ConsultarEntradasViewModel.class);

        binding = FragmentConsultarEntradasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textConsultarentradas;
        consultarEntradasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
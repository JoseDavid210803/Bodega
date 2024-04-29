package com.example.bodega.frontend.app.drawer_menu.ver_informes;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVerInformesBinding;

public class VerInformesFragment extends Fragment {

    private FragmentVerInformesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VerInformesViewModel VerInformesViewModel =
                new ViewModelProvider(this).get(com.example.bodega.frontend.app.drawer_menu.ver_informes.VerInformesViewModel.class);

        binding = FragmentVerInformesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVerInformes;
        VerInformesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
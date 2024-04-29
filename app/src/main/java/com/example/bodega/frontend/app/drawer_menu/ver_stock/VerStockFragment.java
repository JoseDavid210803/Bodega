package com.example.bodega.frontend.app.drawer_menu.ver_stock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVerStockBinding;

public class VerStockFragment extends Fragment {

    private FragmentVerStockBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VerStockViewModel VerStockViewModel =
                new ViewModelProvider(this).get(com.example.bodega.frontend.app.drawer_menu.ver_stock.VerStockViewModel.class);

        binding = FragmentVerStockBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textVerstock;
        //VerStockViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
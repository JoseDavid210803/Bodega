package com.example.bodega.ui.ver_stock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentVerStockBinding;
import com.example.bodega.ui.ver_stock.VerStockViewModel;

public class VerStockFragment extends Fragment {

    private FragmentVerStockBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.example.bodega.ui.ver_stock.VerStockViewModel VerStockViewModel =
                new ViewModelProvider(this).get(com.example.bodega.ui.ver_stock.VerStockViewModel.class);

        binding = FragmentVerStockBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textVerstock;
        VerStockViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
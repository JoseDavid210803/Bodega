package com.example.bodega.ui.main_page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bodega.databinding.FragmentMainPageBinding;

public class MainPageFragment extends Fragment {

    private FragmentMainPageBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MainPageViewModel homeViewModel =
                new ViewModelProvider(this).get(MainPageViewModel.class);

        binding = FragmentMainPageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMainpage;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
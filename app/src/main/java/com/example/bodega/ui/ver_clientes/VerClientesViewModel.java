package com.example.bodega.ui.ver_clientes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerClientesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public VerClientesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ver clientes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

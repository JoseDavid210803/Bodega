package com.example.bodega.frontend.app.drawer_menu.registrar_cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistrarClienteViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RegistrarClienteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("establecer cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.bodega.frontend.app.drawer_menu.consultar_entradas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConsultarEntradasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConsultarEntradasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Consultar entradas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
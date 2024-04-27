package com.example.bodega.ui.registrar_entradas;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistrarEntradasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RegistrarEntradasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Registrar entradas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

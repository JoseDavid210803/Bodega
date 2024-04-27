package com.example.bodega.ui.registrar_salidas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistrarSalidasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RegistrarSalidasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Registrar salidas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

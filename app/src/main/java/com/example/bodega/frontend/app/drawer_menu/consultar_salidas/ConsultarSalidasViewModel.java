package com.example.bodega.frontend.app.drawer_menu.consultar_salidas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConsultarSalidasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConsultarSalidasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("consultar salidas ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.example.bodega.frontend.app.drawer_menu.establecer_alerta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EstablecerAlertaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EstablecerAlertaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("establecer alerta ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
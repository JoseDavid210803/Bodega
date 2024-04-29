package com.example.bodega.frontend.app.drawer_menu.ver_alerta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerAlertaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public VerAlertaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ver Alerta");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

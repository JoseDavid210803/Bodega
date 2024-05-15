package com.example.bodega.frontend.app.drawer_menu.registrar_proveedor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistrarProveedorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RegistrarProveedorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Registrar proovedor");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

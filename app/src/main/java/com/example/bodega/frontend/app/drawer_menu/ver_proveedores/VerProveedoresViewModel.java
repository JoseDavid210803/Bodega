package com.example.bodega.frontend.app.drawer_menu.ver_proveedores;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerProveedoresViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public VerProveedoresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ver proveedores");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

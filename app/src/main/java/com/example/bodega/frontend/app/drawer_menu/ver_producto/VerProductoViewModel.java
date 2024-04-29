package com.example.bodega.frontend.app.drawer_menu.ver_producto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerProductoViewModel extends ViewModel  {

    private final MutableLiveData<String> mText;

    public VerProductoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ver producto");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

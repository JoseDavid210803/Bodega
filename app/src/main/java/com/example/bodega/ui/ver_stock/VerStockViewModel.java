package com.example.bodega.ui.ver_stock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerStockViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public VerStockViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ver stock");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

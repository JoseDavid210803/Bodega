package com.example.bodega.ui.ver_informes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VerInformesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public VerInformesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ver Informes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

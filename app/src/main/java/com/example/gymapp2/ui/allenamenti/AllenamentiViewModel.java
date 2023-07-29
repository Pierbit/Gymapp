package com.example.gymapp2.ui.allenamenti;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllenamentiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AllenamentiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Mammata");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
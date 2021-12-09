package com.ramiro.ernesto.trymdc;

import android.content.ClipData;
import android.view.MenuItem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModelOld extends ViewModel {
    private final MutableLiveData<ClipData.Item> selectedItem = new MutableLiveData<ClipData.Item>();
    public void selectItem(ClipData.Item item) {
        selectedItem.setValue(item);
    }
    public LiveData<ClipData.Item> getSelectedItem() {
        return selectedItem;
    }

    public void select(MenuItem item) {
    }
}

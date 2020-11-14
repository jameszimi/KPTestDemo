package stw.jamez.kptestdemo.views.photodetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import stw.jamez.kptestdemo.model.PhotoResponseItem

class PhotoDetailViewModel :ViewModel() {
    val photoData = MutableLiveData<PhotoResponseItem>()
}
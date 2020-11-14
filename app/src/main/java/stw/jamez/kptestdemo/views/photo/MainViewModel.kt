package stw.jamez.kptestdemo.views.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import stw.jamez.kptestdemo.api.PhotoService
import stw.jamez.kptestdemo.model.PhotoResponse
import stw.jamez.kptestdemo.model.PhotoResponseItem

class MainViewModel : ViewModel() {
    val photoList = MutableLiveData<ArrayList<PhotoResponseItem>>()

    fun getPhotoList() {
        PhotoService.create().getPhoto().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<PhotoResponse> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: PhotoResponse) {
                photoList.value = t
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {
            }

        })
    }

}
package stw.jamez.kptestdemo


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Observable
import io.reactivex.Observer
import junit.framework.Assert.assertNotNull
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import stw.jamez.kptestdemo.api.PhotoService
import stw.jamez.kptestdemo.model.PhotoResponse
import stw.jamez.kptestdemo.model.PhotoResponseItem
import stw.jamez.kptestdemo.views.photo.MainViewModel
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class PhotoServiceTest {

    @JvmField
    @Rule
    var role = InstantTaskExecutorRule()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Mock
    private lateinit var observer: androidx.lifecycle.Observer<PhotoResponse>

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun createService() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun test_getPhotoNotNull() {
        mainViewModel.photoList.observeForever(observer)
        mainViewModel.getPhotoList()
        assertNotNull(mainViewModel.photoList.value)

    }

    @Test
    fun test_getPhotoIsNotEmpty() {
        mainViewModel.photoList.observeForever(observer)
        mainViewModel.getPhotoList()
        assert(mainViewModel.photoList.value!!.isNotEmpty())
    }

}
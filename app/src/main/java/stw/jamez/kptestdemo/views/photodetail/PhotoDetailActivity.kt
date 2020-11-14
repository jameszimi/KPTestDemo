package stw.jamez.kptestdemo.views.photodetail

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import stw.jamez.kptestdemo.R
import stw.jamez.kptestdemo.base.BaseActivity
import stw.jamez.kptestdemo.databinding.ActivityPhotoDetailBinding

class PhotoDetailActivity:BaseActivity() {

    companion object {
        const val PHOTO_DATA = "PHOTO_DATA"
    }

    private val binding: ActivityPhotoDetailBinding by binding(R.layout.activity_photo_detail)
    private lateinit var viewModel: PhotoDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initToolbar()

        viewModel = ViewModelProvider(this).get(PhotoDetailViewModel::class.java)

        viewModel.apply {
            photoData.value = intent.getParcelableExtra(PHOTO_DATA)
            photoData.observe(this@PhotoDetailActivity, {
                binding.photoData = it
            })
        }

    }

    private fun initToolbar() {
        binding.detailToolbar.toolbar.apply {
            setNavigationIcon(R.drawable.ic_detail_back)
            setNavigationOnClickListener {
                this@PhotoDetailActivity.onBackPressed()
            }
        }
    }
}
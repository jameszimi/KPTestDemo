package stw.jamez.kptestdemo.views.photo

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import stw.jamez.kptestdemo.R
import stw.jamez.kptestdemo.base.BaseActivity
import stw.jamez.kptestdemo.databinding.ActivityMainBinding
import stw.jamez.kptestdemo.model.PhotoResponseItem
import stw.jamez.kptestdemo.views.photodetail.PhotoDetailActivity
import stw.jamez.kptestdemo.views.adapter.PhotoAdapter

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private lateinit var viewModel: MainViewModel

    fun interface PhotoCallback {
        fun photoOnClick(item: PhotoResponseItem, view: View)
    }

    private val mAdapter = PhotoAdapter { item, view ->
        val intent = Intent(this, PhotoDetailActivity::class.java)
        intent.putExtra(PhotoDetailActivity.PHOTO_DATA, item)
        val transitionName = ViewCompat.getTransitionName(view)
        val transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, view, transitionName)
        startActivity(intent, transitionActivityOptions.toBundle())

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.photoList.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

        viewModel.apply {
            getPhotoList()
            photoList.observe(this@MainActivity, {
                mAdapter.submitList(it)
            })
        }

    }
}
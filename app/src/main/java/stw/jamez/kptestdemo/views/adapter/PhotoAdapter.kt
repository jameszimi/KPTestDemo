package stw.jamez.kptestdemo.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import stw.jamez.kptestdemo.R
import stw.jamez.kptestdemo.databinding.ListItemPhotoBinding
import stw.jamez.kptestdemo.model.PhotoResponseItem
import stw.jamez.kptestdemo.views.photo.MainActivity

class PhotoAdapter(private val param: MainActivity.PhotoCallback) : ListAdapter<PhotoResponseItem, PhotoAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    class PhotoViewHolder(val binding: ListItemPhotoBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PhotoResponseItem, param: MainActivity.PhotoCallback) {
            binding.apply {
                setClickListener {
                    param.photoOnClick(item,binding.photoImage)
                }
                photoData = item
                executePendingBindings()
            }
        }
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, param)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_photo, parent, false))
    }
}

private class PhotoDiffCallback: DiffUtil.ItemCallback<PhotoResponseItem>() {
    override fun areItemsTheSame(oldItem: PhotoResponseItem, newItem: PhotoResponseItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoResponseItem, newItem: PhotoResponseItem): Boolean {
        return oldItem == newItem
    }


}
package com.example.albumswiever.ui.galerywiever

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.albumswiever.R
import com.example.albumswiever.data.model.Photo
import kotlinx.android.synthetic.main.galery_grid_recycler_item.view.*

/**
 * [RecyclerView.Adapter] that can display a grid of [Photo].
 */
class GaleryViewerRecyclerViewAdapter(
    private val photosValues: LiveData<List<Photo>?>?,
    private val glide: RequestManager
) : RecyclerView.Adapter<GaleryViewerRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.galery_grid_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photosValues?.value?.get(position)

        glide
            .load(photo?.photoUrl?.trim())
            .into(holder.photoItemImage)
    }

    override fun getItemCount(): Int = photosValues?.value?.size ?: 0

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val photoItemImage: AppCompatImageView = mView.gridItemImage as AppCompatImageView
    }
}
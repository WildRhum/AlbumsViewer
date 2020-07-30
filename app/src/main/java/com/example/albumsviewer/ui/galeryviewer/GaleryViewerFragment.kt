package com.example.albumsviewer.ui.galeryviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.albumsviewer.R
import com.example.albumsviewer.data.model.Album

class GaleryViewerFragment(val album: Album? = null) : Fragment() {

    private lateinit var mView: View
    private lateinit var viewModel: GaleryViewerViewModel

    companion object {
        fun newInstance(album: Album?) = GaleryViewerFragment(album)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.galery_wiever_fragment, container, false)

        viewModel = ViewModelProvider(this).get(GaleryViewerViewModel::class.java)

        album?.let { viewModel.setAlbumData(it) }

        viewModel.photos.observe(viewLifecycleOwner, Observer {
            mView.findViewById<RecyclerView>(R.id.galeryGridRecyclerView).adapter?.notifyDataSetChanged()
        })

        val toolbar = (activity as AppCompatActivity?)?.supportActionBar
        toolbar?.let {
            it.title = "Album : " + viewModel.getAlbum()?.albumTitle
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        mView.findViewById<RecyclerView>(R.id.galeryGridRecyclerView).adapter =
            GaleryViewerRecyclerViewAdapter(viewModel.photos, Glide.with(this))

        return mView
    }

    override fun onDetach() {
        super.onDetach()
        val toolbar = (activity as AppCompatActivity?)?.supportActionBar
        toolbar?.let {
            it.title = resources.getString(R.string.app_name)
            it.setDisplayHomeAsUpEnabled(false)
            it.setDisplayShowHomeEnabled(false)
        }
    }
}
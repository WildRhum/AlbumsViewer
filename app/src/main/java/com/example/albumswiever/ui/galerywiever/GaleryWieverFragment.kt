package com.example.albumswiever.ui.galerywiever

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
import com.example.albumswiever.R
import com.example.albumswiever.data.model.Album

class GaleryWieverFragment(val album: Album? = null) : Fragment() {

    private lateinit var mView: View
    private lateinit var viewModel: GaleryWieverViewModel

    companion object {
        fun newInstance(album: Album?) = GaleryWieverFragment(album)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.galery_wiever_fragment, container, false)

        viewModel = ViewModelProvider(this).get(GaleryWieverViewModel::class.java)

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
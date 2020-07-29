package com.example.albumswiever.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.albumswiever.R
import com.example.albumswiever.data.model.Album

class AlbumViewerFragment : Fragment() {

    private lateinit var viewModel: AlbumViewerModel
    private lateinit var mView: View
    private var listener: AlbumRecyclerViewClickListener? = null

    companion object {
        fun newInstance() = AlbumViewerFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(AlbumViewerModel::class.java)

        viewModel.albums.observe(requireActivity(), Observer {
            mView.findViewById<RecyclerView>(R.id.albumRecyclerView).adapter?.notifyDataSetChanged()
        })

        viewModel.users.observe(requireActivity(), Observer {
            mView.findViewById<RecyclerView>(R.id.albumRecyclerView).adapter?.notifyDataSetChanged()
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mView = inflater.inflate(R.layout.album_list, container, false)
        mView.findViewById<RecyclerView>(R.id.albumRecyclerView).adapter = AlbumViewerRecyclerViewAdapter(viewModel.albums, viewModel.users, listener)
        return mView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AlbumRecyclerViewClickListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement AlbumRecyclerViewClickListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface AlbumRecyclerViewClickListener {
        fun onAlbumRecyclerViewClick(item: Album?, position : Int)
    }
}
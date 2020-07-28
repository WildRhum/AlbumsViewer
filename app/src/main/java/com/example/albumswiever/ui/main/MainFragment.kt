package com.example.albumswiever.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.albumswiever.R

class MainFragment : Fragment(){

    private lateinit var viewModel: MainViewModel
    private lateinit var mView: View

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

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
        mView.findViewById<RecyclerView>(R.id.albumRecyclerView).adapter = AlbumViewerRecyclerViewAdapter(viewModel.albums, viewModel.users)
        return mView
    }
}
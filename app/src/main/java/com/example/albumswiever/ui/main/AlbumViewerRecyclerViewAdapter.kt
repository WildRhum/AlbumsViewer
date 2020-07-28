package com.example.albumswiever.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import com.example.albumswiever.R
import com.example.albumswiever.data.model.Album
import com.example.albumswiever.data.model.User

/**
 * [RecyclerView.Adapter] that can display a [Album.albumTitle] and [User.userName].
 */
class AlbumViewerRecyclerViewAdapter(
    private val albumsValues: LiveData<List<Album>>,
    private val usersValues: LiveData<List<User>>
) : RecyclerView.Adapter<AlbumViewerRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_list_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albumsValues.value?.get(position)
        holder.albumName.text = album?.albumTitle
        holder.albumAuthor.text = usersValues.value?.first { it.userId == album?.userId }?.userName
    }

    override fun getItemCount(): Int = albumsValues.value?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val albumName: TextView = view.findViewById(R.id.albumName)
        val albumAuthor: TextView = view.findViewById(R.id.albumAuthor)
    }
}
package com.example.albumswiever

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.albumswiever.data.model.Album
import com.example.albumswiever.ui.main.AlbumViewerFragment

class MainActivity : AppCompatActivity(),
    AlbumViewerFragment.AlbumRecyclerViewClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AlbumViewerFragment.newInstance())
                    .commitNow()
        }
    }

    override fun onAlbumRecyclerViewClick(item: Album?, position: Int) {
        Log.d("MainActivity", "Album clicked: ${item?.albumTitle} at $position position")
    }
}
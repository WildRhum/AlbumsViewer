package com.example.albumsviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.example.albumsviewer.data.model.Album
import com.example.albumsviewer.ui.albumviewer.AlbumViewerFragment
import com.example.albumsviewer.ui.galeryviewer.GaleryViewerFragment

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
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, GaleryViewerFragment.newInstance(item))
            .addToBackStack(null)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
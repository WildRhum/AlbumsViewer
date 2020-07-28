package com.example.albumswiever.data.repository

import com.example.albumswiever.data.model.Album
import com.example.albumswiever.data.model.Photo
import com.example.albumswiever.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumViewerService {

    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/albums")
    suspend fun getAlbums(): List<Album>

    @GET("/photos?albumId={albumId}")
    suspend fun getProductInfo(@Path("albumId") albumId: Int): List<Photo>
}
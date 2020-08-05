package com.example.albumsviewer.data.model

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName ("id") var albumId : Int,
    @SerializedName ("userId") var userId : Int,
    @SerializedName ("title") var albumTitle : String
)
package com.example.albumsviewer.data.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") var id : Int,
    @SerializedName ("albumId") var albumId : Int,
    @SerializedName ("thumbnailUrl") var photoUrl : String
)
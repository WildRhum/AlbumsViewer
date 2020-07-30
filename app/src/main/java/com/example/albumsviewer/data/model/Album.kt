package com.example.albumsviewer.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    @SerializedName ("id") var albumId : Int,
    @SerializedName ("userId") var userId : Int,
    @SerializedName ("title") var albumTitle : String
) : Parcelable
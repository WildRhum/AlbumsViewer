package com.example.albumswiever.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    var albumId : Int,
    var userId : Int,
    var albumTitle : String
) : Parcelable
package com.example.albumswiever.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    var id : Int,
    var albumId : Int,
    var photoUrl : String
) : Parcelable
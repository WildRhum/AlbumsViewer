package com.example.albumswiever.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var userId : Int,
    var userName : String
) : Parcelable
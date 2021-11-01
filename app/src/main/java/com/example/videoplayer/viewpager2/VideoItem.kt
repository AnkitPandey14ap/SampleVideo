package com.example.videoplayer.viewpager2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoItem(
    var videoURL: String? = "",
    public var videoTitle: String? = "",
    var videoDesc: String? = ""
) : Parcelable
package stw.jamez.kptestdemo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoResponseItem(
    val albumId: Int?,
    val id: Int?,
    val thumbnailUrl: String?,
    val title: String?,
    val url: String?
): Parcelable
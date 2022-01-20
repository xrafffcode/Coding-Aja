package com.masvatif.codingaja

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FreeClass(
    val imgClass: Int,
    val nameClass: String,
    val levelClass: String,
    val descClass: String,
) :Parcelable


package com.dicoding.androidfadhl

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Madrid(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable

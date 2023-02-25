package com.example.scanner

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class ExampleData(
    val data: String
) : Parcelable
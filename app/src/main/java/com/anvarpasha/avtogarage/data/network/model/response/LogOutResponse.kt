package com.anvarpasha.avtogarage.data.network.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LogOutResponse (
    @SerializedName("message")
    val message : String
) : Parcelable


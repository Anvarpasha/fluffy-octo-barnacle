package com.anvarpasha.avtogarage.data.network.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OtpResponse (
    @SerializedName("token")
    val token : String
) : Parcelable

@Parcelize
data class OtpMainResponse (
    @SerializedName("message")
    val message : String,
    @SerializedName("data")
    val data : OtpResponse
) : Parcelable
package com.anvarpasha.avtogarage.data.network.model.response

import android.os.Parcelable
import com.anvarpasha.avtogarage.data.network.model.remote.Order
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SingleOrderResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data : Order
) : Parcelable
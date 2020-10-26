package com.anvarpasha.avtogarage.data.network.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginResponse(
    @SerializedName("access_token")
    val access_token: String,
    @SerializedName("shop_id")
    val shopId: String
): Parcelable
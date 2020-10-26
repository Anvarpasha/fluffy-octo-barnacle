package com.anvarpasha.avtogarage.data.network.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    @SerializedName ("email")
    val email : String,
    @SerializedName ("shop_id")
    val shop_id : Int,
    @SerializedName ("otp_token")
    val otp_token : String,
    @SerializedName ("key_base_url")
    val key_base_url : String,
    @SerializedName ("token")
    val token : String

) : Parcelable
package com.anvarpasha.avtogarage.data.network.model.response

import android.os.Parcelable
import com.anvarpasha.avtogarage.data.network.model.remote.Profile
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileResponse (
   @SerializedName("message")
   val message : String,
   @SerializedName("data")
   val data : Profile
): Parcelable
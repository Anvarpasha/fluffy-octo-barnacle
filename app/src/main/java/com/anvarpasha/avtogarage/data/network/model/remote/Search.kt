package com.anvarpasha.avtogarage.data.network.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Search (
    @SerializedName("id")
    val id : Int,
    @SerializedName("createdDate")
    val createdData: String ,
    @SerializedName("productName")
    val productName : String,
    @SerializedName("network")
    val network : String,
    @SerializedName("statusId")
    val statusId : String,
    @SerializedName("statusName")
    val statusName : String,
    @SerializedName("statusColor")
    val statusColor : String
): Parcelable
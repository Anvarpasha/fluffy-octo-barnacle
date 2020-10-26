package com.anvarpasha.avtogarage.data.network.model.remote

import android.os.Parcelable
import com.anvarpasha.avtogarage.utils.DateUtils
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order(
    @SerializedName("id")
    val id: Int,
    @SerializedName("clientName")
    val clientName: String,
    @SerializedName("clientPhone")
    val clientPhone: String,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("carName")
    val carName: String,
    @SerializedName("carReleaseYear")
    val carReleaseYear: String,
    @SerializedName("carVin")
    val carVin: String,
    @SerializedName("createdDate")
    val createdData: String,
    @SerializedName("updatedDate")
    val updatedDate: String,
    @SerializedName("productName")
    val productName: String,
    @SerializedName("network")
    val network: String,
    @SerializedName("socialUrl")
    val socialUrl : String,
    @SerializedName("statusId")
    val statusId: Int,
    @SerializedName("statusName")
    val statusName: String,
    @SerializedName("statusColor")
    val statusColor: String
) : Parcelable {

}
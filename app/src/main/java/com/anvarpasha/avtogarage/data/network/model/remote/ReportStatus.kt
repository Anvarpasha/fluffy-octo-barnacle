package com.anvarpasha.avtogarage.data.network.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReportStatus (
    @SerializedName("id")
    val id : Int,
    @SerializedName("description")
    val description : String,
    @SerializedName("color")
    val color : String,
    @SerializedName("created_at")
    val created_at : String,
    @SerializedName("updated_at")
    val updated_at : String
) : Parcelable
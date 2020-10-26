package com.anvarpasha.avtogarage.data.network.model.response

import android.os.Parcelable
import com.anvarpasha.avtogarage.data.network.model.remote.ReportStatus
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReportStatusResponse (
    @SerializedName("message")
    val message : String,
    @SerializedName("data")
    val list : List<ReportStatus>
) : Parcelable
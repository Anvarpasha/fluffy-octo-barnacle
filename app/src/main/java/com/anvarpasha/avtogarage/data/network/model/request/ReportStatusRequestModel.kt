package com.anvarpasha.avtogarage.data.network.model.request

import com.google.gson.annotations.SerializedName

data class ReportStatusRequestModel(
    @SerializedName("descriptionId")
    val descriptionId: Int,
    @SerializedName("type")
    val type: Int)
package com.anvarpasha.avtogarage.data.network.model.request

import com.google.gson.annotations.SerializedName

data class OtpModel (
    @SerializedName("email")
    val email : String
)
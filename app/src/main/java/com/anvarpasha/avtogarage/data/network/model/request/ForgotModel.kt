package com.anvarpasha.avtogarage.data.network.model.request

import com.google.gson.annotations.SerializedName

data class ForgotModel(
    @SerializedName("code")
    val code: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password_confirmation")
    val newPassword: String,
    @SerializedName("otp_token")
    val otp_token: String
)



package com.anvarpasha.avtogarage.data.network.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile (
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("email")
    val email : String,
    @SerializedName("shopId")
    val shopId : Int,
    @SerializedName("shopName")
    val shopName : String,
    @SerializedName("shopCover")
    val shopCover : String,
    @SerializedName("shopLogo")
    val shopLogo : String
): Parcelable{

    val logoImg:String
    get() = "https://avtoqaraj.az/$shopLogo"
    val coverImg:String
    get() = "https://avtoqaraj.az/$shopCover"
}
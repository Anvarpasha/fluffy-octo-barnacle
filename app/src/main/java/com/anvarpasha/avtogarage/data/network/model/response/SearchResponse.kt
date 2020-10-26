package com.anvarpasha.avtogarage.data.network.model.response

import android.os.Parcelable
import com.anvarpasha.avtogarage.data.network.model.remote.Search
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResponse (
    @SerializedName("message")
    val message : String,
    @SerializedName("data")
    val list : List<Search>

): Parcelable
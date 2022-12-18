package com.management.hotelapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
class DataModel {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null
}
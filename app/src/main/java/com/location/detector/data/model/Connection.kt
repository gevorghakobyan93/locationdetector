package com.location.detector.data.model

import com.google.gson.annotations.SerializedName


data class Connection(

    @SerializedName("asn") var asn: Int? = null,
    @SerializedName("isp") var isp: String? = null

)
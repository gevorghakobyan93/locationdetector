package com.location.detector.data.model

import com.google.gson.annotations.SerializedName


data class TimeZone(

    @SerializedName("id") var id: String? = null,
    @SerializedName("currentTime") var currentTime: String? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("timeZoneName") var timeZoneName: String? = null,
    @SerializedName("utcOffset") var utcOffset: Int? = null

)
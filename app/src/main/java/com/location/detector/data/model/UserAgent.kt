package com.location.detector.data.model

import com.google.gson.annotations.SerializedName


data class UserAgent(

    @SerializedName("isMobile") var isMobile: Boolean? = null,
    @SerializedName("isiPod") var isiPod: Boolean? = null,
    @SerializedName("isTablet") var isTablet: Boolean? = null,
    @SerializedName("isDesktop") var isDesktop: Boolean? = null,
    @SerializedName("isSmartTV") var isSmartTV: Boolean? = null,
    @SerializedName("isRaspberry") var isRaspberry: Boolean? = null,
    @SerializedName("isBot") var isBot: Boolean? = null,
    @SerializedName("browser") var browser: String? = null,
    @SerializedName("browserVersion") var browserVersion: String? = null,
    @SerializedName("operatingSystem") var operatingSystem: String? = null,
    @SerializedName("platform") var platform: String? = null,
    @SerializedName("source") var source: String? = null

)
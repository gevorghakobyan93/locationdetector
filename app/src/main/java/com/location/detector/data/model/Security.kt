package com.location.detector.data.model

import com.google.gson.annotations.SerializedName


data class Security(

    @SerializedName("isProxy") var isProxy: Boolean? = null,
    @SerializedName("isBogon") var isBogon: Boolean? = null,
    @SerializedName("isTorExitNode") var isTorExitNode: Boolean? = null,
    @SerializedName("isCloud") var isCloud: Boolean? = null,
    @SerializedName("isHosting") var isHosting: Boolean? = null,
    @SerializedName("isSpamhaus") var isSpamhaus: Boolean? = null,
    @SerializedName("suggestion") var suggestion: String? = null,
    @SerializedName("network") var network: String? = null

)
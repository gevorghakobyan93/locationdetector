package com.location.detector.data.model

import com.google.gson.annotations.SerializedName


data class Currency(

    @SerializedName("code") var code: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("number") var number: String? = null,
    @SerializedName("rates") var rates: Rates? = Rates()

)


data class Rates(

    @SerializedName("EURUSD") var EURUSD: Double? = null

)
package com.location.detector.data.model

import com.google.gson.annotations.SerializedName


data class Languages(

    @SerializedName("en") var en: En? = En()

)

data class En(

    @SerializedName("code") var code: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("native") var native: String? = null

)
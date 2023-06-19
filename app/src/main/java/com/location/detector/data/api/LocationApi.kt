package com.location.detector.data.api

import com.location.detector.data.model.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "1aaddbe5-9bf6-46e1-b71b-a1d913f0d6d1"

interface LocationApi {

    @GET("check")
    suspend fun getLocationByIp(
        @Query("ip") ip: String = "67.250.186.196",
        @Query("accessKey") accessKey: String = API_KEY
    ): Response<Location>
}
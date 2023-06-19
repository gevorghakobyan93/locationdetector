package com.location.detector.data.repository

import com.location.detector.data.api.ApiResult
import com.location.detector.data.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    suspend fun getLocation(ip: String): Flow<ApiResult<Location>>
}
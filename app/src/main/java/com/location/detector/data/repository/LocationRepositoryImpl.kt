package com.location.detector.data.repository

import android.util.Log
import com.location.detector.data.api.ApiResult
import com.location.detector.data.api.LocationApi
import com.location.detector.data.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(var locationApi: LocationApi) :
    LocationRepository {

    override suspend fun getLocation(ip: String): Flow<ApiResult<Location>> = flow {
        emit(handleApi { locationApi.getLocationByIp(ip) })
    }
}

suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): ApiResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        Log.d("TAG", "handleApi: $body")
        if (response.isSuccessful && body != null) {
            ApiResult.Success(body)
        } else {
            ApiResult.Error(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        ApiResult.Error(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        ApiResult.Exception(e)
    }
}
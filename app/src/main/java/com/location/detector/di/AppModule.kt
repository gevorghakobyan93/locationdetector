package com.location.detector.di

import com.location.detector.data.api.LocationApi
import com.location.detector.data.repository.LocationRepository
import com.location.detector.data.repository.LocationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// @Module annotation which will make this class a module
// to inject dependency to other class within it's scope.
// @InstallIn(SingletonComponent::class) this will make
// this class to inject dependencies across the entire application.
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://apiip.net/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideLocationApi(retrofit: Retrofit): LocationApi =
        retrofit.create(LocationApi::class.java)

    @Provides
    @Singleton
    fun provideLocationRepository(locationApi: LocationApi): LocationRepository =
        LocationRepositoryImpl(locationApi)
}
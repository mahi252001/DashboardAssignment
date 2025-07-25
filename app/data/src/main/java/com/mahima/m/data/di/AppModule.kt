package com.mahima.m.data.di

import com.mahima.m.data.datasource.remote.ApiService
import com.mahima.m.data.datasource.remote.DashboardRemoteDatasource
import com.mahima.m.data.datasource.remote.internal.DashboardDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "https://mahima.free.beeceptor.com"

    @Provides
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideDashboardRepository(apiService: ApiService): DashboardRemoteDatasource =
        DashboardDatasourceImpl(apiService)
}
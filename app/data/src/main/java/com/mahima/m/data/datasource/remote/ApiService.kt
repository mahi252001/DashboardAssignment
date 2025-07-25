package com.mahima.m.data.datasource.remote

import com.mahima.m.data.model.Profile
import com.mahima.m.data.model.SystemConfig
import com.mahima.m.data.model.Transaction
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("profile")
    suspend fun getProfile(): Profile

    @GET("transactions")
    suspend fun getTransaction(
        @Query("userId") userId: String
    ): List<Transaction>

    @GET("config")
    suspend fun getConfig(): SystemConfig

}
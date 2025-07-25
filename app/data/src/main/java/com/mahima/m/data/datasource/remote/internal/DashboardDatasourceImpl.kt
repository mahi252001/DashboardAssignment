package com.mahima.m.data.datasource.remote.internal

import com.mahima.m.data.datasource.remote.DashboardRemoteDatasource
import com.mahima.m.data.model.Profile
import com.mahima.m.data.model.SystemConfig
import com.mahima.m.data.model.Transaction
import com.mahima.m.data.datasource.remote.ApiService
import javax.inject.Inject

internal class DashboardDatasourceImpl @Inject constructor(private val apiService: ApiService) :
    DashboardRemoteDatasource {
    override suspend fun getProfile(): Profile {
        return apiService.getProfile()
    }

    override suspend fun getTransactions(userId: String): List<Transaction> {
        return apiService.getTransaction(userId)
    }

    override suspend fun getSystemConfig(): SystemConfig {
        return apiService.getConfig()
    }

}
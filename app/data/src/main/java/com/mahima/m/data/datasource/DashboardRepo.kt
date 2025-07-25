package com.mahima.m.data.datasource

import com.mahima.m.data.datasource.remote.DashboardRemoteDatasource
import com.mahima.m.data.model.Profile
import com.mahima.m.data.model.SystemConfig
import com.mahima.m.data.model.Transaction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardRepo @Inject constructor(
    private val dashboardRemoteDatasource: DashboardRemoteDatasource
) {
    suspend fun getProfile(): Profile = dashboardRemoteDatasource.getProfile()

    suspend fun getTransactions(userId: String): List<Transaction> = dashboardRemoteDatasource.getTransactions(userId)

    suspend fun getSystemConfig(): SystemConfig = dashboardRemoteDatasource.getSystemConfig()
}
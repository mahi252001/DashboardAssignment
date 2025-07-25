package com.mahima.m.data.datasource.remote

import com.mahima.m.data.model.Profile
import com.mahima.m.data.model.SystemConfig
import com.mahima.m.data.model.Transaction

interface DashboardRemoteDatasource {

    suspend fun getProfile(): Profile

    suspend fun getTransactions(userId: String): List<Transaction>

    suspend fun getSystemConfig(): SystemConfig

}
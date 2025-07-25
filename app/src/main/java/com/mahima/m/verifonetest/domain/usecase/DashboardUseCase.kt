package com.mahima.m.verifonetest.domain.usecase

import com.mahima.m.verifonetest.core.utils.Result
import com.mahima.m.data.datasource.DashboardRepo
import com.mahima.m.verifonetest.domain.model.DashboardData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DashboardUseCase @Inject constructor(private val dashboardRepo: DashboardRepo) {

    operator fun invoke(): Flow<Result<DashboardData>> = flow {
        emit(Result.Loading)
        try {
            val profile = dashboardRepo.getProfile()
            val transactions = dashboardRepo.getTransactions(userId = profile.id.orEmpty())
            val systemConfig = dashboardRepo.getSystemConfig()
            emit(
                Result.Success(
                    DashboardData(
                        profile = profile,
                        transactions = transactions,
                        config = systemConfig
                    )
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(APIException("Something went wrong! Please try again.")))
        }


    }.flowOn(Dispatchers.IO)
}

data class APIException(val error : String) : Exception(error)
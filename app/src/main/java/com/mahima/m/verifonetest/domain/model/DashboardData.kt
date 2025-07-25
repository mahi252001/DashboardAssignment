package com.mahima.m.verifonetest.domain.model

import com.mahima.m.data.model.Profile
import com.mahima.m.data.model.SystemConfig
import com.mahima.m.data.model.Transaction

data class DashboardData(
    val profile: Profile?,
    val transactions: List<Transaction>,
    val config: SystemConfig?
)

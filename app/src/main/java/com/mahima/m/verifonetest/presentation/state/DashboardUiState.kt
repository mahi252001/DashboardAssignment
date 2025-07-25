package com.mahima.m.verifonetest.presentation.state

import com.mahima.m.verifonetest.domain.model.DashboardData

sealed class DashboardUiState {

    data object Loading : DashboardUiState()
    data class Success(val data: DashboardData) : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}
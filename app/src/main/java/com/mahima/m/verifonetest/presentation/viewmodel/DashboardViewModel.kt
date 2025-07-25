package com.mahima.m.verifonetest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahima.m.verifonetest.core.utils.Result
import com.mahima.m.verifonetest.domain.model.DashboardData
import com.mahima.m.verifonetest.domain.usecase.DashboardUseCase
import com.mahima.m.verifonetest.presentation.state.DashboardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardUseCase: DashboardUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun loadDashBoard() {
        viewModelScope.launch {
            dashboardUseCase().collect { result ->
                _uiState.value = when (result) {
                    is Result.Loading -> DashboardUiState.Loading
                    is Result.Error -> DashboardUiState.Error(result.throwable.message.orEmpty())
                    is Result.Success<DashboardData> -> DashboardUiState.Success(result.data)
                }

            }
        }
    }

}
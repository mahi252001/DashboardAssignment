package com.mahima.m.verifonetest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mahima.m.verifonetest.core.theme.VerifoneTestTheme
import com.mahima.m.verifonetest.presentation.screens.DashboardScreen
import com.mahima.m.verifonetest.presentation.screens.ErrorScreen
import com.mahima.m.verifonetest.presentation.screens.LoadingScreen
import com.mahima.m.verifonetest.presentation.state.DashboardUiState
import com.mahima.m.verifonetest.presentation.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerifoneTestTheme {

                val dashboardViewModel: DashboardViewModel = hiltViewModel()
                val state by dashboardViewModel.uiState.collectAsState()

                LaunchedEffect(Unit) {
                    dashboardViewModel.loadDashBoard()
                }

                when (state) {
                    is DashboardUiState.Loading -> LoadingScreen()

                    is DashboardUiState.Success -> DashboardScreen(data = (state as DashboardUiState.Success).data)

                    is DashboardUiState.Error -> ErrorScreen(
                        message = (state as DashboardUiState.Error).message,
                        onRetry = {
                            dashboardViewModel.loadDashBoard()
                        })
                }
            }
        }
    }
}
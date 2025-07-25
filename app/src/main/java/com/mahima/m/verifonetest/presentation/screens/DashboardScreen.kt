package com.mahima.m.verifonetest.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mahima.m.verifonetest.R
import com.mahima.m.verifonetest.core.theme.DarkBackground
import com.mahima.m.verifonetest.domain.model.DashboardData
import com.mahima.m.verifonetest.presentation.model.ThemeMode
import com.mahima.m.verifonetest.presentation.screens.item.TransactionItem

@Composable
fun DashboardScreen(data: DashboardData) {

    val themeMode = ThemeMode.from(data.config?.theme)
    val backgroundColor = if (themeMode is ThemeMode.Dark) DarkBackground else Color.White
    val contentColor = if (themeMode is ThemeMode.Dark) Color.White else DarkBackground

    Surface(modifier = Modifier, contentColor = contentColor, color = backgroundColor) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = stringResource(R.string.welcome, data.profile?.name.orEmpty()),
                style = MaterialTheme.typography.headlineSmall,
                color = contentColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.recent_transaction),
                style = MaterialTheme.typography.titleLarge,
                color = contentColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(data.transactions) { transaction ->
                    TransactionItem(
                        transaction = transaction,
                        showCounterParty = data.config?.showCounterPartyName
                    )
                }
            }

        }
    }
}
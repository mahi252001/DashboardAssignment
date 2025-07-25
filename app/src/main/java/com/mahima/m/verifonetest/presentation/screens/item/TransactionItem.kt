package com.mahima.m.verifonetest.presentation.screens.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mahima.m.verifonetest.R
import com.mahima.m.verifonetest.core.theme.CreditColor
import com.mahima.m.verifonetest.core.theme.DebitColor
import com.mahima.m.verifonetest.core.theme.FailedColor
import com.mahima.m.verifonetest.core.theme.PendingColor
import com.mahima.m.verifonetest.core.theme.SuccessColor
import com.mahima.m.data.model.Transaction
import com.mahima.m.verifonetest.presentation.model.TransactionStatus
import com.mahima.m.verifonetest.presentation.model.TransactionType

@Composable
fun TransactionItem(transaction: Transaction, showCounterParty: Boolean?) {

    val transactionType = TransactionType.from(transaction.type)
    val transactionStatus = TransactionStatus.from(transaction.status)

    val amountColor = when (transactionType) {
        TransactionType.Credit -> CreditColor
        TransactionType.Debit -> DebitColor
        TransactionType.Unknown -> Color.Unspecified
    }

    val statusColor = when (transactionStatus) {
        TransactionStatus.Failure -> FailedColor
        TransactionStatus.Pending -> PendingColor
        TransactionStatus.Success -> SuccessColor
        TransactionStatus.Unknown -> Color.Companion.Unspecified
    }

    val showDescriptionBelow = showCounterParty == true && !transaction.counterParty.isNullOrBlank()


    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = if (showCounterParty == true) {
                    transaction.counterParty.orEmpty()
                } else {
                    transaction.description.orEmpty()
                }, style = MaterialTheme.typography.bodyLarge
            )

            if (showDescriptionBelow) {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = transaction.description.orEmpty(),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = transaction.status.orEmpty(),
                    color = statusColor,
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    text = stringResource(R.string.amount, transaction.amount ?: 0f),
                    color = amountColor,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

}
package com.mahima.m.verifonetest.presentation.model

sealed class TransactionType(val type: String) {

    data object Credit : TransactionType("credit")
    data object Debit : TransactionType("debit")
    data object Unknown : TransactionType("")

    companion object {
        fun from(value: String?): TransactionType = when (value?.lowercase()) {
            "credit" -> Credit
            "debit" -> Debit
            else -> {
                Unknown
            }
        }
    }
}
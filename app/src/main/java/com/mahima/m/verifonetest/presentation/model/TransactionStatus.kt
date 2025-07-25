package com.mahima.m.verifonetest.presentation.model

sealed class TransactionStatus(val status: String) {
    data object Success : TransactionStatus("success")
    data object Pending : TransactionStatus("pending")
    data object Failure : TransactionStatus("failure")
    data object Unknown : TransactionStatus("")

    companion object {
        fun from(value: String?): TransactionStatus = when (value?.lowercase()) {
            "success" -> Success
            "pending" -> Pending
            "failure" -> Failure
            else -> {
                Unknown
            }
        }
    }
}
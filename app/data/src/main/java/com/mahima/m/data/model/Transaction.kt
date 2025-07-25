package com.mahima.m.data.model


data class Transaction(
    val id: String?,
    val amount: Float?,
    val timestamp: Long?,
    val type: String?,
    val description: String?,
    val status: String?,
    val counterParty: String?
)


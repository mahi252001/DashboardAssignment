package com.mahima.m.verifonetest.core.utils

sealed class Result<out T> {

    data object Loading: Result<Nothing>()
    data class Success<T>(val data: T): Result<T>()
    data class Error(val throwable: Throwable): Result<Nothing>()

}
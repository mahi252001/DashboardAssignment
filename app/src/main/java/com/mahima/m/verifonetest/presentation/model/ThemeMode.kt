package com.mahima.m.verifonetest.presentation.model

sealed class ThemeMode(val theme: String) {
    data object Light : ThemeMode("light")
    data object Dark : ThemeMode("dark")
    data object Unknown : ThemeMode("")

    companion object {
        fun from(value: String?): ThemeMode = when (value?.lowercase()) {
            "light" -> Light
            "dark" -> Dark
            else -> {
                Unknown
            }
        }
    }
}
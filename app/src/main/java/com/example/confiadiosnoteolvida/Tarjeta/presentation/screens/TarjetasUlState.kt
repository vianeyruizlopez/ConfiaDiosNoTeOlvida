package com.example.confiadiosnoteolvida.Tarjeta.presentation.screens

import com.example.confiadiosnoteolvida.Tarjeta.domain.entities.Tarjeta

data class TarjetasUlState (
    val isLoading: Boolean = false,
    val Tarjetas: List<Tarjeta> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)
package com.example.confiadiosnoteolvida.Tarjeta.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.confiadiosnoteolvida.Tarjeta.domain.usercases.GetTarjetaUseCase

class TarjetasViewModelFactory (
    private val getTarjetaUseCase: GetTarjetaUseCase
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TarjetasViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TarjetasViewModel(getTarjetaUseCase) as T////solo nos interesa esta linea
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
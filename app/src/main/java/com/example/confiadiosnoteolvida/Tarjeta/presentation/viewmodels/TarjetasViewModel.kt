package com.example.confiadiosnoteolvida.Tarjeta.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.example.confiadiosnoteolvida.Tarjeta.domain.entities.Tarjeta
import com.example.confiadiosnoteolvida.Tarjeta.domain.usercases.GetTarjetaUseCase
import com.example.confiadiosnoteolvida.Tarjeta.presentation.screens.TarjetasUlState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TarjetasViewModel (
    private val getTarjetaUseCase: GetTarjetaUseCase
): ViewModel() {
    private val _uiEstado = MutableStateFlow(TarjetasUlState())
    val uiEstado = _uiEstado.asStateFlow()

    private var listaCompleta: List<Tarjeta> = emptyList()

    init {
        cargarTarjetas()
    }

    private fun cargarTarjetas() {
        viewModelScope.launch {
            val resultado = getTarjetaUseCase()
            _uiEstado.update{ estadoActual ->
                resultado.fold(
                    onSuccess = { lista ->
                        listaCompleta = lista
                        estadoActual.copy(isLoading = false, Tarjetas = lista)
                    },
                    onFailure = { error ->
                        estadoActual.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }

    }


    fun filtrarTarjetas(texto: String) {
        val listaFiltrada = if (texto.isEmpty()) {
            listaCompleta
        } else {
            listaCompleta.filter { tarjeta ->
                tarjeta.categoria.contains(texto, ignoreCase = true) ||
                        tarjeta.texto.contains(texto, ignoreCase = true)
            }
        }
        _uiEstado.update { estadoActual ->
            estadoActual.copy(Tarjetas = listaFiltrada)
        }
    }
}


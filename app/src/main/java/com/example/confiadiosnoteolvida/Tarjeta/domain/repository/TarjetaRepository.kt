package com.example.confiadiosnoteolvida.Tarjeta.domain.repository

import com.example.confiadiosnoteolvida.Tarjeta.domain.entities.Tarjeta

interface TarjetaRepository {
    suspend fun getTarjetas(): List<Tarjeta>
}
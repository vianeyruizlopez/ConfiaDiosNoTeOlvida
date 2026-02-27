package com.example.confiadiosnoteolvida.Tarjeta.data.repository

import android.util.Log
import com.example.confiadiosnoteolvida.Tarjeta.data.datasources.api.TarjetasApi
import com.example.confiadiosnoteolvida.Tarjeta.data.datasources.mapper.toDomain
import com.example.confiadiosnoteolvida.Tarjeta.domain.entities.Tarjeta
import com.example.confiadiosnoteolvida.Tarjeta.domain.repository.TarjetaRepository

class TarjetaRepositoryImpl(
    private val api: TarjetasApi
) : TarjetaRepository {

    override suspend fun getTarjetas(): List<Tarjeta> {
        val response = api.getTarjetas()
        Log.d("Tarjetas",response.toString())
        return response.map { it.toDomain() }
    }

}
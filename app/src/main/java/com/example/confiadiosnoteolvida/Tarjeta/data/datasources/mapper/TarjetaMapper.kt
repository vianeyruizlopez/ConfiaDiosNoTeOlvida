package com.example.confiadiosnoteolvida.Tarjeta.data.datasources.mapper

import com.example.confiadiosnoteolvida.Tarjeta.data.datasources.models.TarjetaDto
import com.example.confiadiosnoteolvida.Tarjeta.domain.entities.Tarjeta

fun TarjetaDto.toDomain():Tarjeta{
    return Tarjeta(
        id = id,
        texto = texto,
        cita = cita,
        categoria = categoria
    )
}
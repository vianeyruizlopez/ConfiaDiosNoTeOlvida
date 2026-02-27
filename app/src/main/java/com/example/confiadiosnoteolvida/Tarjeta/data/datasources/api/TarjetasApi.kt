package com.example.confiadiosnoteolvida.Tarjeta.data.datasources.api

import com.example.confiadiosnoteolvida.Tarjeta.data.datasources.models.TarjetaDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TarjetasApi {
    @GET("tarjetas")
    suspend fun getTarjetas(): List<TarjetaDto>
    @POST("tarjetas")
    suspend fun crearTarjeta(@Body tarjeta: TarjetaDto): TarjetaDto
    @DELETE("tarjetas/{id}")
    suspend fun eliminarTarjeta(@Path("id") id: Int): TarjetaDto
}
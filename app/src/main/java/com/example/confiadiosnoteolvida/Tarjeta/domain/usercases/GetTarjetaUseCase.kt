package com.example.confiadiosnoteolvida.Tarjeta.domain.usercases

import com.example.confiadiosnoteolvida.Tarjeta.domain.entities.Tarjeta
import com.example.confiadiosnoteolvida.Tarjeta.domain.repository.TarjetaRepository

class GetTarjetaUseCase(
    private val repository: TarjetaRepository
) {
    suspend operator fun invoke(): Result<List<Tarjeta>>{
        return try {
            val Tarjeta = repository.getTarjetas()

            val filteredPosts = Tarjeta.filter { it.texto.isNotBlank() }

            if (filteredPosts.isEmpty()) {
                Result.failure(Exception("No se encontraron post válidos"))
            } else {
                Result.success(filteredPosts)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
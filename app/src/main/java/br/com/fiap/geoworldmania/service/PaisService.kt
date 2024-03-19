package br.com.fiap.geoworldmania.service

import br.com.fiap.geoworldmania.model.Pais
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PaisService {

    @GET("region/{continente}")
    fun getPaisByContinente(@Path("continente") continente: String): Call<List<Pais>>

}
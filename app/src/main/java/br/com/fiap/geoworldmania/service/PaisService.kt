package br.com.fiap.geoworldmania.service

import br.com.fiap.geoworldmania.model.Pais
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PaisService {

    //BASE-URL http://52.15.151.167:8000/



    //http://52.15.151.167:8000/Paises/?format=json&search=Europa
    @GET("Paises/?format=json&search={continente}")
    fun getPaisByContinente(@Path("continente") continente: String): Call<List<Pais>>

    //http://52.15.151.167:8000/Paises/?format=json&search=Alemanha
    @GET
    fun getPaisByNomePais(): Call<Pais>
}
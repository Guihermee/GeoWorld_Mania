package br.com.fiap.geoworldmania.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "http://52.15.151.167:8000/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getPaisByContinente(): PaisService {
        return retrofitFactory.create(PaisService::class.java)
    }
}
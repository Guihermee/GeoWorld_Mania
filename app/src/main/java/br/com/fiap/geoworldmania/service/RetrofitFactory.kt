package br.com.fiap.geoworldmania.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "https://restcountries.com/v3.1/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getPaisService(): PaisService {
        return retrofitFactory.create(PaisService::class.java)
    }
}